package com.example.ct360JavaModule.entities;

import com.example.ct360JavaModule.repos.LanguageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class LoadLanguages {

    private static final Logger log = LoggerFactory.getLogger(LoadLanguages.class);

    @Bean
    @Order(1)
    CommandLineRunner initDB(LanguageRepository repo){

        return args -> {
            log.info("Preloading: " + repo.save(new Language("serbian", "Здраво свете!")));
            log.info("Preloading: " + repo.save(new Language("bulgarian", "Здравей свят!")));
            log.info("Preloading: " + repo.save(new Language("czech", "Ahoj světe!")));
            log.info("Preloading: " + repo.save(new Language("georgian", "გამარჯობა მსოფლიო!")));
            log.info("Preloading: " + repo.save(new Language("hindi", "नमस्ते दुनिया!")));
            log.info("Preloading: " + repo.save(new Language("polish", "Witaj świecie!")));
            log.info("Preloading: " + repo.save(new Language("hebrew", "שלום עולם!")));
            log.info("Preloading: " + repo.save(new Language("german", "Hallo Welt!")));
            log.info("Preloading: " + repo.save(new Language("danish", "Hej Verden!")));
            log.info("Preloading: " + repo.save(new Language("french", "Bonjour monde!")));
        };
    }
}
