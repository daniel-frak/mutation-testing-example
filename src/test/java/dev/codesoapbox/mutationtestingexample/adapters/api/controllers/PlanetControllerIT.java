package dev.codesoapbox.mutationtestingexample.adapters.api.controllers;

import dev.codesoapbox.mutationtestingexample.domain.model.Planet;
import dev.codesoapbox.mutationtestingexample.domain.repositories.PlanetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlanetController.class)
class PlanetControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlanetRepository planetRepository;

    @Test
    void shouldFindAllPlanets() throws Exception {
        when(planetRepository.findAll())
                .thenReturn(singletonList(new Planet("Omicron Persei 8", true)));

        var expectedJson = """
                [
                  {
                    "name": "Omicron Persei 8",
                    "habitable": true
                  }
                ]
                """;
        mockMvc.perform(get("/planets"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

@Test
void shouldFindAllHabitablePlanets() throws Exception {
    when(planetRepository.findHabitable())
            .thenReturn(singletonList(new Planet("Omicron Persei 8", false)));

    // This is a weak test as it does not verify the response
    mockMvc.perform(get("/planets?habitable=true"))
            .andDo(print())
            .andExpect(status().isOk());
}
}