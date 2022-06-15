package dev.codesoapbox.mutationtestingexample.domain.repositories;

import dev.codesoapbox.mutationtestingexample.domain.model.Planet;

import java.util.List;

public interface PlanetRepository {

    List<Planet> findAll();

    List<Planet> findHabitable();

    List<Planet> findUninhabitable();
}
