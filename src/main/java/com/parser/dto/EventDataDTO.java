package com.parser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDataDTO {
    private Long id;
    private String name;
    private String nameDefault;
    private long kickoff;
    private long lastUpdated;
    private String betline;
    private boolean open;
    private String status;
    private boolean nativeStatus;
    private String widgetType;
    private boolean widgetVirtual;
    private String url;
    private String matchPhase;
    private boolean hasMarketWithZeroMargin;
    private int marketsCount;
}
