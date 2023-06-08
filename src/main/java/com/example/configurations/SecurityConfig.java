package com.example.configurations;

import com.example.models.Role;
import com.example.services.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private final CustomUserDetailsService userDetailsService;
    @Autowired
    AuthProvider authProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/h2-console/**").hasAuthority(Role.ADMIN.getAuthority()).antMatchers("/")
            .permitAll().antMatchers("/menu", "/menu/**")
            .hasAnyAuthority(Role.ADMIN.getAuthority(), Role.USER.getAuthority())
            .antMatchers(HttpMethod.POST, "/doRegister").permitAll().antMatchers("/registration").permitAll()
            .anyRequest().hasAuthority(Role.USER.getAuthority()).and().formLogin().loginPage("/login")
            .loginProcessingUrl("/login_process").permitAll().defaultSuccessUrl("/").usernameParameter("name")
            .passwordParameter("password").permitAll().and().csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider).userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }
}
