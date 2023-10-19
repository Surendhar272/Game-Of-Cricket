package com.tekion.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekion.main.entity.Matchentity;
import com.tekion.main.entity.Team;
import com.tekion.main.repository.MatchRepository;
import com.tekion.main.repository.TeamRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MatchService {

	private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository, TeamRepository teamRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
    }

    public Matchentity createMatch(Matchentity matchentity) {
        // Save the match
        Matchentity savedMatch = matchRepository.save(matchentity);
        
        // Set the match for each team and save them
        for (Team team : matchentity.getTeamNames()) {
            team.setMatch(savedMatch);
            teamRepository.save(team);
        }

        return savedMatch;
    }

    public Matchentity getMatch(Integer matchId) {
        return matchRepository.findById(matchId)
                .orElseThrow(() -> new EntityNotFoundException("Match not found with id: " + matchId));
    }

    public List<Matchentity> getAllMatches() {
        return matchRepository.findAll();
    }

    public Matchentity updateMatch(Integer matchId, Matchentity updatedMatch) {
        Matchentity existingMatch = getMatch(matchId);

        // Update match properties
        existingMatch.setMatchName(updatedMatch.getMatchName());

        return matchRepository.save(existingMatch);
    }

    public void deleteMatch(Integer matchId) {
        // Delete associated teams first to avoid foreign key constraint violation
        List<Team> teams = teamRepository.findByMatchId(matchId);
        teamRepository.deleteAll(teams);

        // Delete the match
        matchRepository.deleteById(matchId);
    }
}
