package com.app.quiz.dao;

import com.app.quiz.entities.Catalogue;
import com.app.quiz.entities.Question;
import com.app.quiz.entities.User;

import java.util.List;

/**
 * Created by 300041737 on 27/07/19.
 */
public interface UserDao {

    public List<User> getUserInfo(Long userId);
    public void submitAns (Catalogue catalogue);
    public void register(User user);
    public Boolean checkEmailExists(String email);
    public Boolean checkQuestionAlreadyAnswered(Long userId, Long quesId);

    }
