package edu.asu.SER421.Activity2.api.controllers;

import edu.asu.SER421.Activity2.services.SurveyInstanceService;
import edu.asu.SER421.Activity2.services.SurveyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/survey/instance")
@RestController
public class SurveyInstanceController {
    private SurveyInstanceService __instanceService = SurveyInstanceService.getInstance();
    private SurveyService __surveyService = SurveyService.getInstance();


    @GetMapping
    public String getSurveyInstance(){
        return __surveyService.getSurvey(0).getSurveyItemsList().getFirst().getQuestion();
    }
}