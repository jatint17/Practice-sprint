package com.cg.apps;

import com.cg.apps.customer.ui.CustomerUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SchoolApplication {

    public static void main(String[] args){
       ConfigurableApplicationContext context= SpringApplication.run(SchoolApplication.class, args);
       CustomerUI customerUI =context.getBean(CustomerUI.class);
       customerUI.start();

    }

}
