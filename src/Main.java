import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {

    //STAGE ER HELE VINDUET
    //SCENE ER INNI VINDUET
    GridPane pane;
    Button send;
    TextField answerField;
    Label country = new Label();
    Label question = new Label();
    ImageView imageView = new ImageView();

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Quizmaster");
        send = new Button("Svar");
        answerField = new TextField();
        imageView = new ImageView("https://yt3.ggpht.com/-1sCkjeSU8Xg/AAAAAAAAAAI/AAAAAAAAAAA/cQMNH3sXd0s/s100-mo-c-c0xffffffff-rj-k-no/photo.jpg");
        stage.setMinWidth(100);
        stage.setMinHeight(100);
        setMyStage();

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public void setMyStage(){
        question.setText("Hva er hovedstaden i");
        country.setText("Norge" + "?");
        pane = new GridPane();
        pane.setVgap(10);
        pane.setHgap(10);
        pane.setAlignment(Pos.CENTER);
        pane.add(question, 0, 0);
        pane.add(imageView, 0, 1);
        pane.add(country, 0, 2);
        pane.add(answerField, 0, 3);
    }
}
