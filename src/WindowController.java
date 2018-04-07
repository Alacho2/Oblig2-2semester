import javafx.application.Application;
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
    ActionHandler ah = new ActionHandler();

    Button send;
    GridPane pane;

    static TextField answerField;
    static ImageView imageView;
    static Label country;
    static Label question;
    static Label answers;


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
        imageController();
        textFieldController();
        labelController();
        buttonController();
        paneController();
    }

    public void imageController(){
        imageView = new ImageView("http://flags.fmcdn.net/data/flags/w580/no.png");
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
        country.setText("Norge?");
        answers.setText("0/0");
    }

    public void buttonController(){
        send = new Button("Svar");
        send.setOnAction(ah::verifyAnswer);
    }
}
