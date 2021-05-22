package com.ipl.ipldashbord.controller;

import java.util.List;

import com.ipl.ipldashbord.entity.Team;
import com.ipl.ipldashbord.repository.MatchRepository;
import com.ipl.ipldashbord.repository.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamRepository teamRepo;

    @Autowired
    MatchRepository matchRepo;
    
    @GetMapping("/{teamName}")
    public Team getTeam(@PathVariable(value = "teamName") String teamName){
        Team team = teamRepo.findByTeamName(teamName);

        team.setMatches(matchRepo.getLatestMtches(teamName));
        return team;
    }


}
