package edu.asu.SER421.Activity2.model;

import edu.asu.SER421.Activity2.model.enums.SurveyInstanceState;
import java.util.List;

public class SurveyInstance {
    private int id;
    private String userName;
    private SurveyInstanceState state;
    private List<SurveyItem> surveyItemsList;

    public SurveyInstance(){

    }
    public SurveyInstance(int id,String userName, SurveyInstanceState state, List<SurveyItem> surveyItemsList){
        this.id = id;
        this.userName = userName;
        this.state = state;
        this.surveyItemsList = surveyItemsList;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public SurveyInstanceState getState() {
        return state;
    }
    public void setState(SurveyInstanceState state) {
        this.state = state;
    }
    public List<SurveyItem> getSurveyItemsList() {
        return surveyItemsList;
    }
    public void setSurveyItemsList(List<SurveyItem> surveyItemsList) {
        this.surveyItemsList = surveyItemsList;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
