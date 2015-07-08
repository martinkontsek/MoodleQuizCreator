package martinkontsek.core;

/**
 *
 * @author Martin Kontsek
 */
public enum QuestionTypeEnum 
{   
    TRUEFALSE("truefalse"),
    MULTICHOICE("multichoice");
    
    private String aText;

    private QuestionTypeEnum(String paText) 
    {
        this.aText = paText;
    }

    @Override
    public String toString() 
    {
        return aText;
    }
    
    
}
