package com.road2cs;

//Project imports
import com.road2cs.dtos.RoadmapRequestDTO;
import com.road2cs.dtos.RoadmapResponseDTO;
import com.road2cs.services.Road2CSService;
import com.road2cs.services.TemplateService;

//General Spring imports
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//Assert testing imports
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class Road2CsApplicationTests {

    private final Road2CSService road2CSService;
    private final TemplateService templateService;

    @Autowired
    public Road2CsApplicationTests(Road2CSService road2CSService,
                                   TemplateService templateService) {
        this.road2CSService = road2CSService;
        this.templateService = templateService;
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
    void shouldThrowOnInvalidTemplate4() {
        RoadmapRequestDTO request = new RoadmapRequestDTO(100, "invalid", true, false, "gigachad");
        assertThrows(IllegalArgumentException.class, () -> road2CSService.generateResponse(request));
    }

    @Test
    void shouldThrowOnEmptyRequest() {
        RoadmapRequestDTO request = new RoadmapRequestDTO();
        assertThrows(IllegalArgumentException.class, () -> road2CSService.generateResponse(request));
    }

    @Test
    void shouldReturnHeavyDefaultRoadmap() {
        RoadmapRequestDTO request = new RoadmapRequestDTO(4, "heavy", false, false, "nothing");
        RoadmapResponseDTO response = road2CSService.generateResponse(request);
        assertNotNull(response);
        assertEquals(4, response.getYears()); //General comparison assertion
        assertEquals("heavy", response.getWorkload());
        assertFalse(response.getTemplate().isSummer()); //Boolean assertion
        assertFalse(response.getTemplate().isWinter());
        assertTrue(response.getUnits() >= 120);
        assertEquals(templateService.getTemplate("CS-4YEAR-HEAVY-SE-2024"), response.getTemplate());
    }

    @Test
    void shouldReturnHeavyMLRoadmap() {
        RoadmapRequestDTO request = new RoadmapRequestDTO(4, "heavy", false, false, "machine learning");
        RoadmapResponseDTO response = road2CSService.generateResponse(request);
        assertNotNull(response);
        assertEquals(4, response.getYears());
        assertEquals("heavy", response.getWorkload());
        assertFalse(response.getTemplate().isSummer());
        assertFalse(response.getTemplate().isWinter());
        assertTrue(response.getUnits() >= 120);
        assertEquals("machine learning", response.getChosenField());
        assertEquals(templateService.getTemplate("CS-4YEAR-HEAVY-ML-2024"), response.getTemplate());
    }

    @Test
    void shouldReturnHeavyWDRoadmap() {
        RoadmapRequestDTO request = new RoadmapRequestDTO(4, "heavy", false, false, "web development");
        RoadmapResponseDTO response = road2CSService.generateResponse(request);
        assertNotNull(response);
        assertEquals(4, response.getYears());
        assertEquals("heavy", response.getWorkload());
        assertFalse(response.getTemplate().isSummer());
        assertFalse(response.getTemplate().isWinter());
        assertTrue(response.getUnits() >= 120);
        assertEquals("web development", response.getChosenField());
        assertEquals(templateService.getTemplate("CS-4YEAR-HEAVY-WD-2024"), response.getTemplate());
    }

    @Test
    void shouldReturn4YearDefaultMediumRoadmap() {
        RoadmapRequestDTO request = new RoadmapRequestDTO(4, "medium", false, false, "nothing");
        RoadmapResponseDTO response = road2CSService.generateResponse(request);
        assertNotNull(response);
        assertEquals(4, response.getYears());
        assertEquals("medium", response.getWorkload());
        assertFalse(response.getTemplate().isSummer());
        assertFalse(response.getTemplate().isWinter());
        assertTrue(response.getUnits() >= 120);
        assertEquals(templateService.getTemplate("CS-4YEAR-MEDIUM-SE-2024"), response.getTemplate());
    }


    @Test
    void shouldReturn4YearMLMediumRoadmap() {
        RoadmapRequestDTO request = new RoadmapRequestDTO(4, "medium", false, false, "machine learning");
        RoadmapResponseDTO response = road2CSService.generateResponse(request);
        assertNotNull(response);
        assertEquals(4, response.getYears());
        assertEquals("medium", response.getWorkload());
        assertFalse(response.getTemplate().isSummer());
        assertFalse(response.getTemplate().isWinter());
        assertTrue(response.getUnits() >= 120);
        assertEquals("machine learning", response.getChosenField());
        assertEquals(templateService.getTemplate("CS-4YEAR-MEDIUM-ML-2024"), response.getTemplate());
    }

    @Test
    void shouldReturn4YearWDMediumRoadmap() {
        RoadmapRequestDTO request = new RoadmapRequestDTO(4, "medium", false, false, "web development");
        RoadmapResponseDTO response = road2CSService.generateResponse(request);
        assertNotNull(response);
        assertEquals(4, response.getYears());
        assertEquals("medium", response.getWorkload());
        assertFalse(response.getTemplate().isSummer());
        assertFalse(response.getTemplate().isWinter());
        assertTrue(response.getUnits() >= 120);
        assertEquals("web development", response.getChosenField());
        assertEquals(templateService.getTemplate("CS-4YEAR-MEDIUM-WD-2024"), response.getTemplate());
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
        assertTrue(response.getUnits() >= 120);
        assertEquals(templateService.getTemplate("CS-4YEAR-LIGHT-SE-2024"), response.getTemplate());
    }

    @Test
    void shouldReturn4YearCSLightRoadmap() {
        RoadmapRequestDTO request = new RoadmapRequestDTO(4, "light", true, true, "cYBERSECurity");
        RoadmapResponseDTO response = road2CSService.generateResponse(request);
        assertNotNull(response);
        assertEquals(4, response.getYears());
        assertEquals("light", response.getWorkload());
        assertTrue(response.getTemplate().isSummer());
        assertTrue(response.getTemplate().isWinter());
        assertTrue(response.getUnits() >= 120);
        assertEquals(templateService.getTemplate("CS-4YEAR-LIGHT-CS-2024"), response.getTemplate());
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
        assertTrue(response.getUnits() >= 120);
        assertEquals(templateService.getTemplate("CS-5YEAR-LIGHT-SE-2024"), response.getTemplate());
    }

    @Test
    void shouldReturn5YearDSLightRoadmap() {
        RoadmapRequestDTO request = new RoadmapRequestDTO(5, "light", false, false, "dATA science");
        RoadmapResponseDTO response = road2CSService.generateResponse(request);
        assertNotNull(response);
        assertEquals(5, response.getYears());
        assertEquals("light", response.getWorkload());
        assertFalse(response.getTemplate().isSummer());
        assertFalse(response.getTemplate().isWinter());
        assertTrue(response.getUnits() >= 120);
        assertEquals(templateService.getTemplate("CS-5YEAR-LIGHT-DS-2024"), response.getTemplate());
    }

    @Test
    void shouldReturnPTLightRoadmap() {
        RoadmapRequestDTO request = new RoadmapRequestDTO(6, "light", false, false, "joemama");
        RoadmapResponseDTO response = road2CSService.generateResponse(request);
        assertNotNull(response);
        assertEquals(6, response.getYears());
        assertEquals("light", response.getWorkload());
        assertFalse(response.getTemplate().isSummer());
        assertFalse(response.getTemplate().isWinter());
        assertTrue(response.getUnits() >= 120);
        assertEquals(templateService.getTemplate("CS-PART-TIME-SE-2024"), response.getTemplate());
    }

    @Test
    void shouldReturnPTGDLightRoadmap() {
        RoadmapRequestDTO request = new RoadmapRequestDTO(6, "light", false, false, "game DEVELOPMENT");
        RoadmapResponseDTO response = road2CSService.generateResponse(request);
        assertNotNull(response);
        assertEquals(6, response.getYears());
        assertEquals("light", response.getWorkload());
        assertFalse(response.getTemplate().isSummer());
        assertFalse(response.getTemplate().isWinter());
        assertTrue(response.getUnits() >= 120);
        assertEquals(templateService.getTemplate("CS-PART-TIME-GD-2024"), response.getTemplate());
    }
}
