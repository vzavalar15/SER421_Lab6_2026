package edu.asu.SER421.Activity2.api.controllers;

import edu.asu.SER421.Activity2.api.modelhelpers.AcceptAnswerRequest;
import edu.asu.SER421.Activity2.api.modelhelpers.SurveyInstanceRequest;
import edu.asu.SER421.Activity2.api.modelhelpers.SurveyRequest;
import edu.asu.SER421.Activity2.model.Survey;
import edu.asu.SER421.Activity2.model.SurveyInstance;
import edu.asu.SER421.Activity2.model.enums.SurveyInstanceState;
import edu.asu.SER421.Activity2.services.SurveyInstanceService;
import edu.asu.SER421.Activity2.services.SurveyService;
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

    @RequestMapping(method = RequestMethod.POST)
    public SurveyInstance createSurveyInstance(@RequestBody SurveyInstanceRequest surveyInstanceRequest){
        return __instanceService.createSurveyInstance(surveyInstanceRequest.getUserName(),surveyInstanceRequest.getSurveyId());
    }

    @PatchMapping("/{id}")
    public SurveyInstance acceptItemInstanceAnswer(@PathVariable Integer id, @RequestBody AcceptAnswerRequest acceptAnswerRequest){
        return __instanceService.acceptInstanceAnswer(id, acceptAnswerRequest.getItemId(), acceptAnswerRequest.getAnswerChosen());
    }

    @GetMapping("/state/{state}")
    public List<SurveyInstance> getSurveyInstanceFromState(@PathVariable SurveyInstanceState state){
        return __instanceService.getSurveyInstanceFromState(state);
    }

    @GetMapping("/{id}")
    public SurveyInstance getSurveyInstance(@PathVariable Integer id){
        return __instanceService.getSurveyInstance(id);
    }
}