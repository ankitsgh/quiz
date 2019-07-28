package com.app.quiz.entries;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by 300041737 on 28/07/19.
 */

@XmlRootElement(name = "form")
public class Form {

    private Long userId;

    private Long questionId;

    private Long optionId;

    public Form(Long userId, Long questionId, Long optionId) {
        this.userId = userId;
        this.questionId = questionId;
        this.optionId = optionId;
    }

    public Form() {
    }

    @XmlElement(name = "userId")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @XmlElement(name = "questionId")

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    @XmlElement(name = "optionId")

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }
}
