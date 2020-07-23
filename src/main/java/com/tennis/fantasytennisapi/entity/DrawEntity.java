package com.tennis.fantasytennisapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "draw")
public class DrawEntity {
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TOURNAMENT")
    private String tournament;

    @Column(name = "ROUND_NUM")
    private Integer roundNum;

    @Column(name = "MATCHUPS")
    private String matchups;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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