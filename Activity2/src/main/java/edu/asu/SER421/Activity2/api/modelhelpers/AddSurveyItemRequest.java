package edu.asu.SER421.Activity2.api.modelhelpers;

import java.util.List;

public class AddSurveyItemRequest {
    private List<Integer> surveys;

    public AddSurveyItemRequest(){
    }

    public AddSurveyItemRequest(List<Integer> surveys){
        this.surveys = surveys;
    }

    public List<Integer> getSurveys() {
        return surveys;
    }
    public void setSurveys(List<Integer> surveys) {
        this.surveys = surveys;
    }
}
