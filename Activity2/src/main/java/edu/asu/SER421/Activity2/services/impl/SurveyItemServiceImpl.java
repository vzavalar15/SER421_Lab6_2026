package edu.asu.SER421.Activity2.services.impl;

import edu.asu.SER421.Activity2.model.SurveyItem;
import edu.asu.SER421.Activity2.services.SurveyItemService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurveyItemServiceImpl implements SurveyItemService {
    private ArrayList<SurveyItem> surveyItemsList = new ArrayList<>();

    public SurveyItemServiceImpl(){
        List<String> op1 = new ArrayList<>();
        List<String> op2 = new ArrayList<>();
        List<String> op3 = new ArrayList<>();

        op1.add("2");
        op1.add("4");
        op1.add("1");
        op1.add("5");

        surveyItemsList.addAll(Arrays.asList(
                new SurveyItem(0, "2+2", "4", op1)
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
