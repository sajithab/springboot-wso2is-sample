package com.wso2is.saml2.sample.springbootwso2issample.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests(authz -> authz
                .mvcMatchers("/login").permitAll() // here
                .mvcMatchers("/delete").hasAnyRole("delete") // here
                .anyRequest().permitAll())
                .saml2Login(saml2 -> saml2.loginPage("/login"));// and here
    }

}
