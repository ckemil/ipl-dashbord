package com.ipl.ipldashbord.repository;

import java.util.List;

import com.ipl.ipldashbord.entity.Match;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match,Long>{
    List<Match> getByTeam1OrTeam2OrderByIdDesc(String team1, String team2,Pageable pageable);

    default List<Match> getLatestMtches(String teamName){
        
        Pageable pageable = PageRequest.of(0, 4);
        return getByTeam1OrTeam2OrderByIdDesc(teamName, teamName, pageable);
    }
}
