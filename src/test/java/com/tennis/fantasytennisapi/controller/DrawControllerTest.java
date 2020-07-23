package com.tennis.fantasytennisapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.tennis.fantasytennisapi.App;
import com.tennis.fantasytennisapi.repository.DrawRepository;
import com.tennis.fantasytennisapi.request.Bracket;
import com.tennis.fantasytennisapi.request.Round;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@EnableAutoConfiguration
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = App.class)
@ActiveProfiles("test")
@Sql({ "/draw-hsql.sql" })
@Sql(scripts = "/draw-clean-up.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class DrawControllerTest {
    
    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    DrawRepository simpleRepository;

    @Test
    public void testGetBracket_check200OKResponse() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<Bracket> responseEntity = this.restTemplate.exchange("/ftapi/v1/bracket/get", HttpMethod.GET,
                new HttpEntity<>(headers), Bracket.class);

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testAddBracket_check200OKResponse() {
        List<Round> rounds = new ArrayList<Round>();
        Round round1 = new Round();
        round1.setTournament("Wimbledon2020");
        round1.setRoundNum(1);
        round1.setMatchups("[{\"player1\": \"Kei Nishikori\", \"player2\": \"Milos Raonic\", \"winner\": \"Milos Raonic\"}]");
        Round round2 = new Round();
        round2.setTournament("Wimbledon2020");
        round2.setRoundNum(2);
        round2.setMatchups("[{\"player1\": \"Stan Wawrinka\", \"player2\": \"Alexander Zverev\", \"winner\": \"Stan Wawrinka\"}]");
        rounds.add(round1);
        rounds.add(round2);

        Bracket bracketRequest = new Bracket();
        bracketRequest.setRounds(rounds);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> responseEntity = this.restTemplate.exchange("/ftapi/v1/bracket/add", HttpMethod.POST,
                new HttpEntity<Bracket>(bracketRequest, headers), String.class);

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

}