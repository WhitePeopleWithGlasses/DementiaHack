/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;


/**
 *
 * @author Travis
 */
@Named
@ApplicationScoped
public class Questions {
    private List<QuestionsLog> questionsLogs = new ArrayList<>();
    private QuestionsLog currentQuestion = new QuestionsLog();
    
    public Questions(){
    currentQuestion = new QuestionsLog(0, "", "", "");
    getDB();
    }
    
    public List<QuestionsLog> getQuestionLogs() {
    return questionsLogs;
    }
    
    private static void getDB() {
           try {
            questionsLogs.clear();
            Connection conn = DBUtils.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM currentQuestion");
            while (rs.next()) {
                QuestionsLog ql = new QuestionsLog(
                        rs.getInt("questionId"),
                        rs.getString("question"),
                        rs.getString("answer"),
                        rs.getString("timesAsked")
                );
                questionsLogs.add(ql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
            questionsLogs.clear();
        }

    }
    
    public QuestionsLog getcurrentQuestion() {
    return currentQuestion;
    }

    public List<QuestionsLog> getQuestionsLogs() {
        return questionsLogs;
    }

    public void setQuestionsLogs(List<QuestionsLog> questionsLogs) {
        this.questionsLogs = questionsLogs;
    }

    public QuestionsLog getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(QuestionsLog currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
    
    public String addQuestion() {
    try {
            questionsLogs.clear();
            Connection conn = DBUtils.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeQuery("INSERT INTO currentQuestion VALUSE (" + currentQuestion.getTimesAsked + "," + currentQuestion.getQuestion() + "," + getCorrectAnswer() + "");
            while (rs.next()) {
                QuestionsLog ql = new QuestionsLog(
                        rs.getInt("questionId"),
                        rs.getString("question"),
                        rs.getString("answer"),
                        rs.getString("timesAsked")
                );
                questionsLogs.add(ql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
            questionsLogs.clear();
        }
    }
}
