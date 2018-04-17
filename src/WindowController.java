import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WindowController extends Application{

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
        scene.addEventFilter(KeyEvent.KEY_RELEASED, ah::keyPressed);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Composes all the methods together.
     */
    private void setMyStage(){
        imageController();
        textFieldController();
        labelController();
        buttonController();
        paneController();
    }

    /**
     * Setting up the image for questions.
     */
    private void imageController(){
        imageView = new ImageView("http://flags.fmcdn.net/data/flags/w580/no.png");
        imageView.setFitHeight(422/2);
        imageView.setFitWidth(580/2);
    }

    /**
     * Setting up the GridPane
     */
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

    /**
     * Setting up the textField for the questions.
     */
    private void textFieldController(){
        answerField = new TextField();
        answerField.setPromptText("Ditt svar");
        answerField.setFocusTraversable(false);
    }

    /**
     * Setting up the labels for the questions.
     */
    private void labelController(){
        question = new Label("Hva er hovedstaden i");
        country = new Label("Norge?");
        answers = new Label("0/0");
    }

    /**
     * Add functionality to the button.
     * Method referencing to clean up the button controller.
     */
    private void buttonController(){
        send = new Button("Svar");
        send.setOnMouseClicked(ah::verifyAnswer);

    }

    /**
     * Method that returns the value of the textfield.
     * @return    The value of the textfield.
     */
    public static String getAnswerfieldValue(){
        return answerField.getText();
    }

    /**
     * Sets a new value for the country label
     * @param newCountry    Value for the country label.
     */
    public static void setCountryText(String newCountry){
        country.setText(newCountry);
    }

    /**
     * Sets a new URL for the image.
     * @param url
     */
    public static void setImageURL(String url){
        imageView.setImage(new Image(url));
    }
}
