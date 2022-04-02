package com.brazucabet.brazucaapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String BASE_PACKAGE ="com.brazucabet.brazucaapi.controller";
	private static final String API_TITULO ="BRAZUCA API";
	private static final String API_DESCRICAO ="API REST que obtem dados da partida dos compeonatos de futebol em tempo real utilizando técnicas de Scraping";
	private static final String API_VERSAO = "1.0.0";
	private static final String CONTATO_NOME ="Alexandre B Santana";
	private static final String CONTATO_GITHUB="https://github.com/alexandrebs";
	private static final String CONTATO_EMAIL="alexandrebs10@gmail.com";
	
	
	@Bean
	public Docket api() {
		
		
		return new Docket(DocumentationType.SWAGGER_2).select().apis(basePackage(BASE_PACKAGE)).paths(
				PathSelectors.any()).build().apiInfo(buildApiInfo());
	}


	private ApiInfo buildApiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder().title(API_TITULO)
								   .description(API_DESCRICAO)
								   .version(API_VERSAO)
								   .contact(new Contact(API_TITULO, API_DESCRICAO, CONTATO_EMAIL))
								   .build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
