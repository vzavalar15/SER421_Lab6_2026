package edu.asu.SER421.Activity2.model;

import edu.asu.SER421.Activity2.model.enums.SurveyInstanceState;
import java.util.List;

public class SurveyInstance {
    private int instanceId;
    private String userName;
    private SurveyInstanceState state;
    private int surveyId;
    private List<SurveyItem> surveyItemsList;

    public SurveyInstance(){

    }
    public SurveyInstance(int instanceId,String userName, SurveyInstanceState state, List<SurveyItem> surveyItemsList, int surveyId){
        this.instanceId = instanceId;
        this.userName = userName;
        this.state = state;
        this.surveyItemsList = surveyItemsList;
        this.surveyId = surveyId;
    }

    public int getInstanceId() {
        return instanceId;
    }
    public void setInstanceId(int instanceId) {
        this.instanceId = instanceId;
    }
    public int getSurveyId() {
        return surveyId;
    }
    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
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
