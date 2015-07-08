package martinkontsek.core;

/**
 *
 * @author Martin Kontsek
 */
public class Answer 
{
    private float aFraction;
    private String aText;

    public Answer() 
    {
        
    }
    
    public Answer(float paFraction, String paText) 
    {
        this.aFraction = paFraction;
        this.aText = paText;
    }

    public Answer(int paNumberOfRight, boolean paIsRight, String paText) 
    {
        this.aText = paText;
        this.setFraction(paNumberOfRight, paIsRight);
    }     

    public float getFraction() 
    {
        return aFraction;
    }

    public void setFraction(float paFraction) 
    {
        this.aFraction = paFraction;
    }
    
    public void setFraction(int paNumberOfRight, boolean paIsRight)
    {
        if(paNumberOfRight == 1)
        {
            if(paIsRight)
                aFraction = 100;
            else
                aFraction = 0;
        } else {
            float fraction = 100/paNumberOfRight;
            if(paIsRight)
                aFraction = fraction;
            else
                aFraction = fraction*(-1);
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
