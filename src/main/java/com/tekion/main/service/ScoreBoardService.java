package com.tekion.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekion.main.entity.ScoreBoard;
import com.tekion.main.entity.Team;
import com.tekion.main.repository.ScoreBoardRepository;

@Service
public class ScoreBoardService {
	
	@Autowired
	private ScoreBoardRepository scorerepo;
	
	//Save the object in db
    public ScoreBoard saveTeam(ScoreBoard score){
      return scorerepo.save(score);
    }

}
