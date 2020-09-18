package jp.co.axa.apidemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;  

/**
 * The Class SecurityConfig.
 */
@Configuration  
@EnableGlobalMethodSecurity(prePostEnabled = true)  
public class SecurityConfig extends WebSecurityConfigurerAdapter { 

	/**
	 * Configure.
	 *
	 * @param http the http
	 * @throws Exception the exception
	 */
	@Override
	protected void configure(final HttpSecurity http) throws Exception {  

		http.antMatcher("/**")  
		.authorizeRequests()  
		.anyRequest().authenticated().and()
		.oauth2Login().and()
		.authorizeRequests().antMatchers("/h2-console/**").permitAll().and()
		.authorizeRequests().antMatchers("/swagger-ui**").permitAll().and()
		.authorizeRequests().antMatchers("/configuration/ui").permitAll().and()
		.authorizeRequests().antMatchers("/swagger-resources/**").permitAll().and()
		.authorizeRequests().antMatchers("/configuration/security").permitAll().and()
		.authorizeRequests().antMatchers("/webjars/**").permitAll();
		http.csrf().disable();
		http.headers().frameOptions().disable(); 
	}  

}