package edu.asu.SER421.Activity2.model;

import java.util.ArrayList;
import java.util.List;
import edu.asu.SER421.Activity2.model.enums.SurveyItemInstanceState;

public class SurveyItemInstance {

    private int id;
    private String question;
    private String correctAnswer;
    private List<String> answerOptions = new ArrayList<>();

    private String answerChosen;
    private int ifAnsweredCorrectly = -1;
    private SurveyItemInstanceState itemState;

    public SurveyItemInstance() {
    }

    public SurveyItemInstance(int id, String question, String correctAnswer, List<String> answerOptions, SurveyItemInstanceState state) {
        this.id = id;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.answerOptions = answerOptions;
        this.itemState = state;
    }


    public int getIfAnsweredCorrectly() {
        return ifAnsweredCorrectly;
    }
    public void setIfAnsweredCorrectly(int ifAnsweredCorrectly) {
        this.ifAnsweredCorrectly = ifAnsweredCorrectly;
    }
    public String getAnswerChosen() {
        return answerChosen;
    }
    public void setAnswerChosen(String answerChosen) {
        this.answerChosen = answerChosen;
    }
    public List<String> getAnswerOptions() {
        return answerOptions;
    }
    public void setAnswerOptions(List<String> answerOptions) {
        this.answerOptions = answerOptions;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public SurveyItemInstanceState getItemState() {
        return itemState;
    }
    public void setItemState(SurveyItemInstanceState itemState) {
        this.itemState = itemState;
    }
}
