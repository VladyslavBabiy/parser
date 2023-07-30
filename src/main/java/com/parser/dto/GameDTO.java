package com.parser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameDTO {
    private Long id;
    private String name;
    private String nameDefault;
    private ArrayList<CompetitorDTO> competitors;
    private Long kickoff;
    private Long lastUpdated;
    private LeagueDTO league;
    private String betline;
    private Boolean open;
    private String status;
    @JsonProperty("native")
    private Boolean isNative;
    private String widgetType;
    private Boolean widgetVirtual;
    private String url;
    private String matchPhase;
    private Boolean hasMarketWithZeroMargin;
    private ArrayList<MarketDTO> markets;
    private Integer runnersCount;
}
