package com.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.springboot.jpa.config.ConfigBean;
import com.springboot.jpa.config.MultipleProperities;


@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class, MultipleProperities.class})
public class SpringbootJpaMySqlUnitTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaMySqlUnitTestApplication.class, args);
	}
}
