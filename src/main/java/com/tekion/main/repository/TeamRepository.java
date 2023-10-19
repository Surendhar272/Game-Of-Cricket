package com.tekion.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekion.main.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

	List<Team> findByMatchId(Integer matchId);

}
