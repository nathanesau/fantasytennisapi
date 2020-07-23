package com.tennis.fantasytennisapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.tennis.fantasytennisapi.entity.SimpleEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface SimpleRepository extends JpaRepository<SimpleEntity, Integer> {

    @Modifying
    @Query(value = "DELETE FROM simple WHERE field1 = :field1 AND field2 = :field2", nativeQuery = true)
    void deleteSimple(@Param("field1") String field1, @Param("field2") String field2);

    @Query(value = "SELECT * from simple", nativeQuery = true)
    List<SimpleEntity> getSimple();

}