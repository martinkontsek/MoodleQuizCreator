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
    private int aNumberOfAnswers;
    private int aNumberOfRight;

    public Question(QuestionTypeEnum paQuestionType) 
    {
        this.aQuestionType = paQuestionType;
        aAnswers = new ArrayList<>();
        aNumberOfAnswers = 0;
        aNumberOfRight = 0;
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
    
    public boolean isSingleRight()
    {
        if(aNumberOfRight == 1)
            return true;
        else
            return false;
    }
        
    public void addAnswer(boolean paIsRight, String paText)
    {
        aNumberOfAnswers++;
        if(paIsRight)
            aNumberOfRight++;
        
        for(Answer existingAnswer: aAnswers)
            existingAnswer.setFraction(aNumberOfAnswers, aNumberOfRight);
        
        Answer answer = new Answer(aNumberOfAnswers, aNumberOfRight, paIsRight, paText);
        aAnswers.add(answer);
    }
    
}
