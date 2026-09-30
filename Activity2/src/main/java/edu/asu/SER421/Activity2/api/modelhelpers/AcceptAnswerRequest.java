package edu.asu.SER421.Activity2.api.modelhelpers;

public class AcceptAnswerRequest {
    private int itemId;
    private String answerChosen;

    public AcceptAnswerRequest(){

    }

    public AcceptAnswerRequest(int itemId, String answerChosen){
        this.itemId = itemId;
        this.answerChosen = answerChosen;
    }

    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public String getAnswerChosen() {
        return answerChosen;
    }
    public void setAnswerChosen(String answerChosen) {
        this.answerChosen = answerChosen;
    }
}
