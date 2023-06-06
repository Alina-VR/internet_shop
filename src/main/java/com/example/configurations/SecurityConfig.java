package com.example.configurations;

import com.example.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//import com.example.models.Role;
import com.example.services.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private final CustomUserDetailsService userDetailsService;
    @Autowired
    AuthProvider authProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                //                    .antMatchers("/product/**", "/images/**", "/registration", "/doRegister", "/doRegister2", "/h2-console", "/h2-console/**")
                //                    .permitAll()
                .antMatchers(HttpMethod.POST, "/doRegister").permitAll()
                .antMatchers("/registration").permitAll()
                .anyRequest().hasRole(Role.USER.getAuthority())
                .and()
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login_process")
                    .successForwardUrl("/")
                    .usernameParameter("email")
                    .passwordParameter("password").permitAll()
                .and()
                .csrf().disable();
        //                    .anyRequest().hasRole(Role.USER.getAuthority())
        //                .and()
        //                    .formLogin()
        //                    .loginPage("/login")
        //                    .permitAll()
        //                .and()
        //                    .logout()
        //                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.authenticationProvider(authProvider).userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder(8);
    }
}
