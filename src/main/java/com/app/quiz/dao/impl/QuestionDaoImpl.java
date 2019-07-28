package com.app.quiz.dao.impl;

import com.app.quiz.dao.QuestionDao;
import com.app.quiz.entities.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by 300041737 on 27/07/19.
 */
public class QuestionDaoImpl implements QuestionDao {


        private SessionFactory sessionFactory;

        public void setSessionFactory(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

    @SuppressWarnings("unchecked")
    @Override
    public List<Question> getAllQuestion() {
        Session session = this.sessionFactory.openSession();
        List<Question> questionList = session.createQuery("FROM Question").list();
        session.close();
        return questionList;
    }

    @SuppressWarnings("unchecked")
    public List<Question> getQuestionById(Long Id) {
        Session session = this.sessionFactory.openSession();
        List<Question> questionList = session.createQuery("FROM Question q where q.id = :id").setParameter("id",Id).list();
        session.close();
        return questionList;
    }
}

