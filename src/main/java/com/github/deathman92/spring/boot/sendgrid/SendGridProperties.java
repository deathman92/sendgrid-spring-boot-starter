package com.github.deathman92.spring.boot.sendgrid;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Victor Zhivotikov
 * @since 31.08.2016
 */
@Data
@ConfigurationProperties("sendgrid")
public class SendGridProperties {

    private String apiKey;
    private Boolean test;
    private String host;
    private String version;

}
