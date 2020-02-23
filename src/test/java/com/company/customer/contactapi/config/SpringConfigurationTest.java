package com.company.customer.contactapi.config;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class SpringConfigurationTest {

  @Bean(name = "dataSource")
  public DataSource dataSource() {
    return new SimpleDriverDataSource();
  }
}
