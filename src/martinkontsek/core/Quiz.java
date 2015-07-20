package martinkontsek.core;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Martin Kontsek
 */
public class Quiz 
{
    private String aName;
    private ArrayList<Question> aQuestions;
    
    private int aDBID;

    public Quiz() 
    {
        aQuestions = new ArrayList<>();
    }
    
    public Quiz(String paName) 
    {
        this();
        this.aName = paName;
    }

    public String getName() 
    {
        return aName;
    }

    public void setName(String paName) 
    {
        this.aName = paName;
    }

    public ArrayList<Question> getQuestions() 
    {
        return aQuestions;
    }

    public void addQuestion(Question paQuestion)
    {
        aQuestions.add(paQuestion);
    }
    
    public Question addQuestion(QuestionTypeEnum paQuestionType)
    {
        Question question = new Question(paQuestionType);
        aQuestions.add(question);
        
        return question;
    }
    
    public void removeQuestion(int paIndex)
    {
        aQuestions.remove(paIndex);
    }

    public int getDBID() 
    {
        return aDBID;
    }

    public void setDBID(int paDBID) 
    {
        this.aDBID = paDBID;
    }   

    public void saveToXML()
    {
        try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("quiz");
		doc.appendChild(rootElement);
 
                // question elements
                for(Question fQuestion: aQuestions)
                {
                    Element question = doc.createElement("question");
                    rootElement.appendChild(question);                    
                    // set question type
                    question.setAttribute("type", fQuestion.getQuestionType().toString());
                    
                    // add question name
                    Element questionName = doc.createElement("name");
                    question.appendChild(questionName);
                    Element questionNameText = doc.createElement("text");
                    questionNameText.appendChild(doc.createTextNode(fQuestion.getQuestionName()));
                    questionName.appendChild(questionNameText);
                    
                    // add question text
                    Element questionText = doc.createElement("questiontext");
                    question.appendChild(questionText);
                    questionText.setAttribute("format", "html");
                    Element questionTextText = doc.createElement("text");
                    questionTextText.appendChild(doc.createTextNode(fQuestion.getQuestionText()));
                    questionText.appendChild(questionTextText);
                    
                    // answers elements
                    ArrayList<Answer> allAnswers = fQuestion.getAllAnswers();                    
                    for(Answer fAnswer: allAnswers)
                    {
                        // add question text
                        Element answer = doc.createElement("answer");
                        question.appendChild(answer);
                        answer.setAttribute("fraction", fAnswer.getFraction()+"");
                        Element answerText = doc.createElement("text");
                        answerText.appendChild(doc.createTextNode(fAnswer.getText()));
                        answer.appendChild(answerText);
                    }
                    
                    if(fQuestion.getQuestionType() == QuestionTypeEnum.MULTICHOICE)
                    {
                        // shuffle answers
                        Element shuffle = doc.createElement("shuffleanswers");
                        question.appendChild(shuffle);
                        shuffle.appendChild(doc.createTextNode("1"));
                        
                        // single or multiple right answers
                        Element single = doc.createElement("single");
                        question.appendChild(single);
                        if(fQuestion.isSingleRight())
                            single.appendChild(doc.createTextNode("true"));
                        else
                            single.appendChild(doc.createTextNode("false"));
                    }
                    
                }               
		
 
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(aName+".xml"));
 
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
 
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
    }
    
    
    
}
