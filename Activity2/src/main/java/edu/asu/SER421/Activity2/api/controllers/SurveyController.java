package edu.asu.SER421.Activity2.api.controllers;

import edu.asu.SER421.Activity2.api.modelhelpers.AddSurveyItemRequest;
import edu.asu.SER421.Activity2.api.modelhelpers.SurveyRequest;
import edu.asu.SER421.Activity2.model.Survey;
import edu.asu.SER421.Activity2.model.SurveyItem;
import edu.asu.SER421.Activity2.services.SurveyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/survey")
@RestController
public class SurveyController {
    private SurveyService __surveyServ = SurveyService.getInstance();

    //Fourth endpoint, returns a list of all surveys created
    @GetMapping
    public ResponseEntity<List<Survey>> returnSurveys() throws Throwable {
        List<Survey> surveys =  __surveyServ.getSurveys();
        if(surveys != null){
            return new ResponseEntity<>(surveys, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Fifth endpoint, returns one survey based on the id put in the url path
    @GetMapping("/{id}")
    public ResponseEntity<Survey> returnSurvey(@PathVariable Integer id){
        Survey survey =  __surveyServ.getSurvey(id);
        if(survey != null){
            return new ResponseEntity<>(survey, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Second endpoint, creates a new survey
    // Param surveyRequest: surveyItemsList (a list of survey items that will be added to the new survey created)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Survey> createSurvey(@RequestBody SurveyRequest surveyRequest){
        Survey survey = __surveyServ.createSurvey(surveyRequest.getSurveyItemsList());
        if(survey != null){
            return new ResponseEntity<>(survey, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Third endpoint, add a survey item to an existing survey
    //Param AddSurveyItemRequest: surveys(a list of survey ids that will get the item added to it)
    //The path id is the survey item that will be added to the surveys
    @PutMapping("/{id}")
    public ResponseEntity<SurveyItem> addSurveyItem(@PathVariable Integer id, @RequestBody AddSurveyItemRequest addSurveyItemRequest){
        SurveyItem surveyItem = __surveyServ.addSurveyItem(id, addSurveyItemRequest.getSurveys());
        if(surveyItem != null){
            return new ResponseEntity<>(surveyItem, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Tenth endpoint, this endpoint changes the state of a survey specified to DELETED(doesn't actually delete the survey)
    // the path id is  the id of the survey that will be deleted
    @PatchMapping("/{id}")
    public Survey deleteSurvey(@PathVariable Integer id){
        return __surveyServ.deleteSurvey(id);
    }
}