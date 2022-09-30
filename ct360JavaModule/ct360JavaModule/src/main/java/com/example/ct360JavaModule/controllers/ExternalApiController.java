package com.example.ct360JavaModule.controllers;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@Profile("externalAPI")
public class ExternalApiController {


    @GetMapping("/translate/{translateText}")
    public String translateTextUsingExternalAPI(@PathVariable String translateText){

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api-b2b.backenster.com/b1/api/v3/translate"))
                .header("Authorization", "a_ShIM360Nl2P4EhY4l7G2wSSXduIkf3F6szQu9fvP7RUEgk676VspjeVaRBa2BkyoCctpHHxvNQl1DqSF")
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(
                        "{\"translateMode\": \"html\",\n" +
                                "     \"platform\": \"api\",\n" +
                                "     \"data\": \"" + translateText + "\",\n" +
                                "     \"from\": \"en_GB\",\n" +
                                "     \"to\": \"de_DE\"}"
                ))
                .build();
        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return response.body().toString();
    }
}
