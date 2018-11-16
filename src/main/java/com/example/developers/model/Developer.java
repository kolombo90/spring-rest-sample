package com.example.developers.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by MK.
 */
@Entity
@Table(name = "developer")
@EntityListeners(AuditingEntityListener.class)

public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String fullName;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "dev_lang",
            joinColumns = {@JoinColumn(name = "dev_id")},
            inverseJoinColumns = {@JoinColumn(name = "lang_id")})
    private Set<ProgLanguage> progLanguages = new HashSet<>();

    public Developer(String fullName) {
        this.fullName = fullName;
    }

    //no arguments constructor for deserialisation purpose
    public Developer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<ProgLanguage> getProgLanguages() {
        return progLanguages;
    }

    public void setProgLanguages(Set<ProgLanguage> progLanguages) {
        this.progLanguages = progLanguages;
    }
}
