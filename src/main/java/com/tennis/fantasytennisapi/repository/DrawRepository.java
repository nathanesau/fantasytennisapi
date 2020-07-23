package com.tennis.fantasytennisapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.tennis.fantasytennisapi.entity.DrawEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface DrawRepository extends JpaRepository<DrawEntity, Integer> {
    
    @Query(value = "SELECT * from draw", nativeQuery = true)
    List<DrawEntity> getDraws();

}