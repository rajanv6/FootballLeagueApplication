package com.rajan.footballleague;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = FootballLeagueApp.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class FootballLeagueResourceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String getBaseUrl() {
        return "http://localhost:8080";
    }


    @Test
    void getCountryTeamStanding() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getBaseUrl() + "/footballleague/teamstanding")
                .queryParam("countryName", "England")
                .queryParam("leagueName", "Premier League")
                .queryParam("teamName", "Liverpool");

        HttpEntity<String> entity = new HttpEntity<>(requestHeaders);
        ResponseEntity<FootballLeagueCountryTeamStandingRep> response = restTemplate.exchange(
                builder.build().encode().toUri(), HttpMethod.GET, entity, FootballLeagueCountryTeamStandingRep.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}