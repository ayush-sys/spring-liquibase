package com.demo.spring_liquibase.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/* The Database config class. */

@Data
@Configuration
public class DbConfig {

    /* The Red Cloud RT database config. */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig rtHikariConfig() {
        return new HikariConfig();
    }

    @Bean
    @Primary
    public DataSource getRTDataSource() {
        return new HikariDataSource(rtHikariConfig());
    }
}