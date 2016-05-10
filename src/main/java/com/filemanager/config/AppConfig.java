package com.filemanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.filemanager.test.User;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.filemanager.controller" })
public class AppConfig {

	@Bean
	public User admin() {
		User u = new User();
		u.setName("Merlin");
		u.setSkill("Magic");
		return u;
	}
}
