package com.tennis.fantasytennisapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tennis.fantasytennisapi.App;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = App.class)
@ActiveProfiles("test")
public class PingControllerTest {
    
    @LocalServerPort
	int randomServerPort;

	@Autowired
	private TestRestTemplate restTemplate;

    @Test
    public void testPingController() {
        String endpointUrl = "/ping";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> responseEntity = this.restTemplate.exchange(endpointUrl, HttpMethod.GET,
                new HttpEntity<>(headers), String.class);

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

}