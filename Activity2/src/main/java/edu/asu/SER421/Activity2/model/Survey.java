package edu.asu.SER421.Activity2.model;

import edu.asu.SER421.Activity2.model.enums.SurveyState;
import java.util.List;

public class Survey {
    private int maxSurveySize = 5;
    private int id;
    private SurveyState state;
    private List<SurveyItem> surveyItemsList;

    public Survey(){

    }
    public Survey(int id, List<SurveyItem> surveyItemsList, SurveyState state){
        this.id = id;
        this.surveyItemsList = surveyItemsList;
        this.state = state;
    }

    public int getMaxSurveySize() {
        return maxSurveySize;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public SurveyState getState() {
        return state;
    }
    public void setState(SurveyState state) {
        this.state = state;
    }
    public List<SurveyItem> getSurveyItemsList() {
        return surveyItemsList;
    }
    public void setSurveyItemsList(List<SurveyItem> surveyItemsList) {
        this.surveyItemsList = surveyItemsList;
    }
    public void addSurveyItem(SurveyItem surveyItem){
        this.surveyItemsList.add(surveyItem);
    }
}
