package jp.co.axa.apidemo.security;

import org.springframework.context.annotation.Configuration;  
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;  
import org.springframework.security.config.annotation.web.builders.HttpSecurity;  
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;  

// TODO: Auto-generated Javadoc
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
    protected void configure(final HttpSecurity http) throws Exception {  
        http.antMatcher("/**")  
            .authorizeRequests()  
            .anyRequest().authenticated()  
            .and().oauth2Login(); 
    }  
    
}