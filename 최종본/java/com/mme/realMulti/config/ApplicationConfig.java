package com.mme.realMulti.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "com.mme.realMulti.dao", "com.mme.realMulti.service"})
@Import({ DBConfig.class })

public class ApplicationConfig {

}