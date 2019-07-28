package com.app.quiz.entities;

import javax.persistence.*;

/**
 * Created by 300041737 on 27/07/19.
 */

@Entity
@Table(name = "Catalogue")

@NamedQueries({
        @NamedQuery(name = "Catalogue.getAnsweredQuestions", query = "select i from Catalogue i where i.user.id = :userId"),
})

public class Catalogue {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false, fetch= FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne(optional = false)
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne(optional = false)
    @JoinColumn(name = "option_id")
    private Option option;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
