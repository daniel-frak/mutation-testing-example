package dev.codesoapbox.mutationtestingexample.config;

import dev.codesoapbox.mutationtestingexample.adapters.persistence.PlanetInMemoryRepository;
import dev.codesoapbox.mutationtestingexample.domain.repositories.PlanetRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    PlanetRepository planetRepository() {
        return new PlanetInMemoryRepository();
    }
}
