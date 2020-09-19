package jp.co.axa.apidemo.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

// TODO: Auto-generated Javadoc
/**
 * The Class MappingConfig.
 */
@Configuration 
public class ApiConfig {

	/**
	 * Model mapper.
	 *
	 * @return the mapping config
	 */
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

	/**
	 * Employee api.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.select().paths(regex("/api/v1/.*"))
				.apis(RequestHandlerSelectors.any())
				.build();
	}


//	@Bean
//	public UiConfiguration uiConfiguration() {
//		return UiConfigurationBuilder.builder()
//				.deepLinking(true)
//				.validatorUrl(null)
//				.build();
//	}
}
