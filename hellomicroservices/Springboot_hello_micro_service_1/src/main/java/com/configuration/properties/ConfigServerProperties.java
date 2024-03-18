package com.configuration.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigServerProperties {
    private String value;
}
