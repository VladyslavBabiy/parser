package com.parser.parsers;

import com.parser.dto.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
@Slf4j
public class GameParser {
    @Value("${leon.bets.leagues.game.url}")
    private String leagueUrl;
    @Value("${leon.bets.leagues.event.url}")
    private String eventUrl;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss.SSSSSS Z");

    private final RestTemplate restTemplate;

    public void parseGame(List<SportDTO> sports) {
        for (SportDTO sportDTO : sports) {
            List<LeagueDTO> leagues = sportDTO.getRegions().stream().map(region -> region.getLeagues()).flatMap(List::stream).collect(Collectors.toList());
            for (LeagueDTO league : leagues) {
                log.info("{}, {}",sportDTO.getName(), league.getName());
                EventDTO eventDTO = restTemplate.getForObject(leagueUrl + league.getId(), EventDTO.class);
                for (EventDataDTO game : eventDTO.getData()) {
                    GameDTO gameDTO = restTemplate.exchange(eventUrl + game.getId(), HttpMethod.GET, HttpEntity.EMPTY, GameDTO.class).getBody();
                    LocalDateTime localDateTime = new Timestamp(gameDTO.getKickoff()).toInstant()
                            .atZone(ZoneId.of("UTC"))
                            .toLocalDateTime();
                    ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
                    log.info("    {}, {}, {}", gameDTO.getName(), zonedDateTime, gameDTO.getId());
                    for (MarketDTO marketDTO : gameDTO.getMarkets()) {
                        log.info("        {}", marketDTO.getName());
                        for (RunnerDTO runnerDTO : marketDTO.getRunners()) {
                            log.info("            {}, {}, {}", runnerDTO.getName(), runnerDTO.getPrice(), runnerDTO.getId());
                        }
                    }
                }
            }
        }
    }
}
