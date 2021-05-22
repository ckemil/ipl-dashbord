package com.ipl.ipldashbord.repository;



import com.ipl.ipldashbord.entity.Team;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TeamRepository extends JpaRepository<Team,Long>{
    public Team findByTeamName(String teamName);
}
