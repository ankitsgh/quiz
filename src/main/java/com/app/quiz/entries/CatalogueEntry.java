package com.app.quiz.entries;

/**
 * Created by 300041737 on 27/07/19.
 */
public class CatalogueEntry {

    private Long id;

    private UserEntry userEntry;

    private QuestionEntry questionEntry;

    private OptionEntry optionEntry;

    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntry getUserEntry() {
        return userEntry;
    }

    public void setUserEntry(UserEntry userEntry) {
        this.userEntry = userEntry;
    }

    public QuestionEntry getQuestionEntry() {
        return questionEntry;
    }

    public void setQuestionEntry(QuestionEntry questionEntry) {
        this.questionEntry = questionEntry;
    }

    public OptionEntry getOptionEntry() {
        return optionEntry;
    }

    public void setOptionEntry(OptionEntry optionEntry) {
        this.optionEntry = optionEntry;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
