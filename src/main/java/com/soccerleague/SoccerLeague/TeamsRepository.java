package com.soccerleague.SoccerLeague;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soccerleague.SoccerLeague.entity.Team;

public interface TeamsRepository extends JpaRepository<Team, Long> {

	Optional<Team> findByTeamname(String teamname);
}