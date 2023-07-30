package com.parser.parsers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.parser.dto.LeagueDTO;
import com.parser.dto.RegionDTO;
import com.parser.dto.SportDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TopLeagueParser {
    @Value("${leon.bets.league.url}")
    private String leagueUrl;

    private final RestTemplate restTemplate;
    private final GameParser gameParser;

    public void parseTopLeagueUrl() throws JsonProcessingException {
        List<SportDTO> sports = restTemplate.exchange(leagueUrl, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<SportDTO>>() {
        }).getBody();
        List<SportDTO> sportWithTopLeague = getSportWithTopLeage(sports);
        gameParser.parseGame(sportWithTopLeague);
    }

    private List<SportDTO> getSportWithTopLeage(List<SportDTO> sports) {
        return sports.stream()
                .filter(sport -> sport.getRegions().stream().anyMatch(region -> region.getLeagues().stream().anyMatch(LeagueDTO::isTop)))
                .map(sport -> {
                    SportDTO sportDTO = new SportDTO();
                    sportDTO.setId(sport.getId());
                    sportDTO.setName(sport.getName());
                    sportDTO.setWeight(sport.getWeight());
                    sportDTO.setFamily(sport.getFamily());
                    List<RegionDTO> topRegions = sport.getRegions().stream()
                            .map(region -> {
                                RegionDTO regionDTO = new RegionDTO();
                                regionDTO.setId(region.getId());
                                regionDTO.setName(region.getName());
                                regionDTO.setNameDefault(region.getNameDefault());
                                regionDTO.setFamily(region.getFamily());
                                regionDTO.setUrl(region.getUrl());
                                List<LeagueDTO> topLeaguesInRegion = region.getLeagues().stream()
                                        .filter(LeagueDTO::isTop)
                                        .collect(Collectors.toList());
                                regionDTO.setLeagues(topLeaguesInRegion);
                                return regionDTO;
                            })
                            .filter(region -> !region.getLeagues().isEmpty()) // Ignore regions without top leagues
                            .collect(Collectors.toList());
                    sportDTO.setRegions(topRegions);
                    return sportDTO;
                })
                .collect(Collectors.toList());
    }

}
