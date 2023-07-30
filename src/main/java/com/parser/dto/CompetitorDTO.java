package com.parser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompetitorDTO {
    private String id;
    private String name;
    private String homeAway;
    private String logoSource;
    private String logo;
}
