package com.cg.apps;

import com.cg.apps.customer.ui.CustomerUI;
import com.cg.apps.items.ui.ItemUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CustomermsApplication
{

    public static void main(String[] args)
    {
       ConfigurableApplicationContext context= SpringApplication.run(CustomermsApplication.class, args);
       CustomerUI customerUI =context.getBean(CustomerUI.class);
       ItemUI itemUI = context.getBean(ItemUI.class);
       customerUI.start();
       itemUI.start();

    }

}
