package com.bank.service.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "database")
public class DatabaseProperties {
	String url;
	String username;
	String password;
	String driverClassName;
}
