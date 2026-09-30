package edu.asu.SER421.Activity2.api.modelhelpers;

import edu.asu.SER421.Activity2.model.SurveyItem;
import edu.asu.SER421.Activity2.model.enums.SurveyState;

import java.util.List;

public class SurveyRequest {
    private List<SurveyItem> surveyItemsList;

    public SurveyRequest(){

    }
    public SurveyRequest(List<SurveyItem> surveyItemsList){
        this.surveyItemsList = surveyItemsList;
    }

    public List<SurveyItem> getSurveyItemsList() {
        return surveyItemsList;
    }
    public void setSurveyItemsList(List<SurveyItem> surveyItemsList) {
        this.surveyItemsList = surveyItemsList;
    }
}
