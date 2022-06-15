package dev.codesoapbox.mutationtestingexample.adapters.api.controllers;

import dev.codesoapbox.mutationtestingexample.domain.model.Planet;
import dev.codesoapbox.mutationtestingexample.domain.repositories.PlanetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("planets")
@RequiredArgsConstructor
public class PlanetController {

    private final PlanetRepository planetRepository;

    @GetMapping
    public List<Planet> findAllPlanets(@RequestParam(name = "habitable", required = false) Boolean habitable) {
        if (habitable == null) {
            return planetRepository.findAll();
        } else if (habitable) {
            return planetRepository.findHabitable();
        } else {
            return planetRepository.findUninhabitable();
        }
    }
}
