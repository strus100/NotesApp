package com.example.NotesApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter
{

	private static final String PATTERN = "/api/**";

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure( AuthenticationManagerBuilder auth ) throws Exception
	{

		auth.userDetailsService( userDetailsService );
	}

	// Secure the endpoins with HTTP Basic authentication
	@Override
	protected void configure( HttpSecurity http ) throws Exception
	{
		//NOTHING TO DO
		/*
		http
				//HTTP Basic authentication
				.httpBasic()
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, PATTERN).hasAuthority("ADMIN")
				.antMatchers(HttpMethod.POST, PATTERN).hasAuthority("ADMIN")
				.antMatchers(HttpMethod.PUT, PATTERN).hasAuthority("ADMIN")
				.antMatchers(HttpMethod.PATCH, PATTERN).hasAuthority("ADMIN")
				.antMatchers(HttpMethod.DELETE, PATTERN).hasAuthority("ADMIN")
				.and()
				.csrf().disable()
				.formLogin().disable();*/
	}

	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}
