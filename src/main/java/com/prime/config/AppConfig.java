package com.prime.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = { "com.prime.dao", "com.prime.domain", "com.prime.service" })
@Import({ DataConfig.class })
public class AppConfig {
}
