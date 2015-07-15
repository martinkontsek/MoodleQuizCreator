package martinkontsek.core;

import java.util.ArrayList;
import javax.swing.JTable;
import martinkontsek.gui.Main;
import martinkontsek.gui.NewQuestionDialog;
import martinkontsek.gui.QuestionsTableModel;

/**
 *
 * @author Martin Kontsek
 */
public class MoodleQuizCreator 
{
    private Main aMain;    
    private Quiz aQuiz;
    private JTable aQuestionsTable;
    private QuestionsTableModel aTableModel;

    public MoodleQuizCreator(Main paMain) 
    {
        aMain = paMain;
        aQuiz = new Quiz("Quiz");
        
        aQuestionsTable = aMain.getQuestionsTable();
        aTableModel = new QuestionsTableModel(aQuiz.getQuestions());
        aQuestionsTable.setModel(aTableModel);
    }  
    
    public void addQuestion()
    {
        NewQuestionDialog newQuestion = new NewQuestionDialog(aMain, true, this, null);
        newQuestion.setVisible(true);
    }
    
    public void addQuestionCallBack(Question paQuestion)
    {
        aQuiz.addQuestion(paQuestion);
        aTableModel.fireTableDataChanged();
    }
    
    public void editQuestion()
    {
        int selected = aQuestionsTable.getSelectedRow();
        if(selected == -1)
            return;
        
        Question selQue = aQuiz.getQuestions().get(selected);
        NewQuestionDialog newQuestion = new NewQuestionDialog(aMain, true, this, selQue);
        newQuestion.setVisible(true);
    }
    
    public void editQuestionCallBack(Question paQuestion)
    {
        
        aTableModel.fireTableDataChanged();
    }
    
    public void exportToXML()
    {
        aQuiz.saveToXML();
    }
}
