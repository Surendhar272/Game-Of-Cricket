package com.tekion.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekion.main.entity.Team;
import com.tekion.main.repository.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository repo;
	
	
	 //Save the object in db
    public Team saveTeam(Team team){
      return repo.save(team);
    }
    
    //Save the List of objects
    public List<Team> saveTeams(List<Team> teams) {
		return repo.saveAll(teams);
	}
    
    //Update the the existing object
	public Team updateTeam(Long id, Team team) {
	        Team existingTeam=repo.findById(id).orElse(team);
	        existingTeam.setTeamname(team.getTeamname());
	        existingTeam.setPlayers(team.getPlayers());
	        return repo.save(existingTeam);
	    }

	//Get the list of team objects
	public List<Team> getTeams() {
		return repo.findAll();
	}
	
	//get a Team form the database using id
    public  Team getTeamById(Long id){
        return repo.findById(id).orElse(null);
    }


	
}
