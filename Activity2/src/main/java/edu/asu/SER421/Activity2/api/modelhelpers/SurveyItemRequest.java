package edu.asu.SER421.Activity2.api.modelhelpers;

import java.util.List;

public class SurveyItemRequest {
    private int id;
    private String question;
    private String correctAnswer;
    private List<String> answerOptions;

    public SurveyItemRequest(){
    }

    public SurveyItemRequest(String question, String correctAnswer, List<String> answerOptions){
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.answerOptions = answerOptions;
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
}

