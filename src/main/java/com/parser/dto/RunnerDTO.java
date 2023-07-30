package com.parser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RunnerDTO {
    private String id;
    private String name;
    private boolean open;
    private int r;
    private int c;
    private ArrayList<String> tags;
    private double price;
    private String priceStr;
    private String handicap;
}
