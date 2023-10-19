package com.tekion.main.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Matchentity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "MATCH_NAME")
	private String matchName;

	@OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Team> teamNames;
	
	public Matchentity() {
		
	}
	
	public Matchentity(int id, String matchName, List<Team> teamNames) {
		super();
		this.id = id;
		this.matchName = matchName;
		this.teamNames = teamNames;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Team> getTeamNames() {
		return teamNames;
	}

	public void setTeamNames(List<Team> teamNames) {
		this.teamNames = teamNames;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", matchName=" + matchName + ", teamNames=" + teamNames + "]";
	}
	
	
	
}
