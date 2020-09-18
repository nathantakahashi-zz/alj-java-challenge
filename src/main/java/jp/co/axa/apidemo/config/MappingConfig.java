package jp.co.axa.apidemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class MappingConfig {
	
	@Bean
	public MappingConfig modelMapper() {
	    return new MappingConfig();
	}
}
