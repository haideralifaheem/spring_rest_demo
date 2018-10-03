package com.spring.demo.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableAutoConfiguration
@EnableSwagger
@ComponentScan(basePackages = { "com.spring.demo.movies" })
@SpringBootApplication
public class Application {
	@Autowired
	private SpringSwaggerConfig swaggerConfig;

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}

	@Bean
	public SwaggerSpringMvcPlugin groupOnePlugin() {
		return new SwaggerSpringMvcPlugin(swaggerConfig).includePatterns("/Movie.*?", "/Actors.*?", "/Directors.*?")
				.swaggerGroup("admin");
	}

}
