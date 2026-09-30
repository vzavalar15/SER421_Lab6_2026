package edu.asu.SER421.Activity2.services.impl;

import edu.asu.SER421.Activity2.model.Survey;
import edu.asu.SER421.Activity2.model.SurveyItem;
import edu.asu.SER421.Activity2.model.enums.SurveyState;
import edu.asu.SER421.Activity2.services.SurveyItemService;
import edu.asu.SER421.Activity2.services.SurveyService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurveyServiceImpl implements SurveyService {
    private ArrayList<Survey> surveyList = new ArrayList<>();

    public SurveyServiceImpl(){
        SurveyItemService surveyItemService = SurveyItemService.getInstance();
        List<SurveyItem> surveyItems = surveyItemService.getSurveyItems();

        List<SurveyItem> surveyItemList1 = new ArrayList<>();
        List<SurveyItem> surveyItemList2 = new ArrayList<>();
        for(int i = 0; i < surveyItems.size(); i++){
            if(i <= 2) {
                surveyItemList1.add(surveyItems.get(i));
            }
            if(i >= 2) {
                surveyItemList2.add(surveyItems.get(i));
            }
        }

        surveyList.addAll(Arrays.asList(
                new Survey(0, surveyItemList1, SurveyState.CREATED),
                new Survey(1, surveyItemList2, SurveyState.CREATED)
        ));
    }

    @Override
    public List<Survey> getSurveys() {
        return this.surveyList;
    }

    @Override
    public Survey getSurvey(int id){
        for(Survey survey : surveyList){
            if(id == survey.getId()){
                return survey;
            }
        }
        return null;
    }

    @Override
    public Survey createSurvey(List<SurveyItem> surveyItemsList) {
        Survey newSurvey = new Survey(surveyList.size(), surveyItemsList, SurveyState.CREATED);
        surveyList.add(newSurvey);
        return newSurvey;
    }

    @Override
    public SurveyItem addSurveyItem(String question, String correctAnswer, List<String> answerOptions, List<Integer> surveys) {
        SurveyItem newSurvey = new SurveyItem(surveyList.size()+20, question, correctAnswer, answerOptions);
        for(int i : surveys){
            for(Survey j : surveyList){
                if(i == j.getId()){
                    j.addSurveyItem(newSurvey);
                }
            }
        }
        return newSurvey;
    }
}