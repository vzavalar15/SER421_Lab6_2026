package edu.asu.SER421.Activity2.api.modelhelpers;

import java.util.List;

public class AddSurveyItemRequest {
    private String question;
    private String correctAnswer;
    private List<String> answerOptions;
    private List<Integer> surveys;

    public AddSurveyItemRequest(){
    }

    public AddSurveyItemRequest(String question, String correctAnswer, List<String> answerOptions, List<Integer> surveys){
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.answerOptions = answerOptions;
        this.surveys = surveys;
    }

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    public List<String> getAnswerOptions() {
        return answerOptions;
    }
    public void setAnswerOptions(List<String> answerOptions) {
        this.answerOptions = answerOptions;
    }
    public List<Integer> getSurveys() {
        return surveys;
    }
    public void setSurveys(List<Integer> surveys) {
        this.surveys = surveys;
    }
}
