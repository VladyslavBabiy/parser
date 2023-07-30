package com.parser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketGroupDTO {
    private String id;
    private String name;
    private List<String> marketTypeIds;
    private boolean virtual;
}
