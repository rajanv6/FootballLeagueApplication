package com.rajan.footballleague;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<FootballLeagueCountryTeamStandingRep> getCountryTeamStanding(@RequestParam String countryName,
                                                                                       @RequestParam String leagueName,
                                                                                       @RequestParam String teamName)
            throws IOException {
        if (null == countryName ||
            null == leagueName ||
            null == teamName) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid input format");
        }

        FootballLeagueCountryTeamStandingRep rep = footballLeagueService.getCountryTeamStanding(countryName,
                leagueName, teamName);
        return ResponseEntity.ok(rep);
    }
}
