package com.project.ipldashboard.data;

import java.time.LocalDate;

import com.project.ipldashboard.model.Match;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class MatchProcess implements ItemProcessor<MatchInput, Match> {
    
    //private static final Logger log = LoggerFactory.getLogger(MatchProcess.class);

    public Match process(final MatchInput matchInput) throws Exception{

        Match match = new Match();

        match.setId(Long.parseLong(matchInput.getId()));
        match.setCity(matchInput.getCity());
        match.setDate(LocalDate.parse(matchInput.getDate()));
        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match.setVenue(matchInput.getVenue());

        String firstInnings, secondInnings;
        if("bat".equals(matchInput.getToss_decision())){
            firstInnings = matchInput.getToss_winner();
            if(firstInnings.equals(matchInput.getTeam1())){
                secondInnings = matchInput.getTeam2();
            }
            else{
                secondInnings = matchInput.getTeam1();
            }
        }
        else{
            secondInnings = matchInput.getToss_winner();
            if(secondInnings.equals(matchInput.getTeam1())){
                firstInnings = matchInput.getTeam2();
            }
            else{
                firstInnings = matchInput.getTeam1();
            }
        }
        match.setTeam1(firstInnings);
        match.setTeam2(secondInnings);
        match.setTossWinner(matchInput.getToss_winner());
        match.setTossDecision(matchInput.getToss_decision());
        match.setMatchWinner(matchInput.getMatch_winner());
        match.setResult(matchInput.getResult());
        match.setResultMargin(matchInput.getResult_margin());
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());

        return match;
    }
}
