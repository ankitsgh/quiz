package com.app.quiz.entities;

import javax.persistence.*;

/**
 * Created by 300041737 on 27/07/19.
 */

@Entity
@Table(name = "Optionss")
public class Option {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;

    @Column(name="option")
    private String option;

    @ManyToOne(fetch= FetchType.EAGER)//, cascade= CascadeType.ALL)
    //@Fetch(FetchMode.JOIN)
    @JoinColumn(name= "question_id" )//, insertable=false, updatable=false)
    private Question question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}


