package com.wewash.services.infra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    private static final String USER_ROLE = "USER";
    private static final String ACTUATOR_ROLE = "ACTUATOR";

    //Betgenius user
    @Value("${bx.security.betgenius.username}")
    private String betgeniusUser;

    @Value("${bx.security.betgenius.password}")
    private String betgeniusPassword;

    //Actuator user
    @Value("${bx.security.actuator.username}")
    private String actuatorUser;

    @Value("${bx.security.actuator.password}")
    private String actuatorPassword;

    @Autowired
    public void configAuthenticationProvider(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(betgeniusUser).password(betgeniusPassword).roles(USER_ROLE)
                .and()
                .withUser(actuatorUser).password(actuatorPassword).roles(ACTUATOR_ROLE);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/v1/betgenius/**").hasRole(USER_ROLE)
                .antMatchers("/-system/health").permitAll()
                .antMatchers("/-system/**").hasRole(ACTUATOR_ROLE)
                .and()
                .csrf().disable()
                .httpBasic();
        http.headers().frameOptions().disable();
    }
}
