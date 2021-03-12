package com.cg.apps.customermgt;

import com.cg.apps.customermgt.customer.ui.CustomerUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CustomermgtApplication
{
	public static void main(String[] args)
	{
		ConfigurableApplicationContext context = SpringApplication.run(CustomermgtApplication.class, args);
		CustomerUI customerUI = context.getBean(CustomerUI.class);
		customerUI.start();
	}
}
