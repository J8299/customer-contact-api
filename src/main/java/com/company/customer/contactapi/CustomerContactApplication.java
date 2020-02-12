package com.company.customer.contactapi;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableConfigurationProperties
public class CustomerContactApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    new SpringApplicationBuilder(CustomerContactApplication.class)
        .web(WebApplicationType.SERVLET)
        .run(args);
  }

}
