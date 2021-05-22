package com.ipl.ipldashbord.data;

import java.time.LocalDate;
import com.ipl.ipldashbord.entity.Match;
import org.springframework.batch.item.ItemProcessor;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

   // private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);
  
    @Override
    public Match process(final MatchInput matchInput) throws Exception {
      
       // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");

        Match match = new Match();
        match.setId(Long.parseLong(matchInput.getId()));
        match.setCity(matchInput.getCity());
        match.setDate(LocalDate.parse(matchInput.getDate()));
        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match.setVenue(matchInput.getVenue());
        
        if(matchInput.getToss_decision().equals("bat")){
            match.setTeam1(matchInput.getToss_winner());
            match.setTeam2(matchInput.getToss_winner().equals(matchInput.getTeam1()) ? matchInput.getTeam2(): matchInput.getTeam1());
        }else{
            match.setTeam2(matchInput.getToss_winner());
            match.setTeam1(matchInput.getToss_winner().equals(matchInput.getTeam1()) ? matchInput.getTeam2(): matchInput.getTeam1());
        }

        match.setResult(matchInput.getResult());
        match.setTossWinner(matchInput.getToss_winner());
        match.setTossDecision(matchInput.getToss_decision());
        match.setWinner(matchInput.getWinner());
        match.setResultMargin(matchInput.getResult_margin());
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());

        return match;
    }
  
  }
