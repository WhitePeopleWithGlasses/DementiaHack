/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

/**
 *
 * @author Sigrid
 */
public class Question {
    private int questionId;
    private String question;
    private String answer;
    private int timesAsked;

    public Question() {
    }

    public Question(int questionId, String question, String answer, int timesAsked) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
        this.timesAsked = timesAsked;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    /* Connects to database, retrieves question string associated
    with questionId */
    public void setQuestion(String question) {
        /* DBUtils.connect();
        this.question = DBUtils.selectQuestionByQuestionId(questionId); */
        this.question = question;
    }

    // Connects to database, retrieves answer string associated with questionId
    public void setAnswer(String answer) {
        /* DBUtils.connect();
        this.answer = DBUtils.selectAnswerByQuestionId(questionId); */
        this.answer = answer;
    }

    public void setTimesAsked(int timesAsked) {
        this.timesAsked = timesAsked;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getTimesAsked() {
        return timesAsked;
    }
    
    public boolean correctAnswer(String userAnswer) {
        return this.getAnswer().equals(userAnswer);
    }
    
    
    
}
