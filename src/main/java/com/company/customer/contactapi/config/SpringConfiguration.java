package com.company.customer.contactapi.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SpringConfiguration {

  @Primary
  @ConfigurationProperties(prefix = "spring.datasource")
  public static class JpaConfig extends HikariConfig {

    @Bean(name = "dataSource")
    public DataSource dataSource() {
      return new HikariDataSource(this);
    }
  }
}
