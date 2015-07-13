package martinkontsek.core;

/**
 *
 * @author Martin Kontsek
 */
public class Answer 
{
    private float aFraction;
    private String aText;
    private boolean aIsRight;

    public Answer() 
    {
        aIsRight = false;
    }
    
    public Answer(float paFraction, String paText) 
    {
        this();
        this.aFraction = paFraction;
        this.aText = paText;
    }

    public Answer(int paNumberOfAnswers, int paNumberOfRight, boolean paIsRight, String paText) 
    {
        aIsRight = paIsRight;
        this.aText = paText;
        this.setFraction(paNumberOfAnswers, paNumberOfRight);
    }     

    public float getFraction() 
    {
        return aFraction;
    }

    public void setFraction(float paFraction) 
    {
        this.aFraction = paFraction;
    }
    
    public void setFraction(int paNumberOfAnswers, int paNumberOfRight)
    {
        if(paNumberOfRight == 1)
        {
            if(aIsRight)
                aFraction = 100;
            else
                aFraction = 0;
        } else {
            float fractionRight;
            if(paNumberOfRight < 1)
                fractionRight = 0;
            else
                fractionRight = 100/paNumberOfRight;
            
            float fractionWrong = 100/(paNumberOfAnswers - paNumberOfRight);
            if(aIsRight)
                aFraction = fractionRight;
            else
                aFraction = fractionWrong*(-1);
        }      
    }

    public String getText() 
    {
        return aText;
    }

    public void setText(String paText) 
    {
        this.aText = paText;
    }
    
    
}
