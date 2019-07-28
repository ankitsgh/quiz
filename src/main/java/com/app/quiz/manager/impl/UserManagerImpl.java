package com.app.quiz.manager.impl;

import com.app.quiz.dao.QuestionDao;
import com.app.quiz.dao.UserDao;
import com.app.quiz.entities.Catalogue;
import com.app.quiz.entities.Option;
import com.app.quiz.entities.Question;
import com.app.quiz.entities.User;
import com.app.quiz.entries.CatalogueEntry;
import com.app.quiz.entries.OptionEntry;
import com.app.quiz.entries.QuestionEntry;
import com.app.quiz.entries.UserEntry;
import com.app.quiz.manager.QuestionManager;
import com.app.quiz.manager.UserManager;
import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 300041737 on 28/07/19.
 */
public class UserManagerImpl implements UserManager {

    private UserDao userDao;
    private QuestionManager questionManager;

    @Override
    public UserEntry getUserInfo(Long userId) throws Exception{
        List<User> users= userDao.getUserInfo(userId);
        List<UserEntry> userEntries = convertToEntryUsers(users);
        if(userEntries.size() != 1){
            throw new Exception("Number of entries is not equal to 1");
        }
        return userEntries.get(0);

    }

    public List<QuestionEntry> getAnsweredQuestionbyUser(Long userId) throws Exception{
        List<QuestionEntry> questionEntries = Lists.newArrayList();
        UserEntry userEntry = getUserInfo(userId);
        List<CatalogueEntry> catalogueEntries = userEntry.getCatalogueEntries();
        for(CatalogueEntry catalogueEntry: catalogueEntries){
            questionEntries.add(catalogueEntry.getQuestionEntry());
        }
        return  questionEntries;
    }

    public List<QuestionEntry> getUnAnsweredQuestionbyUser(Long userId) throws Exception{
        List<QuestionEntry> questionEntries = Lists.newArrayList();
        UserEntry userEntry = getUserInfo(userId);
        Set<Long> quesIds = new HashSet<>();
        List<CatalogueEntry> catalogueEntries = userEntry.getCatalogueEntries();
        for(CatalogueEntry catalogueEntry: catalogueEntries){
            quesIds.add(catalogueEntry.getQuestionEntry().getId());
        }

        List<QuestionEntry> allQues = questionManager.getAllQuestions();
        for(QuestionEntry questionEntry : allQues){
            if(!quesIds.contains(questionEntry.getId())){
                questionEntries.add(questionEntry);
            }
        }
        return(questionEntries);
    }
    @Override
    public Boolean submitAnswerToQues(Long userId, Long quesId, Long optionId) throws Exception{
        if(userDao.checkQuestionAlreadyAnswered(userId,quesId)){
            throw new Exception("Question is already answered");
        }
        Catalogue catalogue = new Catalogue();

        User user = new User();
        user.setId(userId);
        Question question = new Question();
        question.setId(quesId);

        Option option = new Option();
        option.setId(optionId);
        catalogue.setUser(user);
        catalogue.setOption(option);
        catalogue.setQuestion(question);

        userDao.submitAns(catalogue);
        return Boolean.TRUE;
    }

    public Boolean register(String  email) throws Exception{
        if(userDao.checkEmailExists(email)){
            throw new Exception("Email Already registered");
        }
        User user = new User();
        user.setEmail(email);
        userDao.register(user);
        return Boolean.TRUE;
    }




    private List<UserEntry> convertToEntryUsers(List<User> users){
        List<UserEntry> userEntries = Lists.newArrayList();
        for(User user: users){
            UserEntry userEntry = new UserEntry();
            userEntry.setId(user.getId());
            userEntry.setEmail(user.getEmail());
            userEntry.setCatalogueEntries(convertToEntryCatalogue(user.getCatalogueList()));
            userEntries.add(userEntry);

        }
        return userEntries;
    }


    private List<CatalogueEntry> convertToEntryCatalogue(List<Catalogue> catalogues){
        List<CatalogueEntry> catalogueEntries = Lists.newArrayList();
        for(Catalogue catalogue: catalogues){
            CatalogueEntry catalogueEntry = new CatalogueEntry();
            catalogueEntry.setId(catalogue.getId());
            catalogueEntry.setOptionEntry(questionManager.convertToEntryOptions(Lists.newArrayList(catalogue.getOption())).get(0));
            catalogueEntry.setQuestionEntry(questionManager.convertToEntryQuestions(Lists.newArrayList(catalogue.getQuestion())).get(0));
            catalogueEntry.setUserId(catalogue.getUser().getId());
            catalogueEntries.add(catalogueEntry);
        }
        return catalogueEntries;

    }
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public QuestionManager getQuestionManager() {
        return questionManager;
    }

    public void setQuestionManager(QuestionManager questionManager) {
        this.questionManager = questionManager;
    }

}
