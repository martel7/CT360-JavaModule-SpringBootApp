package com.example.ct360JavaModule.controllers;

import com.example.ct360JavaModule.repos.LanguageRepository;
import com.example.ct360JavaModule.registration.RegistrationRequest;
import com.example.ct360JavaModule.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "register")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;
    private LanguageRepository languageRepository;

    @PostMapping
    public void register(@RequestBody RegistrationRequest request){

        registrationService.register(request);

//        return languageRepository.findByLanguage("hebrew").toString();
    }
}
