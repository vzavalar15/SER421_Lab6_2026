package edu.asu.SER421.Activity2.services;

import edu.asu.SER421.Activity2.model.SurveyItem;
import edu.asu.SER421.Activity2.services.impl.SurveyItemServiceImpl;

import java.util.List;

public interface SurveyItemService {
    public static SurveyItemService getInstance(){
        return new SurveyItemServiceImpl();
    }

    public List<SurveyItem> getSurveyItems();
    public SurveyItem createSurveyItem(String question, String correctAnswer, List<String> answerOptions);
}