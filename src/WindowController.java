import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WindowController extends Application{

    //STAGE ER HELE VINDUET
    //SCENE ER INNI VINDUET

    QuizHandler qh = new QuizHandler();
    Question q;
    Button send;
    GridPane pane;

    TextField answerField;
    ImageView imageView;
    Label country;
    Label question;
    Label answers;


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Quizmaster");
        stage.setMinWidth(100);
        stage.setMinHeight(100);

        setMyStage();
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public void setMyStage(){
        componentController();
        imageController();
        textFieldController();
        labelController();
        buttonController();
        paneController();
    }

    public void componentController(){
        q = qh.getNextQuestion(0);
    }

    public void imageController(){
        imageView = new ImageView(q.getImage());
        imageView.setFitHeight(422/2);
        imageView.setFitWidth(580/2);
    }

    public void paneController(){
        pane = new GridPane();
        pane.setVgap(10);
        pane.setHgap(10);
        pane.setAlignment(Pos.CENTER);
        pane.add(question, 0, 0);
        pane.add(imageView, 0, 1);
        pane.add(country, 0, 2);
        pane.add(answerField, 0, 3);
        pane.add(send, 1, 3);
        pane.add(answers, 0, 4);
    }

    public void textFieldController(){
        answerField = new TextField();
        answerField.setPromptText("Ditt svar");
        answerField.setFocusTraversable(false);
    }

    public void labelController(){
        question = new Label();
        country = new Label();
        answers = new Label();
        question.setText("Hva er hovedstaden i");
        country.setText(q.getQuestion());
        answers.setText("0/0");
    }

    public void buttonController(){
        send = new Button("Svar");

        send.setOnAction(e -> {
                String answer = answerField.getText();

                if(answer.equalsIgnoreCase(q.getAnswer())){
                    qh.setCorrect();
                }

                if(qh.getAnsweredQuestions() < (qh.getArrayListLength()-1)){
                    qh.setAnswered();
                    q = qh.getNextQuestion(qh.getAnsweredQuestions());
                    country.setText(q.getQuestion());
                    imageView.setImage(new Image(q.getImage()));
                    answers.setText(Integer.toString(qh.getCorrect()) + "/" + (Integer.toString(qh.getAnsweredQuestions())));
                } else {
                    answers.setText("Du klarte: " + Integer.toString(qh.getCorrect()) + "/" + (Integer.toString(qh.getAnsweredQuestions())) + " Takk for at du deltok!");
                }
                answerField.setText(""); //Setter tekstfeltet til ingenting.
        });
    }
}
