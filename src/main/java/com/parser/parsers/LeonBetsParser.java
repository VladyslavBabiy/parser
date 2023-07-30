package com.parser.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LeonBetsParser {

    private TopLeagueParser topLeagueParser;
    @Scheduled(fixedDelay = 50000)
    public void parse() throws JsonProcessingException {
        topLeagueParser.parseTopLeagueUrl();
    }
}
