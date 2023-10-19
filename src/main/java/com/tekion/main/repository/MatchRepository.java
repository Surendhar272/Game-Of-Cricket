package com.tekion.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekion.main.entity.Matchentity;


@Repository
public interface MatchRepository extends JpaRepository<Matchentity, Integer>{

}
