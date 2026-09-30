package edu.asu.SER421.Activity2.api.controllers;

import edu.asu.SER421.Activity2.api.modelhelpers.SurveyRequest;
import edu.asu.SER421.Activity2.model.Survey;
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

    @RequestMapping(method = RequestMethod.POST)
    public Survey createSurveyItem(@RequestBody SurveyRequest surveyRequest){

        return __surveyServ.createSurvey(surveyRequest.getSurveyItemsList());
    }

}
