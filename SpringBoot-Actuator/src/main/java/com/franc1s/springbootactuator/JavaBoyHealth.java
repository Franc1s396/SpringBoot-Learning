package com.franc1s.springbootactuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class JavaBoyHealth implements HealthIndicator {
    @Override
    public Health health() {
        return Health.up().withDetail("msg","一切正常").build();
    }
}
