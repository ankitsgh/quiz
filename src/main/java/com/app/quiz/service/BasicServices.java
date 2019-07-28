package com.app.quiz.service;

import com.app.quiz.entries.QuestionEntry;
import com.app.quiz.entries.UserEntry;
import com.app.quiz.response.StatusResponse;

import javax.ws.rs.*;
import java.util.List;


/**
 * Created by 300041737 on 27/07/19.
 */

@Path("/apis")

public interface BasicServices {

    @POST
    @Produces({"application/xml", "application/json"})
    @Path("/register")
    public StatusResponse register(@FormParam("email") String email);

    @GET
    @Produces({"application/xml", "application/json"})
    @Path("/getAnsweredQuesByUser")
    public StatusResponse getAnsweredQuesByUser(@QueryParam("userId") Long userId);

    @GET
    @Produces({"application/xml", "application/json"})
    @Path("/getAllUnansweredQues")
    public StatusResponse getAllUnansweredQues(@QueryParam("userId") Long userId);

    @POST
    @Produces({"application/xml", "application/json"})
    @Path("/submitAns")
    public StatusResponse submitAns(@FormParam("userId") Long userId, @FormParam("questionId") Long questionId, @FormParam("optionId") Long optionId);


    }
