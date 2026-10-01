package edu.asu.SER421.Activity2.api.controllers;

import edu.asu.SER421.Activity2.api.modelhelpers.AcceptAnswerRequest;
import edu.asu.SER421.Activity2.api.modelhelpers.SurveyInstanceRequest;
import edu.asu.SER421.Activity2.api.modelhelpers.SurveyRequest;
import edu.asu.SER421.Activity2.model.Survey;
import edu.asu.SER421.Activity2.model.SurveyInstance;
import edu.asu.SER421.Activity2.model.enums.SurveyInstanceState;
import edu.asu.SER421.Activity2.services.SurveyInstanceService;
import edu.asu.SER421.Activity2.services.SurveyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/survey/instance")
@RestController
public class SurveyInstanceController {
    private SurveyInstanceService __instanceService = SurveyInstanceService.getInstance();


    @GetMapping
    public List<SurveyInstance> getSurveyInstance(){
        return __instanceService.getSurveyInstances();
    }

    //Sixth endpoint, creates a new survey instance
    // Param surveyRequest: username, id of the survey that the instance will be made off.
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SurveyInstance> createSurveyInstance(@RequestBody SurveyInstanceRequest surveyInstanceRequest){
        SurveyInstance surveyInstance =  __instanceService.createSurveyInstance(surveyInstanceRequest.getUserName(),surveyInstanceRequest.getSurveyId());
        if(surveyInstance != null){
            return new ResponseEntity<>(surveyInstance, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Seventh endpoint, accept an answer for an item instance of a survey instance
    // Param surveyRequest: id of the survey item, the answer user chooses
    //The path id is to the survey instance that will be modified
    @PatchMapping("/{id}")
    public ResponseEntity<SurveyInstance> acceptItemInstanceAnswer(@PathVariable Integer id, @RequestBody AcceptAnswerRequest acceptAnswerRequest){
        SurveyInstance surveyInstance = __instanceService.acceptInstanceAnswer(id, acceptAnswerRequest.getItemId(), acceptAnswerRequest.getAnswerChosen());
        if(surveyInstance != null){
            return new ResponseEntity<>(surveyInstance, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Eighth endpoint, returns all survey instances that have a specified state
    //The path state is the state that this api needs to return
    @GetMapping("/state/{state}")
    public ResponseEntity<List<SurveyInstance>> getSurveyInstanceFromState(@PathVariable SurveyInstanceState state){
        List<SurveyInstance> surveyInstances =  __instanceService.getSurveyInstanceFromState(state);
        if(surveyInstances != null){
            return new ResponseEntity<>(surveyInstances, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Ninth endpoint, returns a survey instance that has a specified id
    //The path id is to the survey instance that will be return
    @GetMapping("/{id}")
    public ResponseEntity<SurveyInstance> getSurveyInstance(@PathVariable Integer id){
        SurveyInstance surveyInstance = __instanceService.getSurveyInstance(id);
        if(surveyInstance != null){
            return new ResponseEntity<>(surveyInstance, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}