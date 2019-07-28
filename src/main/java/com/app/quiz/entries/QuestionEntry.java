package com.app.quiz.entries;

import java.util.List;

/**
 * Created by 300041737 on 27/07/19.
 */
public class QuestionEntry {

    private Long id;
    private String question;
    private List<OptionEntry> optionEntryList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<OptionEntry> getOptionEntryList() {
        return optionEntryList;
    }

    public void setOptionEntryList(List<OptionEntry> optionEntryList) {
        this.optionEntryList = optionEntryList;
    }
}
