package com.tennis.fantasytennisapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tennis.fantasytennisapi.entity.DrawEntity;
import com.tennis.fantasytennisapi.repository.DrawRepository;
import com.tennis.fantasytennisapi.request.Bracket;
import com.tennis.fantasytennisapi.request.Round;
import com.tennis.fantasytennisapi.service.DrawService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrawServiceImpl implements DrawService {
    
    @Autowired
    DrawRepository drawRepository;

	@Override
	public String addBracket(Bracket bracket) {
        
        List<Round> rounds = bracket.getRounds();

        // typically a bracket will have between 5-7 rounds
        for (Round round : rounds) {
            DrawEntity drawEntity = new DrawEntity();
            drawEntity.setTournament(round.getTournament());
            drawEntity.setRoundNum(round.getRoundNum());
            drawEntity.setMatchups(round.getMatchups());
            drawRepository.save(drawEntity);
        }

        return "OK";
	}

	@Override
	public Bracket getBracket() {

        List<DrawEntity> draws = drawRepository.getDraws();
        List<Round> rounds = new ArrayList<Round>();
        
        for (DrawEntity draw : draws) {
            Round round = new Round();
            round.setTournament(draw.getTournament());
            round.setRoundNum(draw.getRoundNum());
            round.setMatchups(draw.getMatchups());
            rounds.add(round);
        }

        Bracket bracket = new Bracket();
        bracket.setRounds(rounds);

        return bracket;
    }

}