package com.road2cs.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoadmapRequestDTO {
    @Min(value = 4, message = "Years must be at least 4")
    @Max(value = 6, message = "Years cannot exceed 6")
    private int years;

    //Make sure workload is light, medium or heavy
    @NotBlank(message = "Workload is required")
    @Pattern(regexp = "^(?i)(light|medium|heavy)$",
            message = "Workload must be light, moderate, or heavy")
    private String workload;

    private boolean summer;
    private boolean winter;

    private String chosenField;
}