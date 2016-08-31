package com.github.deathman92.spring.boot.sendgrid;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Victor Zhivotikov
 * @since 31.08.2016
 */
@Configuration
@ConditionalOnClass(SendGrid.class)
@ConditionalOnProperty(prefix = "sendgrid", value = "api-key")
@EnableConfigurationProperties(SendGridProperties.class)
public class SendGridAutoconfiguration {

    private final SendGridProperties properties;

    @Autowired
    public SendGridAutoconfiguration(SendGridProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean(SendGrid.class)
    public SendGrid sendGrid() {
        SendGrid sendGrid = createSendGrid();
        if (properties.getHost() != null) {
            sendGrid.setHost(properties.getHost());
        }
        if (properties.getVersion() != null) {
            sendGrid.setVersion(properties.getVersion());
        }
        return sendGrid;
    }

    private SendGrid createSendGrid() {
        if (properties.getTest() != null && properties.getTest()) {
            return new SendGrid(properties.getApiKey(), properties.getTest());
        }
        return new SendGrid(properties.getApiKey());
    }
}