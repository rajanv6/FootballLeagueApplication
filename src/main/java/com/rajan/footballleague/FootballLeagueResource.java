package com.rajan.footballleague;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
@RequestMapping("/footballleague")
public class FootballLeagueResource {
    private FootballLeagueService footballLeagueService;

    public FootballLeagueResource(FootballLeagueService footballLeagueService) {
        this.footballLeagueService = footballLeagueService;
    }

    @GetMapping ("/teamstanding")
    public ResponseEntity<FootballLeagueCountryTeamStandingRep> getCountryTeamStanding(@RequestBody FootballLeagueRepresentation
                                                                                footballLeagueRepresentation) throws IOException {
        if (null == footballLeagueRepresentation.getCountry_name() &&
            null == footballLeagueRepresentation.getLeague_name() &&
            null == footballLeagueRepresentation.getTeam_name()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid input format");
        }

        String countryName = footballLeagueRepresentation.getCountry_name();
        String leagueName = footballLeagueRepresentation.getLeague_name();
        String teamName = footballLeagueRepresentation.getTeam_name();
        FootballLeagueCountryTeamStandingRep rep = footballLeagueService.getCountryTeamStanding(countryName,
                leagueName, teamName);
        return ResponseEntity.ok(rep);
    }
}
