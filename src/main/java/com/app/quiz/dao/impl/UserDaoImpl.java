package com.app.quiz.dao.impl;

import com.app.quiz.dao.QuestionDao;
import com.app.quiz.dao.UserDao;
import com.app.quiz.entities.Catalogue;
import com.app.quiz.entities.Question;
import com.app.quiz.entities.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by 300041737 on 27/07/19.
 */
public class UserDaoImpl implements UserDao {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUserInfo(Long userId) {
        Session session = this.sessionFactory.openSession();
        List<User> userList = session.createQuery("select c from User c where c.id=:userid").setParameter("userid",userId).list();
        session.close();
        return userList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Boolean checkEmailExists(String email) {
        Session session = this.sessionFactory.openSession();
        List<User> userList = session.createQuery("select c from User c where c.email=:email").setParameter("email",email).list();
        session.close();
        if(userList.size() > 0){
            return  Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }


    @SuppressWarnings("unchecked")
    @Override
    public Boolean checkQuestionAlreadyAnswered(Long userId, Long quesId) {
        Session session = this.sessionFactory.openSession();
        List<Catalogue> catalogueList = session.createQuery("select c from Catalogue c where c.question.id=:ques_id and c.user.id=:user_id").setParameter("user_id",userId).setParameter("ques_id",quesId).list();
        session.close();
        if(catalogueList.size() > 0){
            return  Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void submitAns (Catalogue catalogue) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(catalogue);
        session.getTransaction().commit();
        session.close();
    }

    public void register(User user){
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }



}

