package edu.asu.SER421.Activity2.services.impl;

import edu.asu.SER421.Activity2.model.Survey;
import edu.asu.SER421.Activity2.model.SurveyItem;
import edu.asu.SER421.Activity2.model.enums.SurveyState;
import edu.asu.SER421.Activity2.services.SurveyService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SurveyServiceImpl implements SurveyService {
    private ArrayList<Survey> surveyList = new ArrayList<>();

    public SurveyServiceImpl(){
        List<String> op1 = new ArrayList<>();
        op1.add("Red");
        op1.add("Purple");
        op1.add("Blue");
        op1.add("Orange");
        SurveyItem SI1 = new SurveyItem(3, "What color is an orange?", "Orange", op1);
        List<SurveyItem> surveyItemList = new ArrayList<>();
        surveyItemList.add(SI1);

        surveyList.addAll(Arrays.asList(
                new Survey(0, surveyItemList, SurveyState.CREATED)
        ));
    }

    @Override
    public List<Survey> getSurveys() {
        return this.surveyList;
    }

    @Override
    public Survey createSurvey(List<SurveyItem> surveyItemsList) {
        Survey newSurvey = new Survey(surveyList.size(), surveyItemsList, SurveyState.CREATED);
        surveyList.add(newSurvey);
        return newSurvey;
    }
}
