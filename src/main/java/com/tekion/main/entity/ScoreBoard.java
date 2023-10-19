package com.tekion.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="SCORE")
public class ScoreBoard {
	
	@Id
	private Integer id;
	
	private String result;
	
	public ScoreBoard() {

	}
	
	public ScoreBoard(Integer id, String result) {
		super();
		this.id = id;
		this.result = result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
