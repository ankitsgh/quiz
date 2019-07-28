package com.app.quiz.manager.impl;

import com.app.quiz.dao.QuestionDao;
import com.app.quiz.dao.impl.QuestionDaoImpl;
import com.app.quiz.entities.Option;
import com.app.quiz.entities.Question;
import com.app.quiz.entries.OptionEntry;
import com.app.quiz.entries.QuestionEntry;
import com.app.quiz.manager.QuestionManager;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by 300041737 on 27/07/19.
 */
public class QuestionManagerImpl implements QuestionManager {

    private QuestionDao questionDao;

    public QuestionDao getQuestionDao() {
        return questionDao;
    }

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public List<QuestionEntry> getAllQuestions() {
        List<Question> questions = questionDao.getAllQuestion();
        List<QuestionEntry> questionEntries = convertToEntryQuestions(questions);
        return questionEntries;
    }
    public QuestionEntry getQuestionById(Long quesId) throws Exception {
        List<Question> questions = questionDao.getQuestionById(quesId);
        List<QuestionEntry> questionEntries = convertToEntryQuestions(questions);
        if(questionEntries.size() != 1){
            throw new Exception("Number of entries is not equal to 1");
        }
        return questionEntries.get(0);
    }


    public List<QuestionEntry> convertToEntryQuestions(List<Question> questions){
        List<QuestionEntry> questionEntries = Lists.newArrayList();
        for(Question question: questions) {
            List<Option> options = question.getOptions();
            List<OptionEntry> optionEntries = convertToEntryOptions(options);
            QuestionEntry questionEntry = new QuestionEntry();
            questionEntry.setOptionEntryList(optionEntries);
            questionEntry.setQuestion(question.getQuestion());
            questionEntry.setId(question.getId());
            questionEntries.add(questionEntry);

        }
        return questionEntries;

    }

    public List<OptionEntry> convertToEntryOptions(List<Option> options){
        List<OptionEntry> optionEntries = Lists.newArrayList();
        for(Option option : options) {
            OptionEntry optionEntry = new OptionEntry();
            optionEntry.setId(option.getId());
            optionEntry.setOption(option.getOption());
            if(option.getQuestion()!=null){
                optionEntry.setQuestionId(option.getQuestion().getId());
            }
            optionEntries.add(optionEntry);

        }
        return optionEntries;
    }

}
