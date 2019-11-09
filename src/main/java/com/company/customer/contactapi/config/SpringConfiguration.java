package com.company.customer.contactapi.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class SpringConfiguration {

    @Primary
    @ConfigurationProperties(prefix ="spring.datasource")
    public static class JpaConfig extends HikariConfig {

        @Bean
        public DataSource dataSource(){
            return new HikariDataSource(this);
        }
    }

}
