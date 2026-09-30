package edu.asu.SER421.Activity2.services;

import edu.asu.SER421.Activity2.model.SurveyInstance;
import edu.asu.SER421.Activity2.model.SurveyItem;
import edu.asu.SER421.Activity2.model.enums.SurveyInstanceState;
import edu.asu.SER421.Activity2.services.impl.SurveyInstanceServiceImpl;

import java.util.List;

public interface SurveyInstanceService {
    public static SurveyInstanceService getInstance(){
        return new SurveyInstanceServiceImpl();
    }

    public List<SurveyInstance> getSurveyInstances();
    public SurveyInstance createSurveyInstance(String userName, int surveyId);
}