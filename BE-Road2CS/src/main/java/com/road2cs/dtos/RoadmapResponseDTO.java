package com.road2cs.dtos;

import com.road2cs.storage.Template;
import com.road2cs.services.TemplatesService

public class RoadmapResponseDTO {
    private int years;
    private String workload;
    private boolean summer;
    private boolean winter;
    private int units;
    private Template template;
    private int recommendedUnits;
}
