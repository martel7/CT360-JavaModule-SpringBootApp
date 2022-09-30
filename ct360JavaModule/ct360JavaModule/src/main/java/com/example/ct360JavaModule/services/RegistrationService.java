package com.example.ct360JavaModule.services;

import com.example.ct360JavaModule.entities.AppUser;
import com.example.ct360JavaModule.appUser.AppUserRole;
import com.example.ct360JavaModule.registration.RegistrationRequest;
import com.example.ct360JavaModule.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    public String register(RegistrationRequest request) {

        return appUserService.signUp(
                new AppUser(
                        request.getUsername(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
