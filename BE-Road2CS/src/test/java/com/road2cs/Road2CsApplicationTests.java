package com.road2cs;

//Project imports
import com.road2cs.dtos.RoadmapRequestDTO;
import com.road2cs.dtos.RoadmapResponseDTO;
import com.road2cs.services.Road2CSService;
import com.road2cs.services.TemplatesService;

//General Spring imports
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//Assert testing imports
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class Road2CsApplicationTests {

    private final Road2CSService road2CSService;
    private final TemplatesService templatesService;

    @Autowired
    public Road2CsApplicationTests(Road2CSService road2CSService,
                                   TemplatesService templatesService) {
        this.road2CSService = road2CSService;
        this.templatesService = templatesService;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void shouldThrowOnInvalidTemplate1() {
        RoadmapRequestDTO request = new RoadmapRequestDTO(4, "yeetus", false, false, "nothing");
        assertThrows(IllegalArgumentException.class, () -> road2CSService.generateResponse(request));
    }

    @Test
    void shouldThrowOnInvalidTemplate2() {
        RoadmapRequestDTO request = new RoadmapRequestDTO(67, "medium", false, false, "nothing");
        assertThrows(IllegalArgumentException.class, () -> road2CSService.generateResponse(request));
    }

    @Test
    void shouldThrowOnInvalidTemplate3() {
        RoadmapRequestDTO request = new RoadmapRequestDTO(5, "heavy", true, true, "nothing");
        assertThrows(IllegalArgumentException.class, () -> road2CSService.generateResponse(request));
    }

    @Test
    void shouldThrowOnEmptyRequest() {
        RoadmapRequestDTO request = new RoadmapRequestDTO();
        assertThrows(IllegalArgumentException.class, () -> road2CSService.generateResponse(request));
    }

    @Test
    void shouldReturnHeavyRoadmap() {
        RoadmapRequestDTO request = new RoadmapRequestDTO(4, "heavy", false, false, "nothing");
        RoadmapResponseDTO response = road2CSService.generateResponse(request);
        assertNotNull(response);
        assertEquals(4, response.getYears()); //General comparison assertion
        assertEquals("heavy", response.getWorkload());
        assertFalse(response.getTemplate().isSummer()); //Boolean assertion
        assertFalse(response.getTemplate().isWinter());
        assertTrue(response.getUnits() >= 100);
        assertEquals(templatesService.getTemplate("CS-4YEAR-HEAVY-2024"), response.getTemplate());
    }

    @Test
    void shouldReturn4YearMediumRoadmap() {
        RoadmapRequestDTO request = new RoadmapRequestDTO(4, "medium", false, false, "nothing");
        RoadmapResponseDTO response = road2CSService.generateResponse(request);
        assertNotNull(response);
        assertEquals(4, response.getYears());
        assertEquals("medium", response.getWorkload());
        assertFalse(response.getTemplate().isSummer());
        assertFalse(response.getTemplate().isWinter());
        assertTrue(response.getUnits() >= 100);
        assertEquals(templatesService.getTemplate("CS-4YEAR-MEDIUM-2024"), response.getTemplate());
    }

    @Test
    void shouldReturn4YearLightRoadmap() {
        RoadmapRequestDTO request = new RoadmapRequestDTO(4, "light", true, true, "nothing");
        RoadmapResponseDTO response = road2CSService.generateResponse(request);
        assertNotNull(response);
        assertEquals(4, response.getYears());
        assertEquals("light", response.getWorkload());
        assertTrue(response.getTemplate().isSummer());
        assertTrue(response.getTemplate().isWinter());
        assertTrue(response.getUnits() >= 100);
        assertEquals(templatesService.getTemplate("CS-4YEAR-LIGHT-2024"), response.getTemplate());
    }

    @Test
    void shouldReturn5YearLightRoadmap() {
        RoadmapRequestDTO request = new RoadmapRequestDTO(5, "light", false, false, "nothing");
        RoadmapResponseDTO response = road2CSService.generateResponse(request);
        assertNotNull(response);
        assertEquals(5, response.getYears());
        assertEquals("light", response.getWorkload());
        assertFalse(response.getTemplate().isSummer());
        assertFalse(response.getTemplate().isWinter());
        assertTrue(response.getUnits() >= 100);
        assertEquals(templatesService.getTemplate("CS-5YEAR-LIGHT-2024"), response.getTemplate());
    }
}
