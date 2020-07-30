package com.rajan.footballleague;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = FootballLeagueApp.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class FootballLeagueServiceTest {

    @Autowired
    private FootballLeagueService service;

    @Test
    void getHttpResult() throws IOException {
        String params = "?action=get_countries&APIkey=";
        String response = service.getHttpResult(params);
        assertNotNull(response);
    }

    @Test
    void getCountryID() throws IOException {
        String countryId = service.getCountryID("England");
        assertEquals("41", countryId);
    }

    @Test
    void getLeagueID() throws IOException {
        String leagueID = service.getLeagueID("41");
        assertEquals("149", leagueID);
    }

    @Test
    void getTeamStanding() throws IOException {
        FootballLeagueRepresentation rep = service.getTeamStanding("149");
        assertEquals("England", rep.getCountry_name());
        assertEquals("149", rep.getLeague_id());
        assertEquals("Championship", rep.getLeague_name());
        assertEquals("2653", rep.getTeam_id());
        assertEquals("Leeds", rep.getTeam_name());
        assertEquals("1", rep.getOverall_league_position());
    }

    @Test
    void getCountryTeamStanding() throws IOException {
        FootballLeagueCountryTeamStandingRep rep = service.getCountryTeamStanding("England",
                "Premier League", "Liverpool");
        assertEquals("41-England", rep.getCountryIdName());
        assertEquals("149-Premier League", rep.getLeagueIdName());
        assertEquals("2653-Liverpool", rep.getTeamIdName());
        assertEquals("1", rep.getOverall_league_position());

    }

}