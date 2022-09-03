package com.pilgrims.travelagency.configurations;

import com.pilgrims.travelagency.services.implementations.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.pilgrims.travelagency.utils.Constants.Security.*;

/**
 * Configuration for security
 *
 * @author Ott Pikk
 */
@Configuration
@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider doaAuthenticationProvider = new DaoAuthenticationProvider();
        doaAuthenticationProvider.setUserDetailsService(userDetailsService());
        doaAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return doaAuthenticationProvider;
    }

    @Override
    protected void configure (AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }
    @Override
    protected void configure (HttpSecurity http) throws Exception {
        String role = "ROLE_";
        String admin = AUTHORITY_ADMIN.replace(role, "");
        String customer = AUTHORITY_CUSTOMER.replace(role, "");
        String guest = AUTHORITY_GUEST.replace(role, "");

        http.authorizeHttpRequests()
                .antMatchers("/", "/signup")
                .permitAll()

                .antMatchers("/admin/**")
                .hasRole(admin)

                .antMatchers("/trips/**")
                .hasAnyRole(customer, admin)

                .and()
                .httpBasic()
                .and()
                .formLogin()
                .and()
                .logout().permitAll(false).logoutSuccessUrl("/")
                .and()
                .csrf().disable();

    }
}
