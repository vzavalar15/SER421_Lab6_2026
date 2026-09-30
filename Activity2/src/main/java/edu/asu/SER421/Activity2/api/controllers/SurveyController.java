package edu.asu.SER421.Activity2.api.controllers;

import edu.asu.SER421.Activity2.api.modelhelpers.AddSurveyItemRequest;
import edu.asu.SER421.Activity2.api.modelhelpers.SurveyRequest;
import edu.asu.SER421.Activity2.model.Survey;
import edu.asu.SER421.Activity2.model.SurveyItem;
import edu.asu.SER421.Activity2.services.SurveyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/survey")
@RestController
public class SurveyController {
    private SurveyService __surveyServ = SurveyService.getInstance();

    @GetMapping
    public List<Survey> returnSurveys() throws Throwable {
        return __surveyServ.getSurveys();
    }

    @GetMapping("/{id}")
    public Survey returnSurvey(@PathVariable Integer id){
        return __surveyServ.getSurvey(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Survey createSurveyItem(@RequestBody SurveyRequest surveyRequest){
        return __surveyServ.createSurvey(surveyRequest.getSurveyItemsList());
    }

    @PutMapping
    public SurveyItem addSurveyItem(@RequestBody AddSurveyItemRequest addSurveyItemRequest){
        return __surveyServ.addSurveyItem(addSurveyItemRequest.getQuestion(), addSurveyItemRequest.getCorrectAnswer(), addSurveyItemRequest.getAnswerOptions(), addSurveyItemRequest.getSurveys());
    }
}