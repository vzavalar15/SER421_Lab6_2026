package edu.asu.SER421.Activity2.services;

import edu.asu.SER421.Activity2.model.Survey;
import edu.asu.SER421.Activity2.model.SurveyItem;
import edu.asu.SER421.Activity2.model.enums.SurveyState;
import edu.asu.SER421.Activity2.services.impl.SurveyServiceImpl;

import java.util.List;

public interface SurveyService {
    public static SurveyService getInstance(){
        return new SurveyServiceImpl();
    }

    public List<Survey> getSurveys();
    public Survey getSurvey(int id);
    public Survey createSurvey(List<SurveyItem> surveyItemsList);
    public SurveyItem addSurveyItem(int itemId, List<Integer> surveys);
    public Survey deleteSurvey(int id);
    }