package com.rajan.footballleague;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FootballLeagueRepresentation {
    @JsonProperty
    private String country_id;
    @JsonProperty
    private String country_name;
    @JsonProperty
    private String league_id;
    @JsonProperty
    private String league_name;
    @JsonProperty
    private String team_id;
    @JsonProperty
    private String team_name;
    @JsonProperty
    private String overall_league_position;

    public String getCountry_id() {
        return country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public String getLeague_id() {
        return league_id;
    }

    public String getLeague_name() {
        return league_name;
    }

    public String getTeam_id() {
        return team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public String getOverall_league_position() {
        return overall_league_position;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }
}
