package com.parser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class MainMarketDTO {
    private String id;
    private String name;
    private int weight;
    private ArrayList<Object> altMarketTypeIds;
    private boolean virtual;
}
