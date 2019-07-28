package com.app.quiz.entries;

import java.util.List;

/**
 * Created by 300041737 on 27/07/19.
 */
public class UserEntry {



    private Long id;

    private String email;

    private List<CatalogueEntry> catalogueEntries;

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

    public List<CatalogueEntry> getCatalogueEntries() {
        return catalogueEntries;
    }

    public void setCatalogueEntries(List<CatalogueEntry> catalogueEntries) {
        this.catalogueEntries = catalogueEntries;
    }
}
