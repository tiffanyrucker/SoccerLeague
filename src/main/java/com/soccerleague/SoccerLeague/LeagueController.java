package com.soccerleague.SoccerLeague;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soccerleague.SoccerLeague.MembersRepository;
import com.soccerleague.SoccerLeague.TeamsRepository;
import com.soccerleague.SoccerLeague.entity.Member;
import com.soccerleague.SoccerLeague.entity.Team;

@Controller
public class LeagueController {

	@Autowired
	MembersRepository mr;

	@Autowired
	TeamsRepository tr;

	
	@RequestMapping("/memberadmin")
	public ModelAndView memberAdmin() {
		return new ModelAndView("memberadmin", "members", mr.findAll());
	}

	
	@RequestMapping("/teamadmin")
	public ModelAndView teamAdmin() {
		return new ModelAndView("teamadmin", "teams", tr.findAll());
	}

	
	@RequestMapping(value = "/viewmember/{memberid}")
	public ModelAndView viewMember(@PathVariable("memberid") Long memberid) {
		Member member = mr.findById(memberid).orElse(null);
		ModelAndView mv = new ModelAndView("memberview");
		mv.addObject("title", "Member Information");
		mv.addObject("viewmember", member);
		mv.addObject("member", member);
		return mv;
	}

	
	@RequestMapping(value = "/viewteam")
	public ModelAndView viewTeam(@RequestParam("teamid") Long teamid) {
		Team team = tr.findById(teamid).orElse(null);
		ModelAndView mv = new ModelAndView("teamview");
		mv.addObject("team", team);
		List<Member> members = team.getMembers();
		mv.addObject("members", members);
		return mv;
	}

	
	@RequestMapping("editmember")
	public ModelAndView showMemberEditForm(@RequestParam("memberid") Long memberid) {
		Optional<Member> optionalMember = mr.findById(memberid);
		Member member = optionalMember.get();
		return new ModelAndView("memberedit", "member", member);
	}

	
	@RequestMapping("memberedit")
	public ModelAndView submitMemberEditForm(@RequestParam("memberid") Long memberid,
			@RequestParam("membername") String membername, @RequestParam("memberrole") String memberrole,
			@RequestParam("teamid") Long teamid) {
		Optional<Team> optionalTeam = tr.findById(teamid);
		Team team = optionalTeam.get();
		Member member = new Member(memberid, membername, memberrole, team);
		mr.save(member);
		return new ModelAndView("redirect:/memberadmin");
	}
	
	
	@RequestMapping(value = "/editteam")
	public ModelAndView editTeam(@RequestParam("teamid") Long teamid) {
		Optional<Team> optionalTeam = tr.findById(teamid);
		Team team = optionalTeam.get();
		return new ModelAndView("teamedit", "team", team);
	}

	
	@RequestMapping(value = "/teamedit")
	public ModelAndView updateTeam(@RequestParam("teamid") Long teamid, @RequestParam("teamname") String teamname,
			@RequestParam("members") List<Member> members) {
		Team team = new Team(teamid, teamname, members);
		tr.save(team);
		return new ModelAndView("redirect:/teamadmin");
	}

	
	@RequestMapping(value = { "/deletemember" })
	public ModelAndView deleteMember(@RequestParam("memberid") Long memberid) {
		mr.deleteById(memberid);
		return new ModelAndView("redirect:/memberadmin");
	}

	
	@RequestMapping(value = { "/deleteteam" })
	public ModelAndView deleteTeam(@RequestParam("teamid") Long teamid) {
		tr.deleteById(teamid);
		return new ModelAndView("redirect:/teamadmin");
	}
	
	
	@RequestMapping("/addnewmember")
	public String addNewMember() {
		return "addnewmember";
	}
	

	@RequestMapping("/addmember")
	public ModelAndView addMember(@RequestParam("membername") String membername,
			@RequestParam("memberrole") String memberrole, @RequestParam("teamid") Long teamid) {
		Optional<Team> optionalTeam = tr.findById(teamid);
		Team team = optionalTeam.get();
		Member member = new Member(membername, memberrole, team);
		mr.save(member); //(member);
		return new ModelAndView("redirect:/memberadmin");
	}
	
	
	@RequestMapping("/addnewteam")
	public String addNewTeam() {
		return "addnewteam";
	}

	
	@RequestMapping("/addteam")
	public ModelAndView addTeam(@RequestParam("teamname") String teamname) {
		Team team = new Team(teamname);
		tP.save(team);
		return new ModelAndView("redirect:/teamadmin");
	}
}