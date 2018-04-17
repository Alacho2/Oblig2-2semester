import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ActionHandler {

    QuizHandler qh = new QuizHandler();
    Question q = qh.getNextQuestion(0);
    public WindowController wc;

    public void verifyAnswer(MouseEvent e){
        action();
    }

    public void keyPressed(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER){
            action();
        }
    }

    public void action(){
        String answer = WindowController.getAnswerfieldValue();

        if(answer.equalsIgnoreCase(q.getAnswer())){
            qh.setCorrect();
        }
        if(qh.getAnsweredQuestions() < (qh.getArrayListLength()-1)){
            qh.setAnswered();
            q = qh.getNextQuestion(qh.getAnsweredQuestions());
            WindowController.setCountryText(q.getQuestion());
            WindowController.setImageURL(q.getImage());
            WindowController.answers.setText(qh.getCorrect() + "/" + qh.getAnsweredQuestions());
        } else {
            WindowController.answers.setText("Du klarte: " + qh.getCorrect() + "/" + (qh.getAnsweredQuestions()+1) + " Takk for at du deltok!");
        }
        WindowController.answerField.clear(); //Setter tekstfeltet til ingenting.i
    }
}
