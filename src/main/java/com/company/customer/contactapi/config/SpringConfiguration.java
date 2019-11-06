package com.company.customer.contactapi.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class SpringConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSourceProperties(){
            return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource")
    public HikariDataSource dataSource(DataSourceProperties properties){
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class)
                .build();
    }

}
