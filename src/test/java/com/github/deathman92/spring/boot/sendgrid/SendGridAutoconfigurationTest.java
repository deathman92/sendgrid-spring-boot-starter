package com.github.deathman92.spring.boot.sendgrid;

import com.sendgrid.Client;
import com.sendgrid.SendGrid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Victor Zhivotikov
 * @since 31.08.2016
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SendGridAutoconfigurationTest.TestApplication.class)
public class SendGridAutoconfigurationTest {

    @Autowired
    private SendGrid sendGrid;

    @Test
    public void shouldInstantiateSendGridWithSettings() throws Exception {
        assertThat(sendGrid).isNotNull();
        String apiKey = (String) ReflectionTestUtils.getField(sendGrid, "apiKey");
        assertThat(apiKey).isEqualTo("testkey");
        Client client = (Client) ReflectionTestUtils.getField(sendGrid, "client");
        assertThat(client).isNotNull();
        boolean test = (boolean) ReflectionTestUtils.getField(client, "test");
        assertThat(test).isTrue();
        assertThat(sendGrid.getHost()).isEqualTo("localhost");
        assertThat(sendGrid.getVersion()).isEqualTo("v1");
    }

    @EnableAutoConfiguration
    public static class TestApplication {
    }

}