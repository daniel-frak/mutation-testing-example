package dev.codesoapbox.mutationtestingexample.adapters.persistence;

import dev.codesoapbox.mutationtestingexample.domain.model.Planet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlanetInMemoryRepositoryTest {

    private PlanetInMemoryRepository planetInMemoryRepository;

    @BeforeEach
    void setUp() {
        planetInMemoryRepository = new PlanetInMemoryRepository();
    }

    @Test
    void shouldFindAll() {
        List<Planet> result = planetInMemoryRepository.findAll();

        assertEquals(2, result.size());
    }

    @Test
    void shouldFindHabitable() {
        List<Planet> result = planetInMemoryRepository.findHabitable();

        assertEquals(1, result.size());
        assertTrue(result.get(0).isHabitable());
    }
}