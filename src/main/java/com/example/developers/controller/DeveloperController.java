package com.example.developers.controller;

import com.example.developers.exception.ResourceNotFoundException;
import com.example.developers.model.Developer;
import com.example.developers.model.ProgLanguage;
import com.example.developers.repository.DeveloperRepository;
import com.example.developers.repository.ProgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/**
 * Created by MK.
 */
@RestController
@RequestMapping("/api")
public class DeveloperController {

    @Autowired
    DeveloperRepository devRepository;

    @Autowired
    ProgRepository progRepository;

    @GetMapping("/developers")
    public List<Developer> getAllDevelopers() {
        return devRepository.findAll();
    }

    //get the list of developers given the language label (string)
    @GetMapping("/devByLang/{lang}")
    public List<Developer> getDevByLang(@PathVariable(value = "lang") String lang) {
        return devRepository.findByProgLanguages_Label(lang);
    }

    @PostMapping("/developer")
    Developer addDeveloper(@RequestBody Developer newDeveloper) {
        return devRepository.save(newDeveloper);
    }

    @PutMapping("/developer/{id}")
    public Developer updateDeveloper(@PathVariable(value = "id") Long devId,
                                     @Valid @RequestBody Developer devDetails) {

        Developer dev = devRepository.findById(devId)
                .orElseThrow(() -> new ResourceNotFoundException("Developer", "id", devId));

        dev.setFullName(devDetails.getFullName());


        Developer updatedDev = devRepository.save(dev);
        return updatedDev;

    }

    @PutMapping("/developer/{devId}/add-language/{langId}")
    public Developer addLangToDev(@PathVariable(value = "devId") Long devId, @PathVariable(value = "langId") Long langId) {

        Developer dev = devRepository.findById(devId)
                .orElseThrow(() -> new ResourceNotFoundException("Developer", "id", devId));

        ProgLanguage lang = progRepository.findById(langId)
                .orElseThrow(() -> new ResourceNotFoundException("Programming language", "id", langId));

        Set<ProgLanguage> newLanglist = dev.getProgLanguages();

        if (!newLanglist.contains(lang)) {
            newLanglist.add(lang);
            dev.setProgLanguages(newLanglist);
        }


        Developer updatedDev = devRepository.save(dev);
        return updatedDev;

    }
}
