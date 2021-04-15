package com.cg.apps;

import com.cg.apps.customer.ui.CustomerUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.slf4j.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class CustomermsApplication
{

    public static void main(String[] args)
    {
       ConfigurableApplicationContext context= SpringApplication.run(CustomermsApplication.class, args);
       CustomerUI customerUI =context.getBean(CustomerUI.class);
       customerUI.start();

    }

     /**
     *
     * for handling cross origin requests
     */
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource src=new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration=new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.addAllowedHeader("*");
        configuration.addAllowedOrigin("http://localhost:3000");
        configuration.addAllowedMethod("*");
        src.registerCorsConfiguration("/**",configuration);
        return new CorsFilter(src);
    }

}
