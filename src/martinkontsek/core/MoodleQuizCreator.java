package martinkontsek.core;

import java.awt.Desktop;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import martinkontsek.database.DatabaseManager;
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
    
    private DatabaseManager aDatabase;

    public MoodleQuizCreator(Main paMain) 
    {
        aMain = paMain;
        aDatabase = new DatabaseManager();
        aQuizzes = null;
        aSelectedQuiz = null;
        
        aQuestionsTable = aMain.getQuestionsTable();        
        aQuestionsTable.getTableHeader().setReorderingAllowed(false);        
        aTableModel = new QuestionsTableModel(new ArrayList<>());
        aQuestionsTable.setModel(aTableModel);
        
        aQuestionsTable.getColumnModel().getColumn(0).setMaxWidth(30);
        aQuestionsTable.getColumnModel().getColumn(0).setResizable(false);
        aQuestionsTable.getColumnModel().getColumn(3).setMaxWidth(60);
        aQuestionsTable.getColumnModel().getColumn(3).setResizable(false);
    } 
    
    private void nullGUI()
    {
        aSelectedQuiz = null;
        aMain.setTitle("Moodle Quiz Creator");
        aTableModel.setQuestions(new ArrayList<>());
        aTableModel.fireTableDataChanged();
    }
    
    public void selectQuiz()
    {
        aQuizzes = aDatabase.getQuizzes();
        SelectQuizDialog selQuiz = new SelectQuizDialog(aMain, true, this, aQuizzes);
        selQuiz.setLocationRelativeTo(aMain);
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
            aDatabase.storeQuiz(quiz);
            selectQuizCallBack(quiz);
        }
    }
    
    public void editQuizName()
    {
        if(aSelectedQuiz == null)
            return;
        
        String s = (String)JOptionPane.showInputDialog(
                    aMain,
                    "Edit Quiz name and select OK:",
                    "Edit Quiz Name",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    aSelectedQuiz.getName());
        
        if ((s != null) && (s.length() > 0)) 
        {
            aSelectedQuiz.setName(s);
            aDatabase.editQuizName(aSelectedQuiz);
            aMain.setTitle("Moodle Quiz Creator - "+aSelectedQuiz.getName());
        }
    }
    
    public void removeQuiz()
    {
        if(aSelectedQuiz == null)
            return;
        
        aDatabase.removeQuiz(aSelectedQuiz.getDBID());
        aQuizzes.remove(aSelectedQuiz);
        
        this.nullGUI();
    }    
    
    public void addQuestion()
    {
        if(aSelectedQuiz == null)
            return;
        NewQuestionDialog newQuestion = new NewQuestionDialog(aMain, true, this, null);
        newQuestion.setLocationRelativeTo(aMain);
        newQuestion.setVisible(true);
    }
    
    public void addQuestionCallBack(Question paQuestion)
    {
        if(aSelectedQuiz == null)
            return;
        aSelectedQuiz.addQuestion(paQuestion);
        aDatabase.storeQuestionWithAnswers(aSelectedQuiz.getDBID(), paQuestion);
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
        newQuestion.setLocationRelativeTo(aMain);
        newQuestion.setVisible(true);
    }
    
    public void editQuestionCallBack(Question paQuestion)
    {
        aDatabase.editQuestion(paQuestion);
                
        aTableModel.fireTableDataChanged();
    }
    
    public void removeSelectedQuestions()
    {
        if(aSelectedQuiz == null)
            return;
        
        int[] selected = aQuestionsTable.getSelectedRows();
        int len = selected.length;
        if(len == 0)
            return;
        
        for(int i=(len-1); i >= 0; i--)
        {
            Question que = aSelectedQuiz.getQuestions().get(selected[i]);
            aDatabase.removeQuestion(que.getDBID());
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
    
    public void showAbout()
    {
        JOptionPane.showMessageDialog(aMain,
            "Application is used for creating Moodle Quiz Questions.\n"
            + "After exporting finished questions, Moodle XML is created in the\n"
            + "current directory. Than you have to import questions from XML\n"
            + "into Moodle Question Bank.\n"
            + "\n"        
            + "            created by Martin Kontsek in 2015",
            "About",
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void showSources()
    {
        this.openWebpage("https://github.com/martinkontsek/MoodleQuizCreator");
    }
    
    private void openWebpage(String urlString) 
    {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
        }
    }
}
