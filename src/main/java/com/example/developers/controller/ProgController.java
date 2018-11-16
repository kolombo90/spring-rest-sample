package com.example.developers.controller;

import com.example.developers.model.ProgLanguage;
import com.example.developers.repository.ProgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by MK.
 */
@RestController
@RequestMapping("/api")
public class ProgController {

    @Autowired
    ProgRepository progRepository;

    @GetMapping("/languages")
    public List<ProgLanguage> getAllDevelopers() {
        return progRepository.findAll();
    }

    @PostMapping("/language")
    ProgLanguage addProgLanguage(@RequestBody ProgLanguage newLanguage) {
        return progRepository.save(newLanguage);
    }
}
