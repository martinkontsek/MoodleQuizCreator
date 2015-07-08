package martinkontsek.core;

import java.util.ArrayList;

/**
 *
 * @author Martin Kontsek
 */
public class Question 
{
    private QuestionTypeEnum aQuestionType;
    private String aQuestionName;
    private String aQuestionText;
    private ArrayList<Answer> aAnswers;    

    public Question(QuestionTypeEnum paQuestionType) 
    {
        this.aQuestionType = paQuestionType;
        aAnswers = new ArrayList<>();
    }    
    
    public QuestionTypeEnum getQuestionType() 
    {
        return aQuestionType;
    }

    public String getQuestionName() 
    {
        return aQuestionName;
    }

    public void setQuestionName(String paQuestionName) 
    {
        this.aQuestionName = paQuestionName;
    }    
    
    public String getQuestionText() 
    {
        return aQuestionText;
    }

    public void setQuestionText(String paQuestionText) 
    {
        this.aQuestionText = paQuestionText;
    }
    
    public void addAnswer(Answer paAnswer)
    {
        aAnswers.add(paAnswer);
    }
    
    public ArrayList<Answer> getAllAnswers()
    {
        return aAnswers;
    }
        
    
    
}
