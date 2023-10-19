package com.tekion.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekion.main.entity.Team;
import com.tekion.main.service.TeamService;

@RestController
@RequestMapping("/match")
public class Controller {

	@Autowired
	private TeamService service;
	
	
	@PostMapping("/addTeam")
    public Team addTeam(@RequestBody Team team){
        return service.saveTeam(team);
    }
	
	@PostMapping("/addTeams")
    public List<Team> addTeams(@RequestBody List<Team> teams){
        return service.saveTeams(teams);
    }
	
	@PutMapping("/update/{id}")
    public Team updateTeam(@PathVariable Long id, @RequestBody Team team){
        return service.updateTeam(id, team);
    }
	
	@GetMapping("/getTeams")
    public List<Team> findAllTeams(){
        return service.getTeams();
    }
	
	  @GetMapping("/getTeamById/{id}")
	    public Team findProductById(@PathVariable Long id){
	        return service.getTeamById(id);
	    }

	
}
