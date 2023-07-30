package com.parser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegionDTO {
    private String id;
    private String name;
    private String nameDefault;
    private String family;
    private String url;
    private List<LeagueDTO> leagues;
}
