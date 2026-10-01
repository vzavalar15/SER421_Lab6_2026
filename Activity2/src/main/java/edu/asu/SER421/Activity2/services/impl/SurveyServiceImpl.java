package edu.asu.SER421.Activity2.services.impl;

import edu.asu.SER421.Activity2.model.Survey;
import edu.asu.SER421.Activity2.model.SurveyItem;
import edu.asu.SER421.Activity2.model.enums.SurveyState;
import edu.asu.SER421.Activity2.services.SurveyItemService;
import edu.asu.SER421.Activity2.services.SurveyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class SurveyServiceImpl implements SurveyService {
    private ArrayList<Survey> surveyList = new ArrayList<>();
    private SurveyItemService surveyItemService = SurveyItemService.getInstance();

    public SurveyServiceImpl(){
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
        for(SurveyItem survey: newSurvey.getSurveyItemsList()){
            if(survey.getQuestion().isEmpty() || survey.getCorrectAnswer().isEmpty()){
                return null;
            }
            for(String opt: survey.getAnswerOptions()){
                if(opt.isEmpty()){
                    return null;
                }
            }
        }
        surveyList.add(newSurvey);
        return newSurvey;
    }

    @Override
    public SurveyItem addSurveyItem(int itemId, List<Integer> surveys) {
        if(surveys.isEmpty()){
            return null;
        }
        SurveyItem newSurvey = null;
        for(SurveyItem items :surveyItemService.getSurveyItems()){
            if(itemId == items.getId()){
                newSurvey = items;
                break;
            }
        }

        for(int id : surveys){
            for(Survey survey : surveyList){
                if(!survey.getState().equals(SurveyState.DELETED)) {
                    if (id == survey.getId()) {
                        survey.addItem(newSurvey);
                    }
                }
            }
        }
        return newSurvey;
    }

    @Override
    public Survey deleteSurvey(int id) {
        for(Survey survey: surveyList){
            if(survey.getId() == id){
                survey.setState(SurveyState.DELETED);
                return survey;
            }
        }
        return null;
    }


    }