package com.road2cs.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoadmapRequestDTO {
    @Min(value = 4, message = "Years must be at least 4")
    @Max(value = 6, message = "Years cannot exceed 6")
    private int years;

    private String workload;

    private boolean summer;
    private boolean winter;

    private String chosenField;
}