package com.app.quiz.dao;

import com.app.quiz.entities.Question;

import java.util.List;

/**
 * Created by 300041737 on 27/07/19.
 */
public interface QuestionDao {

    public List<Question> getAllQuestion();
    public List<Question> getQuestionById(Long userId);


}
