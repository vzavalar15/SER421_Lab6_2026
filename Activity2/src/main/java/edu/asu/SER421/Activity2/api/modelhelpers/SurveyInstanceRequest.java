package edu.asu.SER421.Activity2.api.modelhelpers;

import edu.asu.SER421.Activity2.model.SurveyItem;
import edu.asu.SER421.Activity2.model.enums.SurveyInstanceState;

import java.util.List;

public class SurveyInstanceRequest {
    private String userName;
    private Integer surveyId;

    public SurveyInstanceRequest(){

    }
    public SurveyInstanceRequest(String userName, int surveyId){
        this.userName = userName;
        this.surveyId = surveyId;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getSurveyId() {
        return surveyId;
    }
    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }
}

