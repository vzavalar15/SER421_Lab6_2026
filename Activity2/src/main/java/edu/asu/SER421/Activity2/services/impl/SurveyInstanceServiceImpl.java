package edu.asu.SER421.Activity2.services.impl;

import edu.asu.SER421.Activity2.model.Survey;
import edu.asu.SER421.Activity2.model.SurveyInstance;
import edu.asu.SER421.Activity2.model.SurveyItem;
import edu.asu.SER421.Activity2.model.enums.SurveyInstanceState;
import edu.asu.SER421.Activity2.services.SurveyInstanceService;

import java.util.List;

public class SurveyInstanceServiceImpl implements SurveyInstanceService {

    public SurveyInstanceServiceImpl(){
        
    }

    @Override
    public List<SurveyInstance> getSurveyInstances() {
        return List.of();
    }

    @Override
    public SurveyInstance createSurveyInstance(String userName, SurveyInstanceState state, List<SurveyItem> surveyItemsList) {
        return null;
    }
}