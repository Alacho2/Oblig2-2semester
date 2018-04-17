import java.util.ArrayList;
import java.util.Collections;

public class QuizHandler{

    ArrayList<Question> questionList = new ArrayList<>();
    int answered, correct;


    /**
     * The constructor for QuizHandler. Sets up question and the right answer for them.
     * A new question here, adds a new question to the quiz.
     */
    public QuizHandler(){
        answered = 0;
        correct = 0;
        Collections.addAll(questionList,
                new Question("Norge?", "Oslo", "http://flags.fmcdn.net/data/flags/w580/no.png"),
                new Question("Sverige?", "Stockholm", "http://flags.fmcdn.net/data/flags/w580/se.png"),
                new Question("Finland?", "Helsinki", "http://flags.fmcdn.net/data/flags/w580/fi.png"),
                new Question("Russland?", "Moskva", "http://flags.fmcdn.net/data/flags/w580/ru.png"),
                new Question("Romania?", "Bucuresti", "http://flags.fmcdn.net/data/flags/w580/ro.png"));
    }


    /**
     * Regular getters and setters.
     */
    public Question getNextQuestion(int i){
        return questionList.get(i);
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect() {
        correct++;
    }

    public int getAnsweredQuestions() {
        return answered;
    }

    public void setAnswered() {
        answered++;
    }

    public int getArrayListLength(){
        return questionList.size();
    }
}
