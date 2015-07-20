/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package martinkontsek.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import martinkontsek.core.Answer;
import martinkontsek.core.Question;
import martinkontsek.core.QuestionTypeEnum;
import martinkontsek.core.Quiz;

/**
 *
 * @author Martin Kontsek
 */
public class DatabaseManager 
{

    private IDatabase aDatabase;
    
    public DatabaseManager() 
    {
        aDatabase = new DatabaseSQLite("MoodleQuizCreator.db");
        this.createTables();
    }
    
    private void createTables()
    {
        String expression = "CREATE TABLE IF NOT EXISTS Quiz" +
                        "(" +
                        "  id_quiz INTEGER NOT NULL" +
                        "        CONSTRAINT Key1 PRIMARY KEY AUTOINCREMENT," +
                        "  name TEXT" +
                        ");";
        aDatabase.executeQuery(expression);
        aDatabase.disconnect();
        
        expression = "CREATE TABLE IF NOT EXISTS Question" +
                "(" +
                "  id_question INTEGER NOT NULL" +
                "        CONSTRAINT Key3 PRIMARY KEY AUTOINCREMENT," +
                "  id_quiz INTEGER NOT NULL," +
                "  type TEXT," +
                "  name TEXT," +
                "  text TEXT," +
                "  CONSTRAINT ma FOREIGN KEY (id_quiz) REFERENCES Quiz (id_quiz)" +
                ");";
        aDatabase.executeQuery(expression);
        aDatabase.disconnect();
        
        expression = "CREATE TABLE IF NOT EXISTS Answer" +
                "(" +
                "  id_answer INTEGER NOT NULL" +
                "        CONSTRAINT Key4 PRIMARY KEY AUTOINCREMENT," +
                "  id_question INTEGER NOT NULL," +
                "  is_right INTEGER," +
                "  text TEXT," +
                "  CONSTRAINT ma FOREIGN KEY (id_question) REFERENCES Question (id_question)" +
                ");";
        aDatabase.executeQuery(expression);
        aDatabase.disconnect();
    }
    
    
    public Quiz storeQuiz(Quiz paQuiz)
    {        
        String expression = "INSERT INTO Quiz (name) "
                + "VALUES('"+paQuiz.getName()+"');";
        
        aDatabase.executeQuery(expression);
        int id = aDatabase.getAutoincrementID();
        aDatabase.disconnect();
        
        paQuiz.setDBID(id);
        return paQuiz;
    }
    
    public Question storeQuestion(int paQuizID, Question paQuestion)
    {
        String expression = "INSERT INTO Question (id_quiz,type,name,text) "
                + "VALUES('"+paQuizID+"','"+paQuestion.getQuestionType().toString()+"',"
                +"'"+paQuestion.getQuestionName()+"','"+paQuestion.getQuestionText()+"');";
        
        aDatabase.executeQuery(expression);
        int id = aDatabase.getAutoincrementID();
        aDatabase.disconnect();
        
        paQuestion.setDBID(id);
        return paQuestion;
    }
    
    public Answer storeAnswer(int paQuestionID, Answer paAnswer)
    {
        int is_right = (paAnswer.isRight()) ? 1 : 0;
                   
        String expression = "INSERT INTO Answer (id_question,is_right,text) "
                + "VALUES('"+paQuestionID+"','"+is_right+"',"
                +"'"+paAnswer.getText()+"');";
        
        aDatabase.executeQuery(expression);
        int id = aDatabase.getAutoincrementID();
        aDatabase.disconnect();
        
        paAnswer.setDBID(id);
        return paAnswer;
    }
    
    public ArrayList<Quiz> getQuizzes()
    {
        try {
            ArrayList<Quiz> result = new ArrayList<>();
            String expression = "SELECT * FROM Quiz;";
            ResultSet rs = aDatabase.executeQuery(expression);
            
            while(rs.next())
            {                
                Quiz quiz = new Quiz(); 
                quiz.setDBID(rs.getInt("id_quiz"));
                quiz.setName(rs.getString("name"));                
                                
                result.add(quiz);
            }
            aDatabase.disconnect();
            
            for(Quiz res: result)
                this.getQuestionsToQuiz(res);
            
            return result;
        } catch (SQLException ex) {
            aDatabase.disconnect();
            return null;
        }
    }
    
    private Quiz getQuestionsToQuiz(Quiz paQuiz)
    {
        if(paQuiz == null)
            return null;
        
        ArrayList<Question> questions = this.getQuestions(paQuiz.getDBID());
        
        for(Question que: questions)
            paQuiz.addQuestion(que);
        
        return paQuiz;
    }
    
    public ArrayList<Question> getQuestions(int paQuizID)
    {
        try {
            ArrayList<Question> result = new ArrayList<>();
            String expression = "SELECT * FROM Question WHERE id_quiz="+paQuizID+";";
            ResultSet rs = aDatabase.executeQuery(expression);
            
            while(rs.next())
            {
                QuestionTypeEnum queType = QuestionTypeEnum.valueOf(rs.getString("type"));
                Question que = new Question(queType);
                que.setQuestionName(rs.getString("name"));
                que.setQuestionText(rs.getString("text"));
                que.setDBID(rs.getInt("id_question"));
                                
                result.add(que);
            }
            aDatabase.disconnect();
            
            for(Question resQue: result)
                this.getAnswersToQuestion(resQue);
            
            return result;
        } catch (SQLException ex) {
            aDatabase.disconnect();
            return null;
        }
    }
    
    private Question getAnswersToQuestion(Question paQuestion)
    {
        try {            
            String expression = "SELECT * FROM Answer WHERE id_question="+paQuestion.getDBID()+";";
            ResultSet rs = aDatabase.executeQuery(expression);
            
            while(rs.next())
            {  
                boolean is_right = (rs.getInt("is_right") == 1) ? true : false;
                String text = rs.getString("text");
                paQuestion.addAnswer(is_right, text);
            }
            aDatabase.disconnect();
            return paQuestion;
        } catch (SQLException ex) {
            aDatabase.disconnect();
            return null;
        }
    }
}
