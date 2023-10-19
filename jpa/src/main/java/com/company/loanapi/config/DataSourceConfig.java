package com.company.loanapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean("loanDS")
    @ConfigurationProperties("spring.datasource.loan")
    public DataSource getLoanDS() {
        return DataSourceBuilder.create().build();
    }
}
