package com.tekion.main.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekion.main.entity.Matchentity;
import com.tekion.main.entity.Team;
import com.tekion.main.service.MatchService;

@RestController
@RequestMapping("/match")
public class MatchController {

	
	private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }
	
    
    @PostMapping("/match-start")
    public Matchentity createMatch(@RequestBody Matchentity match) {
        Matchentity savedMatch = matchService.createMatch(match);
        return savedMatch;
    }

    @GetMapping("/search/{matchId}")
    public ResponseEntity<Matchentity> getMatch(@PathVariable Integer matchId) {
        Matchentity match = matchService.getMatch(matchId);
        return new ResponseEntity<>(match, HttpStatus.OK);
    }

//	@PostMapping("/match-start")
//	public Matchentity startMatch(@RequestBody ) {
//		return matchService;
//	}
//	
//	@GetMapping("/findAllMatch")
//	public List<Matchentity> findAllMatch(){
//		return matchRepo.findAll();
//	}
	
//	@PostMapping("/start")
//    public String simulateMatch(@RequestBody Team team_A, @RequestBody Team team_B) {
//        int runsTeamA = simulateTeamScore(team_A);
//        int runsTeamB = simulateTeamScore(team_B);
//        
//        String result = determineWinner(runsTeamA, runsTeamB, team_A, team_B);
//        
////        System.out.println(result);
//        return result;
//    }

	private int simulateTeamScore(Team team) {
		Random random = new Random();

        
        int runs=0,balls=6,players=team.getPlayers();
        
        
        while (balls>0 && players>0) {
        	 int randomruns = random.nextInt(8);
        	 if(randomruns==7) {
        		 players--;
        	 }else {
        		 runs=randomruns+runs;
        	 }   	 
        	 balls--;
        }
 
        return runs;
    }
	
	private String determineWinner(int runsTeamA, int runsTeamB, Team team_A, Team team_B) {
        if (runsTeamA > runsTeamB) {
            return team_A.getTeamname() + " wins the match!";
        } else if (runsTeamB > runsTeamA) {
            return team_B.getTeamname() + " wins the match!";
        } else {
            return "It's a tie!";
        }
	}
}
