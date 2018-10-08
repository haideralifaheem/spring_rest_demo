package com.spring.demo.movies;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@EnableAutoConfiguration
@EnableSwagger
@ComponentScan(basePackages = { "com.spring.demo.movies" })
@SpringBootApplication
public class Application {
	@Autowired
	private SpringSwaggerConfig swaggerConfig;

	public static MongoTemplate mongoTamplate;

	public static void main(String[] args) {
		try {
			SpringApplication.run(Application.class, args);
			MongoConfig mongoConfig = new MongoConfig();

			mongoTamplate = mongoConfig.mongoTemplate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Bean
	public SwaggerSpringMvcPlugin groupOnePlugin() {
		return new SwaggerSpringMvcPlugin(swaggerConfig).includePatterns("/Movie.*?", "/Actors.*?", "/Directors.*?")
				.swaggerGroup("admin");
	}

}
