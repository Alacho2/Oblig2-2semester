import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WindowController extends Application{

    //STAGE ER HELE VINDUET
    //SCENE ER INNI VINDUET

    private ActionHandler ah = new ActionHandler();

    private Button send;
    private GridPane pane;

    static TextField answerField;
    static ImageView imageView;
    static Label country;
    static Label answers;
    private static Label question;


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Quizmaster");
        stage.setMinWidth(370);
        stage.setMinHeight(370);
        stage.setMaxHeight(500);
        stage.setMaxWidth(500);

        setMyStage();

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    private void setMyStage(){
        imageController();
        textFieldController();
        labelController();
        buttonController();
        paneController();
    }

    private void imageController(){
        imageView = new ImageView("http://flags.fmcdn.net/data/flags/w580/no.png");
        imageView.setFitHeight(422/2);
        imageView.setFitWidth(580/2);
    }

    private void paneController(){
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

    private void textFieldController(){
        answerField = new TextField();
        answerField.setPromptText("Ditt svar");
        answerField.setFocusTraversable(false);
    }

    private void labelController(){
        question = new Label("Hva er hovedstaden i");
        country = new Label("Norge?");
        answers = new Label("0/0");
    }

    private void buttonController(){
        send = new Button("Svar");
        send.setOnAction(ah::verifyAnswer);
        send.setOnKeyPressed(ah::keyPressed);
    }
}
