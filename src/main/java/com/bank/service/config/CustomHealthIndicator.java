package com.bank.service.config;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {

    public CustomHealthIndicator(
    		) {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomHealthIndicator(Function<Exception, String> healthCheckFailedMessage) {
		super(healthCheckFailedMessage);
		// TODO Auto-generated constructor stub
	}

	public CustomHealthIndicator(String healthCheckFailedMessage) {
		super(healthCheckFailedMessage);
		// TODO Auto-generated constructor stub
	}

	@Value("${info.app.version:unknown}")
    private String version;

    @Override
    protected void doHealthCheck(Builder builder) throws Exception {
        // Custom logic to check health status

        if (version != null && !version.trim().isEmpty()) {
            // Add version information to health status details
            builder.withDetail("version", version);
        } else {
            // Version information is not present
            builder.down().withDetail("error", "Version information not available");
        }

        // You can add more custom details or checks here
    }
}