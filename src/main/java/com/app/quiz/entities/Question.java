package com.app.quiz.entities;


import javax.persistence.*;
import java.util.List;

/**
 * Created by 300041737 on 27/07/19.
 */


@Entity
@Table(name = "Question")

@NamedQueries({
        @NamedQuery(name = "Question.getAllQues", query = "select i from Question i"),
})
public class Question {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="question")
    private String question;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question")
    private List<Option> options;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
