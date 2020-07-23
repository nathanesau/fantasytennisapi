package com.tennis.fantasytennisapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tennis.fantasytennisapi.App;
import com.tennis.fantasytennisapi.entity.SimpleEntity;
import com.tennis.fantasytennisapi.repository.SimpleRepository;
import com.tennis.fantasytennisapi.request.Simple;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@EnableAutoConfiguration
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = App.class)
@ActiveProfiles("test")
@Sql({ "/simple-hsql.sql" })
@Sql(scripts = "/simple-clean-up.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class SimpleControllerTest {
 
    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    SimpleRepository simpleRepository;

    @Test
    public void testAddSimple_check200OKResponse() {
        Simple simpleRequest = new Simple();
        simpleRequest.setField1("field1_value");
        simpleRequest.setField2("field2_value");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> responseEntity = this.restTemplate.exchange("/simple/add", HttpMethod.POST,
                new HttpEntity<Simple>(simpleRequest, headers), String.class);

        assertEquals(200, responseEntity.getStatusCode().value());
    }

    @Test
    public void testDeleteSimple_check200OKResponse() {
        Simple simpleRequest = new Simple();
        simpleRequest.setField1("field1_value_delete");
        simpleRequest.setField2("field2_value_delete");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> responseEntity = this.restTemplate.exchange("/simple/delete", HttpMethod.POST,
                new HttpEntity<Simple>(simpleRequest, headers), String.class);

        assertEquals(200, responseEntity.getStatusCode().value());
    }

    @Test
    public void testGetSimple_check200OKResponse() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<SimpleEntity[]> responseEntity = this.restTemplate.exchange("/simple/get", HttpMethod.GET,
                new HttpEntity<>(headers), SimpleEntity[].class);

        assertEquals(200, responseEntity.getStatusCode().value());
    }

}