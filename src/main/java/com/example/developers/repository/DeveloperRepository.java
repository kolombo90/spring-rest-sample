package com.example.developers.repository;

import com.example.developers.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mk.
 */

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    List<Developer> findByProgLanguages_Label(String label);

}
