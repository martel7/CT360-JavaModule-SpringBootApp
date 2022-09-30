package com.example.ct360JavaModule.controllers;

import com.example.ct360JavaModule.repos.LanguageRepository;
import com.example.ct360JavaModule.services.LanguageService;
import com.example.ct360JavaModule.entities.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Profile("db")
@RestController
public class SimpleController {

    @Autowired
    private LanguageRepository repo;
    @Autowired
    private LanguageService languageService;


    @GetMapping("/hello-rest")
    String helloWorld(){
        return "Hello world from a simple rest controller :)";
    }

    @RequestMapping("/hello")
    public ModelAndView returnHTML() {
        ModelAndView mAndV = new ModelAndView();
        mAndV.setViewName("helloWorld");
        return mAndV;
    }

    @GetMapping("/hello/{language}")
    public String getTranslation(@PathVariable String language){
        return repo.findByLanguage(language).toString();
    }

    @GetMapping("/secure/hello")
    public RedirectView secureLogin() {

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/hello/" + "hebrew");
        return redirectView;
    }

    @GetMapping("/add_lang")
    public ModelAndView addLanguage(){
        ModelAndView mAndV = new ModelAndView();
        mAndV.setViewName("addLanguage");
        return mAndV;
    }

    @PostMapping("/save_lang")
    public RedirectView saveLanguage(
            @RequestParam("language") String language,
            @RequestParam("helloWorldTranslated") String translated
    ){
        Language newLang = new Language(language, translated);
        languageService.saveNewLanguage(newLang);
        System.out.println("Added a new language: " + newLang.toString());

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/hello/" + language);
        return redirectView;
    }
}
