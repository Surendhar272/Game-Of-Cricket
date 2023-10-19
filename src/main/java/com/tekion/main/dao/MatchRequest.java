package com.tekion.main.dao;

import com.tekion.main.entity.Matchentity;

public class MatchRequest {

	private Matchentity matchentity;
	
	public MatchRequest() {
		
	}

	public MatchRequest(Matchentity matchentity) {
		super();
		this.matchentity = matchentity;
	}

	public Matchentity getMatch() {
		return matchentity;
	}

	public void setMatch(Matchentity matchentity) {
		this.matchentity = matchentity;
	}

	@Override
	public String toString() {
		return "MatchRequest [matchentity=" + matchentity + "]";
	}
	
	
}
