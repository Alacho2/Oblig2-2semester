import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ActionHandler {

    QuizHandler qh = new QuizHandler();
    Question q = qh.getNextQuestion(0);
    public WindowController wc;

    public void verifyAnswer(ActionEvent event){
        String answer = wc.answerField.getText();

        if(answer.equalsIgnoreCase(q.getAnswer())){
            qh.setCorrect();
        }
        if(qh.getAnsweredQuestions() < (qh.getArrayListLength()-1)){
            qh.setAnswered();
            q = qh.getNextQuestion(qh.getAnsweredQuestions());
            wc.country.setText(q.getQuestion());
            wc.imageView.setImage(new Image(q.getImage()));
            wc.answers.setText(Integer.toString(qh.getCorrect()) + "/" + (Integer.toString(qh.getAnsweredQuestions())));
        } else {
            wc.answers.setText("Du klarte: " + Integer.toString(qh.getCorrect()) + "/" + (Integer.toString(qh.getAnsweredQuestions()+1)) + " Takk for at du deltok!");
        }
        wc.answerField.setText(""); //Setter tekstfeltet til ingenting.
    }

    /*public void keyPressed(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER){
            System.out.println("Klikka");
            String answer = wc.answerField.getText();

            if(answer.equalsIgnoreCase(q.getAnswer())){
                qh.setCorrect();
            }
            if(qh.getAnsweredQuestions() < (qh.getArrayListLength()-1)){
                qh.setAnswered();
                q = qh.getNextQuestion(qh.getAnsweredQuestions());
                wc.country.setText(q.getQuestion());
                wc.imageView.setImage(new Image(q.getImage()));
                wc.answers.setText(Integer.toString(qh.getCorrect()) + "/" + (Integer.toString(qh.getAnsweredQuestions())));
            } else {
                wc.answers.setText("Du klarte: " + Integer.toString(qh.getCorrect()) + "/" + (Integer.toString(qh.getAnsweredQuestions()+1)) + " Takk for at du deltok!");
            }
            wc.answerField.setText(""); //Setter tekstfeltet til ingenting.
        }
    }*/
}
