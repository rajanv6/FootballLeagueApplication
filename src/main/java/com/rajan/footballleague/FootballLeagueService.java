package com.rajan.footballleague;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;

@Service
public class FootballLeagueService {

    ObjectMapper objectMapper = new ObjectMapper();
    @Value("${baseUrl}")
    private String baseUrl;
    @Value("${APIKey}")
    private String APIKey;

    public String getHttpResult(String params) throws IOException {
        URL url = new URL(baseUrl + params + APIKey);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int responsecode = connection.getResponseCode();
        StringBuilder result = new StringBuilder();

        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {
            Scanner sc = new Scanner(url.openStream());
            while(sc.hasNext())
            {
                result.append(sc.nextLine());
            }
            sc.close();
        }

        return result.toString();
    }


    public String getCountryID(String countryName) throws IOException {

        String result = getHttpResult("?action=get_countries&APIkey=");
        List<FootballLeagueRepresentation> resourceList = objectMapper.readValue(result, new TypeReference<List<FootballLeagueRepresentation>>() {});
        for (FootballLeagueRepresentation resource : resourceList ) {
            if (resource.getCountry_name().contains(countryName)) {
                return resource.getCountry_id();
            }
        }
        return null;
    }

    public String getLeagueID(String countryId) throws IOException {
        String result = getHttpResult("?action=get_leagues&country_id=" + countryId
                + "&APIkey=");
        List<FootballLeagueRepresentation> resourceList = objectMapper.readValue(result, new TypeReference<List<FootballLeagueRepresentation>>() {});
        for (FootballLeagueRepresentation resource : resourceList ) {
            if (resource.getCountry_id().contains(countryId)) {
                return resource.getLeague_id();
            }
        }
        return null;
    }

    public FootballLeagueRepresentation getTeamStanding(String leagueId) throws IOException {
        String result = getHttpResult("?action=get_standings&league_id=" + leagueId
                + "&APIkey=");
        try {
            List<FootballLeagueRepresentation> resourceList = objectMapper.readValue(result, new TypeReference<List<FootballLeagueRepresentation>>() {
            });
            for (FootballLeagueRepresentation resource : resourceList) {
                if (resource.getLeague_id().contains(leagueId)) {
                    return resource;
                }
            }
        } catch (MismatchedInputException e) {
            return null;
        }
        return null;
    }

    public FootballLeagueCountryTeamStandingRep getCountryTeamStanding(String countryName,
                                                                       String leagueName,
                                                                       String teamName) throws IOException {
        FootballLeagueCountryTeamStandingRep resource = new FootballLeagueCountryTeamStandingRep();
        String countryId = getCountryID(countryName);
        resource.setCountryIdName( countryId + "-" + countryName);
        String leagueId = getLeagueID(countryId);
        resource.setLeagueIdName(leagueId + "-" + leagueName);
        FootballLeagueRepresentation leagueResource = getTeamStanding(leagueId);
        resource.setTeamIdName(leagueResource.getTeam_id() + "-" + teamName);
        resource.setOverall_league_position(leagueResource.getOverall_league_position());
        return resource;
    }

}
