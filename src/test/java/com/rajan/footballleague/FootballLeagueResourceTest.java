package com.rajan.footballleague;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("There is some issue with TestRestTemplate")
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

        FootballLeagueRepresentation rep = new FootballLeagueRepresentation();
        rep.setCountry_name("England");
        rep.setLeague_name("Premier League");
        rep.setTeam_name("Liverpool");
        HttpEntity<FootballLeagueRepresentation> entity = new HttpEntity<>(rep);
        ResponseEntity<FootballLeagueCountryTeamStandingRep> response = restTemplate.exchange(getBaseUrl() +
                        "/footballleague/teamstanding", HttpMethod.GET, entity,
                FootballLeagueCountryTeamStandingRep.class);
        assertEquals(200, response.getStatusCode());
    }
}