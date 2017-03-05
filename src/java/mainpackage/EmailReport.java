/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.util.Date;

/**
 *
 * @author Sigrid
 */
public class EmailReport {
    private int questionId;
    private Date answerDate;

    public EmailReport() {
    }

    public EmailReport(int questionId, Date answerDate) {
        this.questionId = questionId;
        this.answerDate = answerDate;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    public int getQuestionId() {
        return questionId;
    }

    public Date getAnswerDate() {
        return answerDate;
    }
    
    
    
}
