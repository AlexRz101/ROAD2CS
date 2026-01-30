package com.road2cs.dtos;

import lombok.Getter;
import lombok.Setter;

/*
Data Transfer Object used for including necessary fields
Best used in order to exclude unnecessary fields
Don't touch for now, WIP
 */
@Getter
@Setter
public class RoadmapRequestDTO {
    private int years;
    private String workload;
    private boolean summer;
    private boolean winter;
}
