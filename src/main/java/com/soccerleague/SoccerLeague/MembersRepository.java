package com.soccerleague.SoccerLeague;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import com.mysql.fabric.xmlrpc.base.Member;
import com.soccerleague.SoccerLeague.entity.Team;

@Repository
public interface MembersRepository extends JpaRepository<Member, Long> {

	Optional<Member> findByMembername(String membername);
	List<Member> findByTeam(Team team);
	List<Member> findById(Member member);

}