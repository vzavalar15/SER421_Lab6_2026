package edu.asu.SER421.Activity2.model;

import java.util.List;

public class SurveyItem {
    private int id;
    private String question;
    private String correctAnswer;
    private List<String> answerOptions;

    public SurveyItem(){
    }

    public SurveyItem(int id, String question, String correctAnswer, List<String> answerOptions){
        this.id = id;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.answerOptions = answerOptions;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
