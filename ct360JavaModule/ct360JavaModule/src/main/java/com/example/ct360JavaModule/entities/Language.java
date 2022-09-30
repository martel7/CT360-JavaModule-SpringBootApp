package com.example.ct360JavaModule.entities;

import lombok.ToString;

import javax.persistence.*;

@Entity
//@Table(name = "Language")
@ToString
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String language;
    private String helloWorldTranslated;

    public Language(String language, String helloWorldTranslated) {
        this.language = language;
        this.helloWorldTranslated = helloWorldTranslated;
    }

    public Language(){}

    public Long getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHelloWorldTranslated() {
        return helloWorldTranslated;
    }

    public void setHelloWorldTranslated(String helloWorldTranslated) {
        this.helloWorldTranslated = helloWorldTranslated;
    }

    @Override
    public String toString(){
        return "In " + this.language + ", hello world is written as: " + this.helloWorldTranslated;
    }
}