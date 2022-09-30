package com.example.ct360JavaModule.services;

import com.example.ct360JavaModule.repos.LanguageRepository;
import com.example.ct360JavaModule.entities.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LanguageService {

    private final LanguageRepository languageRepository;
    public void saveNewLanguage(Language language){
        languageRepository.save(language);
    }
}
