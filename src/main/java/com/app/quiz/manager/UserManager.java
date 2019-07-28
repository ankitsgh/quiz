package com.app.quiz.manager;

import com.app.quiz.entries.QuestionEntry;
import com.app.quiz.entries.UserEntry;

import java.util.List;

/**
 * Created by 300041737 on 28/07/19.
 */
public interface UserManager {

    public UserEntry getUserInfo(Long userId) throws Exception;

    public Boolean submitAnswerToQues(Long userId, Long quesId, Long optionId) throws Exception;

    public Boolean register(String email) throws Exception;

    public List<QuestionEntry> getUnAnsweredQuestionbyUser(Long userId) throws Exception;

    public List<QuestionEntry> getAnsweredQuestionbyUser(Long userId) throws Exception;

}
