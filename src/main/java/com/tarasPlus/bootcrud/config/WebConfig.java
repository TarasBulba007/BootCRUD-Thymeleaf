package com.tarasPlus.bootcrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.tarasPlus.bootcrud")
public class WebConfig implements WebMvcConfigurer {

 //   @Bean
 //   ViewResolver viewResolver() {
 //       InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
 //       viewResolver.setPrefix("/WEB-INF/jsp/");
 //       viewResolver.setSuffix(".jsp");
 //       return  viewResolver;
 //   }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
