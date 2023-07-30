package com.parser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SportDTO {
    private long id;
    private String name;
    private int weight;
    private String family;
    private List<RegionDTO> regions;
    private ArrayList<MainMarketDTO> mainMarkets;
    private String url;
    private ArrayList<MarketGroupDTO> marketGroups;
}
