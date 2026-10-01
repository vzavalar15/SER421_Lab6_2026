package edu.asu.SER421.Activity2.services.impl;

import edu.asu.SER421.Activity2.model.Survey;
import edu.asu.SER421.Activity2.model.SurveyInstance;
import edu.asu.SER421.Activity2.model.SurveyItem;
import edu.asu.SER421.Activity2.model.SurveyItemInstance;
import edu.asu.SER421.Activity2.model.enums.SurveyInstanceState;
import edu.asu.SER421.Activity2.model.enums.SurveyItemInstanceState;
import edu.asu.SER421.Activity2.services.SurveyInstanceService;
import edu.asu.SER421.Activity2.services.SurveyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SurveyInstanceServiceImpl implements SurveyInstanceService {
    private ArrayList<SurveyInstance> surveyInstanceList = new ArrayList<>();
    private SurveyService __surveyService = SurveyService.getInstance();


    public SurveyInstanceServiceImpl(){
        Survey survey = __surveyService.getSurvey(0);

        surveyInstanceList.addAll(Arrays.asList(
                new SurveyInstance(0, "James", SurveyInstanceState.CREATED, createSurveyItemsInstance(survey.getSurveyItemsList()), 0)
        ));

    }

    @Override
    public List<SurveyInstance> getSurveyInstances() {
        return surveyInstanceList;
    }

    @Override
    public SurveyInstance createSurveyInstance(String userName, int surveyId) {
        Survey survey = __surveyService.getSurvey(surveyId);

        SurveyInstance surveyInstance = new SurveyInstance(surveyInstanceList.size(), userName, SurveyInstanceState.CREATED, createSurveyItemsInstance(survey.getSurveyItemsList()), surveyId);
        surveyInstanceList.add(surveyInstance);
        return surveyInstance;
    }

    @Override
    public SurveyInstance acceptInstanceAnswer(int surveyId, int itemId, String answerChosen) {
        SurveyInstance instanceToReturn = null;
        for (SurveyInstance survey: surveyInstanceList){
            if (surveyId == survey.getInstanceId()){
                for(SurveyItemInstance item : survey.getSurveyItemsList()){
                    if (itemId == item.getId()){
                        item.setAnswerChosen(answerChosen);
                        item.setItemState(SurveyItemInstanceState.COMPLETED);
                        survey.setState(SurveyInstanceState.INPROGRESS);
                        if(answerChosen.equals(item.getCorrectAnswer())){
                            item.setIfAnsweredCorrectly(1);
                        }
                        else{
                            item.setIfAnsweredCorrectly(0);
                        }
                        instanceToReturn = survey;
                    }
                }
            }
        }
        return instanceToReturn;
    }

    @Override
    public List<SurveyInstance> getSurveyInstanceFromState(SurveyInstanceState state) {
        ArrayList<SurveyInstance> listTorReturn = new ArrayList<>();
        for (SurveyInstance survey: surveyInstanceList){
            if(survey.getState().equals(state)){
                listTorReturn.add(survey);
            }
        }
        return listTorReturn;
    }

    @Override
    public SurveyInstance getSurveyInstance(int id) {
        for (SurveyInstance survey: surveyInstanceList){
            if(survey.getInstanceId() == id){
                return survey;
            }
        }
        return null;
    }

    public List<SurveyItemInstance> createSurveyItemsInstance(List<SurveyItem> itemList){
        ArrayList<SurveyItemInstance> instances = new ArrayList<>();
        for (SurveyItem item: itemList){
            instances.add(new SurveyItemInstance(
                    instances.size(),
                    item.getQuestion(),
                    item.getCorrectAnswer(),
                    item.getAnswerOptions(),
                    SurveyItemInstanceState.NOTCOMPLETED));
        }
        return instances;
    }
}