package com.road2cs.dtos;

import lombok.*;

/*
Data Transfer Object used for including necessary fields
Best used in order to exclude unnecessary fields
Don't touch for now, WIP
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoadmapRequestDTO {
    private int years;
    private String workload;
    private boolean summer;
    private boolean winter;
    private String chosenField;
}
