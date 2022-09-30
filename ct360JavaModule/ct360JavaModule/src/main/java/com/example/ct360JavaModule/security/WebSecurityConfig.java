package com.example.ct360JavaModule.security;

import com.example.ct360JavaModule.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AppUserService appUserService;
    private final BCryptPasswordEncoder bcpe;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/register", "/hello-rest", "/hello/**", "/translate/**")
                .permitAll()

                .antMatchers("/add_lang")
                .hasAuthority("ADMIN")

                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuth()).inMemoryAuthentication()
                .withUser("admin").password(bcpe.encode("admin")).authorities("ADMIN")
                .and()
                .withUser("dusan7").password(bcpe.encode("dusan7")).authorities("USER");
    }

    @Bean
    public DaoAuthenticationProvider daoAuth(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bcpe);
        provider.setUserDetailsService(appUserService);
        return provider;
    }
}
