package com.prime.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.prime.api" })
public class WebConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
    registry.addResourceHandler("/src/**").addResourceLocations("/src/");
    registry.addResourceHandler("/vendor/**").addResourceLocations("/vendor/");
    registry.addResourceHandler("/favicon.ico").addResourceLocations("/favicon.ico");
    registry.addResourceHandler("/index.html").addResourceLocations("/index.html");
    registry.addResourceHandler("/templates-app.js").addResourceLocations("/templates-app.js");
    registry.addResourceHandler("/templates-common.js").addResourceLocations("/templates-common.js");
  }
}
