import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration

@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override

    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()

            .antMatchers("/search/**").permitAll() // Allow public access to Search Service

            .antMatchers("/cart/**").authenticated() // Secure Cart Service

            .antMatchers("/order/**").authenticated() // Secure Order Service

            .antMatchers("/user/**").authenticated() // Secure User Service

            .anyRequest().authenticated() // Authenticate all other requests

            .and()

            .httpBasic(); // Use HTTP Basic Authentication

    }


    @Bean

    public PasswordEncoder passwordEncoder() {

        return NoOpPasswordEncoder.getInstance(); // For simplicity; use a real password encoder in production

    }

}
