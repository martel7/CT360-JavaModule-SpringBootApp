package com.example.ct360JavaModule.repos;

import com.example.ct360JavaModule.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {

    Language findByLanguage(String language);
}
