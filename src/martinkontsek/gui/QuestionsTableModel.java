package martinkontsek.gui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import martinkontsek.core.Question;

/**
 *
 * @author Martin Kontsek
 */
public class QuestionsTableModel extends AbstractTableModel
{
    private ArrayList<Question> aQuestions;

    public QuestionsTableModel(ArrayList<Question> paQuestions) 
    {
        aQuestions = paQuestions;
    }
    
    public void setQuestions(ArrayList<Question> paQuestions)
    {
        aQuestions = paQuestions;
    }

    @Override
    public int getRowCount() 
    {
        return aQuestions.size();
    }

    @Override
    public int getColumnCount() 
    {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        Question question = aQuestions.get(rowIndex);
        
        switch(columnIndex)
        {
            case 0:
                return rowIndex+1;
            case 1:
                return question.getQuestionName();
            case 2:
                return question.getQuestionText();
            case 3:
                return question.getQuestionType();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) 
    {
        switch(column)
        {
            case 0:
                return "No.";
            case 1:
                return "Name";
            case 2:
                return "Text";
            case 3:
                return "Type";
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) 
    {
        switch(columnIndex)
        {
            case 0:
                return Integer.class;
            case 3:
                return Object.class;
            default:
                return String.class;
        }
    }
    
    
}
