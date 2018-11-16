package com.example.developers.repository;

import com.example.developers.model.ProgLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mk.
 */

@Repository
public interface ProgRepository extends JpaRepository<ProgLanguage, Long> {

}
