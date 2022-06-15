package dev.codesoapbox.mutationtestingexample.adapters.persistence;

import dev.codesoapbox.mutationtestingexample.domain.model.Planet;
import dev.codesoapbox.mutationtestingexample.domain.repositories.PlanetRepository;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class PlanetInMemoryRepository implements PlanetRepository {

    private final List<Planet> planets;

    public PlanetInMemoryRepository() {
        planets = new ArrayList<>(List.of(
                new Planet("Omicron Persei 8", true),
                new Planet("Keppler 5", false)
        ));
    }

    @Override
    public List<Planet> findAll() {
        return planets;
    }

    @Override
    public List<Planet> findHabitable() {
        return planets.stream()
                .filter(Planet::isHabitable)
                .collect(toList());
    }

    @Override
    public List<Planet> findUninhabitable() {
        return planets.stream()
                .filter(planet -> !planet.isHabitable())
                .collect(toList());
    }
}
