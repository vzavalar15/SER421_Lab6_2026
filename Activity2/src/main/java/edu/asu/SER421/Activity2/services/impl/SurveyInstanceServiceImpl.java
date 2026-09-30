package edu.asu.SER421.Activity2.services.impl;

import edu.asu.SER421.Activity2.model.Survey;
import edu.asu.SER421.Activity2.model.SurveyInstance;
import edu.asu.SER421.Activity2.model.SurveyItem;
import edu.asu.SER421.Activity2.model.enums.SurveyInstanceState;
import edu.asu.SER421.Activity2.services.SurveyInstanceService;
import edu.asu.SER421.Activity2.services.SurveyService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurveyInstanceServiceImpl implements SurveyInstanceService {
    private ArrayList<SurveyInstance> surveyInstanceList = new ArrayList<>();
    private SurveyService __surveyService = SurveyService.getInstance();


    public SurveyInstanceServiceImpl(){

        Survey survey = __surveyService.getSurvey(0);

        surveyInstanceList.addAll(Arrays.asList(
                new SurveyInstance(0, "James", SurveyInstanceState.CREATED, survey.getSurveyItemsList(), 0)
        ));

    }

    @Override
    public List<SurveyInstance> getSurveyInstances() {
        return surveyInstanceList;
    }

    @Override
    public SurveyInstance createSurveyInstance(String userName, int surveyId) {
        Survey survey = __surveyService.getSurvey(surveyId);
        SurveyInstance surveyInstance = new SurveyInstance(surveyInstanceList.size(), userName, SurveyInstanceState.CREATED, survey.getSurveyItemsList(), surveyId);
        surveyInstanceList.add(surveyInstance);
        return surveyInstance;
    }
}