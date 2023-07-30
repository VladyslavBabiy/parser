package com.parser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDTO {
    private boolean enabled;
    private int totalCount;
    private String vtag;
    private List<EventDataDTO> data;
}
