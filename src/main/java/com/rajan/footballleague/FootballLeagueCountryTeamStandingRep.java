package com.rajan.footballleague;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FootballLeagueCountryTeamStandingRep {
    @JsonProperty
    private String countryIdName;
    @JsonProperty
    private String leagueIdName;
    @JsonProperty
    private String teamIdName;
    @JsonProperty
    private String overall_league_position;

    public String getCountryIdName() {
        return countryIdName;
    }

    public void setCountryIdName(String countryIdName) {
        this.countryIdName = countryIdName;
    }

    public String getLeagueIdName() {
        return leagueIdName;
    }

    public void setLeagueIdName(String leagueIdName) {
        this.leagueIdName = leagueIdName;
    }

    public String getTeamIdName() {
        return teamIdName;
    }

    public void setTeamIdName(String teamIdName) {
        this.teamIdName = teamIdName;
    }

    public String getOverall_league_position() {
        return overall_league_position;
    }

    public void setOverall_league_position(String overall_league_position) {
        this.overall_league_position = overall_league_position;
    }
}
