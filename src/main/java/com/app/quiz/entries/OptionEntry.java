package com.app.quiz.entries;

/**
 * Created by 300041737 on 27/07/19.
 */
public class OptionEntry {

    private Long id;
    private String option;
    private Long questionId;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
