package com.app.quiz;

import com.app.quiz.entries.Form;
import com.app.quiz.entries.QuestionEntry;
import com.app.quiz.response.QuestionResponse;
import com.app.quiz.response.StatusResponse;
import com.app.quiz.service.BasicServices;
import com.app.quiz.service.impl.BasicServicesImpl;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class Controllers {

    private BasicServicesImpl basicServices;

    @Autowired(required = true)
    @Qualifier(value = "basicServices")
    public void setBasicServices(BasicServicesImpl basicServices) {
        this.basicServices = basicServices;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public StatusResponse register(@RequestParam("userId")String email){
        return this.basicServices.register(email);
    }

    @RequestMapping(value = "/getAllAnsweredQues", method = RequestMethod.GET)
    @ResponseBody
    public QuestionResponse getAnsweredQuesByUser(@RequestParam("userId") Long userId){

        return this.basicServices.getAnsweredQuesByUser(userId);
    }

    @RequestMapping(value = "/getAllUnAnsweredQues", method = RequestMethod.GET)
    @ResponseBody
    public QuestionResponse getAllUnansweredQues(@RequestParam("userId") Long userId){
        return  this.basicServices.getAllUnansweredQues(userId);

    }
    @RequestMapping(value = "/submitAns", method = RequestMethod.POST)
    public StatusResponse submitAns(@RequestBody  Form form){
        return  this.basicServices.submitAns(form.getUserId(),form.getQuestionId(),form.getOptionId());
    }

}
