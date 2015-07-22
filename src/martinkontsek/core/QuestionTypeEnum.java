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
    
    public static QuestionTypeEnum parse(String paString)
    {
        QuestionTypeEnum[] values = QuestionTypeEnum.values();
        for(int i=0; i<values.length; i++)
        {
            if(values[i].toString().equals(paString))
                return values[i];
        }
        return null;
    }
}
