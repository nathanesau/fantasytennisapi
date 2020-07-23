package com.tennis.fantasytennisapi.request;

public class Round {
    
    private String tournament;

    private Integer roundNum;

    // this is a json string with the matchup information
    // it should be parsed
    private String matchups;

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public Integer getRoundNum() {
        return roundNum;
    }

    public void setRoundNum(Integer roundNum) {
        this.roundNum = roundNum;
    }

    public String getMatchups() {
        return matchups;
    }

    public void setMatchups(String matchups) {
        this.matchups = matchups;
    }
    
}