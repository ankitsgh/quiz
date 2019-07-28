package com.app.quiz.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by 300041737 on 27/07/19.
 */
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="email")
    private String email;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Catalogue> catalogueList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Catalogue> getCatalogueList() {
        return catalogueList;
    }

    public void setCatalogueList(List<Catalogue> catalogueList) {
        this.catalogueList = catalogueList;
    }
}
