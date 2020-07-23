package com.tennis.fantasytennisapi.request;

import java.util.List;

public class Bracket {
    
    private List<Round> rounds;

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

}