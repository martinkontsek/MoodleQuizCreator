package martinkontsek.core;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import martinkontsek.gui.Main;
import martinkontsek.gui.NewQuestionDialog;
import martinkontsek.gui.QuestionsTableModel;
import martinkontsek.gui.SelectQuizDialog;

/**
 *
 * @author Martin Kontsek
 */
public class MoodleQuizCreator 
{
    private Main aMain;    
    private ArrayList<Quiz> aQuizzes;
    private Quiz aSelectedQuiz;
    private JTable aQuestionsTable;
    private QuestionsTableModel aTableModel;

    public MoodleQuizCreator(Main paMain) 
    {
        aMain = paMain;
        aQuizzes = new ArrayList<>();
        aSelectedQuiz = null;
        
        aQuestionsTable = aMain.getQuestionsTable();
        aTableModel = new QuestionsTableModel(new ArrayList<>());
        aQuestionsTable.setModel(aTableModel);
    }  
    
    public void selectQuiz()
    {
        SelectQuizDialog selQuiz = new SelectQuizDialog(aMain, true, this, aQuizzes);
        selQuiz.setVisible(true);
    }
    
    public void selectQuizCallBack(Quiz paSelectedQuiz)
    {
        aSelectedQuiz = paSelectedQuiz; 
        aMain.setTitle("Moodle Quiz Creator - "+aSelectedQuiz.getName());
        aTableModel.setQuestions(aSelectedQuiz.getQuestions());
        aTableModel.fireTableDataChanged();
    }
    
    public void addQuiz()
    {
        String s = (String)JOptionPane.showInputDialog(
                    aMain,
                    "Write new Quiz name and select OK:",
                    "Add new Quiz",
                    JOptionPane.PLAIN_MESSAGE);
        
        if ((s != null) && (s.length() > 0)) 
        {
            Quiz quiz = new Quiz(s);
            aQuizzes.add(quiz);
            selectQuizCallBack(quiz);
        }
    }
    
    public void addQuestion()
    {
        if(aSelectedQuiz == null)
            return;
        NewQuestionDialog newQuestion = new NewQuestionDialog(aMain, true, this, null);
        newQuestion.setVisible(true);
    }
    
    public void addQuestionCallBack(Question paQuestion)
    {
        if(aSelectedQuiz == null)
            return;
        aSelectedQuiz.addQuestion(paQuestion);
        aTableModel.fireTableDataChanged();
    }
    
    public void editQuestion()
    {
        if(aSelectedQuiz == null)
            return;
        
        int selected = aQuestionsTable.getSelectedRow();
        if(selected == -1)
            return;
        
        Question selQue = aSelectedQuiz.getQuestions().get(selected);
        NewQuestionDialog newQuestion = new NewQuestionDialog(aMain, true, this, selQue);
        newQuestion.setVisible(true);
    }
    
    public void editQuestionCallBack(Question paQuestion)
    {
        
        aTableModel.fireTableDataChanged();
    }
    
    public void removeSelected()
    {
        if(aSelectedQuiz == null)
            return;
        
        int[] selected = aQuestionsTable.getSelectedRows();
        int len = selected.length;
        if(len == 0)
            return;
        
        for(int i=(len-1); i >= 0; i--)
        {
            aSelectedQuiz.removeQuestion(selected[i]);
        }
        
        aTableModel.fireTableDataChanged();
    }
    
    public void exportToXML()
    {
        if(aSelectedQuiz == null)
            return;
        aSelectedQuiz.saveToXML();
    }
}
