package com.app.quiz.service.impl;

import com.app.quiz.entities.Question;
import com.app.quiz.entries.QuestionEntry;
import com.app.quiz.entries.UserEntry;
import com.app.quiz.manager.QuestionManager;
import com.app.quiz.manager.UserManager;
import com.app.quiz.manager.impl.QuestionManagerImpl;
import com.app.quiz.response.QuestionResponse;
import com.app.quiz.response.StatusResponse;
import com.app.quiz.service.BasicServices;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import java.util.List;

/**
 * Created by 300041737 on 27/07/19.
 */
public class BasicServicesImpl implements BasicServices{

    private QuestionManager questionManager;

    private UserManager userManager;



    @Override
    public QuestionResponse getAnsweredQuesByUser(Long userId){
        QuestionResponse questionResponse = new QuestionResponse();
        try {
            questionResponse.setQuestionEntries(userManager.getAnsweredQuestionbyUser(userId));
            questionResponse.setStatusCode(200);
            questionResponse.setMessage("Success");
        } catch (Exception e){
            questionResponse.setStatusCode(500);
            questionResponse.setMessage(e.getMessage());

        }
        return questionResponse;

    }

    @Override
    public QuestionResponse getAllUnansweredQues(Long userId){
        QuestionResponse questionResponse = new QuestionResponse();
        try {
            questionResponse.setQuestionEntries(userManager.getUnAnsweredQuestionbyUser(userId));
            questionResponse.setStatusCode(200);
            questionResponse.setMessage("Success");
        } catch (Exception e) {
            questionResponse.setStatusCode(500);
            questionResponse.setMessage(e.getMessage());
        }
        return questionResponse;
    }

    @Override
    public StatusResponse submitAns(Long userId, Long quesId, Long optionId){
        try {
            if (userManager.submitAnswerToQues(userId, quesId, optionId)) {
                return new StatusResponse(200,"SUCCESS");
            } else {
                return new StatusResponse(500,"ERROR");

            }
        } catch (Exception e){
            return new StatusResponse(500,e.getMessage());

        }

    }

    @Override
    public StatusResponse register(String email){
        try {
            if (userManager.register(email)) {
                return new StatusResponse(200,"SUCCESS");
            } else {
                return new StatusResponse(500,"ERROR");

            }
        } catch (Exception e){
            return new StatusResponse(500,e.getMessage());

        }

}


    public QuestionManager getQuestionManager() {
        return questionManager;
    }

    public void setQuestionManager(QuestionManager questionManager) {
        this.questionManager = questionManager;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
}
