package com.app.quiz.response;

import com.app.quiz.entries.QuestionEntry;

import java.util.List;

/**
 * Created by 300041737 on 28/07/19.
 */
public class QuestionResponse extends StatusResponse {

    private List<QuestionEntry> questionEntries;

    public List<QuestionEntry> getQuestionEntries() {
        return questionEntries;
    }

    public void setQuestionEntries(List<QuestionEntry> questionEntries) {
        this.questionEntries = questionEntries;
    }


}
