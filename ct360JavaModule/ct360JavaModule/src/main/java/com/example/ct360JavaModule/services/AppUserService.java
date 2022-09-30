package com.example.ct360JavaModule.services;

import com.example.ct360JavaModule.repos.AppUserRepo;
import com.example.ct360JavaModule.entities.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserRepo repo;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public String signUp(AppUser appUser){

        if(repo.findByUsername(appUser.getUsername()).isPresent())
            throw new IllegalStateException("Username already exists");

        String encodedPassword = passwordEncoder.encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        repo.save(appUser);

        System.out.println("Saved a new user: " + appUser.toString());

        return "RADI!!";
    }
}
