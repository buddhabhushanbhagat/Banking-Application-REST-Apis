
package com.bank.service.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@PropertySource("classpath:database.properties")
@Data
public class DatabaseConfig {
	@Value("${database.url}")
	private String url;
	
    @Value("${database.username}")
	private String username;
    
    @Value("${database.password}")
	private String password;
    
    @Value("${database.driver}")
	private String driverClassName;
	
	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(getDriverClassName());
		dataSourceBuilder.url(getUrl());
		dataSourceBuilder.username(getUsername());
		dataSourceBuilder.password(getPassword());
		return dataSourceBuilder.build();
	}
}
