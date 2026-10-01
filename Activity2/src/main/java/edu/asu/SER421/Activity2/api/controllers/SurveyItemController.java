package edu.asu.SER421.Activity2.api.controllers;

import edu.asu.SER421.Activity2.api.modelhelpers.AddSurveyItemRequest;
import edu.asu.SER421.Activity2.api.modelhelpers.SurveyItemRequest;
import edu.asu.SER421.Activity2.model.SurveyItem;
import edu.asu.SER421.Activity2.services.SurveyItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/item")
@RestController
public class SurveyItemController {
    private SurveyItemService __surveyItemServ = SurveyItemService.getInstance();

    //used for debugging returns all survey items
    @GetMapping
    public List<SurveyItem> returnSurveyItems() throws Throwable{
        return __surveyItemServ.getSurveyItems();
    }

    //First endpoint, creates a new survey item
    // Param SurveyItemRequest: question, correct answer, answer options
    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<SurveyItem> createSurveyItem(@RequestBody SurveyItemRequest surveyItemRequest){
        SurveyItem surveyItem = __surveyItemServ.createSurveyItem(surveyItemRequest.getQuestion(), surveyItemRequest.getCorrectAnswer(), surveyItemRequest.getAnswerOptions());
        if(surveyItem != null){
            return new ResponseEntity<>(surveyItem, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}