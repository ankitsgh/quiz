package com.app.quiz.manager;

import com.app.quiz.entities.Option;
import com.app.quiz.entities.Question;
import com.app.quiz.entries.OptionEntry;
import com.app.quiz.entries.QuestionEntry;

import java.util.List;

/**
 * Created by 300041737 on 27/07/19.
 */
public interface QuestionManager {

    public List<QuestionEntry> getAllQuestions();

    public List<QuestionEntry> convertToEntryQuestions(List<Question> questions);

    public List<OptionEntry> convertToEntryOptions(List<Option> options);
    public QuestionEntry getQuestionById(Long quesId) throws Exception;


}