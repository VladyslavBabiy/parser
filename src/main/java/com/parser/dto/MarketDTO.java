package com.parser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketDTO {
    private String id;
    private String name;
    private String marketTypeId;
    @JsonProperty("open")
    private boolean myopen;
    private boolean hasZeroMargin;
    private boolean primary;
    private int cols;
    private List<RunnerDTO> runners;
    private List<String> selectionTypes;
    private String handicap;
}
