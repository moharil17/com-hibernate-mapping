package com.psm.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
    public void configure(HttpSecurity http) throws Exception {

			http
	        .authorizeRequests()
	        .antMatchers("/static-resources/**").permitAll()
		    .antMatchers("/homePage").access("hasRole('ROLE_1')")
		    .antMatchers("/enquiery").hasRole("1")
		    //.antMatchers("/enquiery").hasAnyRole("1","2","3")
		 //   .antMatchers("/Users_Details_report").hasRole("DBA")
		 //   .antMatchers("/reportsPage").hasAnyRole("ADMIN","DBA")
		 //   .antMatchers("/viewUsers").access("hasRole('ROLE_ADMIN')")
		    .antMatchers("/generateReport").hasAnyRole("principal")
	        .and()
		    //login
		    .formLogin().loginPage("/loginPage")
		    .defaultSuccessUrl("/homePage")
		    .failureUrl("/loginPage?msg=Bad credentials!")
		    .usernameParameter("userUserName")
		    .passwordParameter("userPassword")
	        .and()
		    //logout
		    .logout()
		    .logoutSuccessUrl("/loginPage?msg=log out successful!")
		    .invalidateHttpSession(true)
	      //  .and()
		  //  .exceptionHandling()
		    
		   // .accessDeniedPage("/accessDenied")
		    .and().csrf().disable();
/*	        .and()
		    //session management
		    .sessionManagement()
		    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
		    .invalidSessionUrl("/login?invalid")
		    .sessionAuthenticationErrorUrl("/login?invalid");*/
    }
	
	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() { //enabling the concurrent session-control support
	    return new HttpSessionEventPublisher();
	}
}
