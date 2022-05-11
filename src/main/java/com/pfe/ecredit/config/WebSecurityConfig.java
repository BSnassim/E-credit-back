package com.pfe.ecredit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntrypoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	private PasswordEncoderCreation pwEN;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configuring AuthenticationManager so that it knows from where to load
		// choosing the password encoder to use
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(pwEN.myPasswordEncoder());
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		// cors & csrf disabled for dev env & allowing access to login
		httpSecurity.cors().and().csrf().disable().authorizeRequests().antMatchers("/authenticate/**").permitAll().
		// restrict api's to certain roles
		antMatchers("/administration/**").hasRole("Administration").
		// all requests besides login need to be authenticated
				anyRequest().authenticated().and().
				// exception handling
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
				// make sure we use stateless session; session won't be used to store user info
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Adding a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
