package edu.asu.SER421.Activity2.api.controllers;

import edu.asu.SER421.Activity2.api.modelhelpers.SurveyItemRequest;
import edu.asu.SER421.Activity2.model.SurveyItem;
import edu.asu.SER421.Activity2.services.SurveyItemService;
import edu.asu.SER421.Activity2.services.impl.SurveyItemServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/item")
@RestController
public class SurveyItemController {
    private SurveyItemService __SurveyItemServ = SurveyItemService.getInstance();

    @GetMapping
    public List<SurveyItem> returnSurveyItems() throws Throwable{
        return __SurveyItemServ.getSurveyItems();
    }

    @RequestMapping(method= RequestMethod.POST)
    public SurveyItem createSurveyItem(@RequestBody SurveyItemRequest surveyItemRequest){
        System.out.println(surveyItemRequest.getQuestion());
        return __SurveyItemServ.createSurveyItem(surveyItemRequest.getQuestion(), surveyItemRequest.getCorrectAnswer(), surveyItemRequest.getAnswerOptions());
    }
}
