package com.rajan.footballleague;

public class FootballLeagueStandingsRepresentation {

    private final String countryIDName;
    private final String leagueIDName;
    private final String teamIDName;
    private final Integer overallLeaguePosition;

    public FootballLeagueStandingsRepresentation(String countryIDName, String leagueIDName, String teamIDName, Integer overallLeaguePosition) {
        this.countryIDName = countryIDName;
        this.leagueIDName = leagueIDName;
        this.teamIDName = teamIDName;
        this.overallLeaguePosition = overallLeaguePosition;
    }

    public String getCountryIDName() {
        return countryIDName;
    }

    public String getLeagueIDName() {
        return leagueIDName;
    }

    public String getTeamIDName() {
        return teamIDName;
    }

    public Integer getOverallLeaguePosition() {
        return overallLeaguePosition;
    }
}
