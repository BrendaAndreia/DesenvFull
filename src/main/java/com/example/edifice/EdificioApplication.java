package com.example.edifice;

import com.example.edifice.ui.LoginView;
import com.vaadin.flow.spring.security.VaadinAwareSecurityContextHolderStrategyConfiguration;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.lang.reflect.Member;

@SpringBootApplication
public class EdificioApplication extends VaadinWebSecurity{

    public static void main(String[] args) {

        SpringApplication.run(EdificioApplication.class, args);
    }

    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception{
        return new InMemoryUserDetailsManager(
                User.withUsername("Brenda")
                        .password("{noop}teste")
                        .roles("ADMIN")
                        .build(),
                User.withUsername("Andreia")
                        .password("{noop}teste")
                        .roles("ADMIN")
                        .build()

        );
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        super.configure(http);
        setLoginView(http, LoginView.class);
    }


}
