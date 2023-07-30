package com.parser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueDTO {
    private Long id;
    private String name;
    private String nameDefault;
    private String url;
    private int weight;
    private int prematch;
    private int inplay;
    private int outright;
    private boolean top;
    private int topOrder;
    private boolean hasZeroMarginEvents;
    private RegionDTO region;
}
