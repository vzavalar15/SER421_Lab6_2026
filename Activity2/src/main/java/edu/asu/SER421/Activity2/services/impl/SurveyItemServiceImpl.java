package edu.asu.SER421.Activity2.services.impl;

import edu.asu.SER421.Activity2.model.SurveyItem;
import edu.asu.SER421.Activity2.services.SurveyItemService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurveyItemServiceImpl implements SurveyItemService {
    private ArrayList<SurveyItem> surveyItemsList = new ArrayList<>();

    public SurveyItemServiceImpl(){
        List<String> op1 = new ArrayList<>((Arrays.asList("2", "4", "1", "5")));
        List<String> op2 = new ArrayList<>((Arrays.asList("20", "24", "22", "19")));
        List<String> op3 = new ArrayList<>((Arrays.asList("33", "6", "7", "9")));
        List<String> op4 = new ArrayList<>((Arrays.asList("45", "37", "35", "47")));
        List<String> op5 = new ArrayList<>((Arrays.asList("3", "5", "2", "1")));



        surveyItemsList.addAll(Arrays.asList(
            new SurveyItem(0, "2+2", "4", op1),
            new SurveyItem(1,"1+7*3","22",op2),
            new SurveyItem(2,"3*3","9",op3),
            new SurveyItem(3,"9*3+10","37",op4),
            new SurveyItem(4,"9/3","3",op5)
        ));
    }

    @Override
    public List<SurveyItem> getSurveyItems() {
        return this.surveyItemsList;
    }

    @Override
    public SurveyItem createSurveyItem(String question, String correctAnswer, List<String> answerOptions) {
        SurveyItem newSurveyItem = new SurveyItem(surveyItemsList.size(), question, correctAnswer, answerOptions);
        surveyItemsList.add(newSurveyItem);
        return newSurveyItem;
    }

}