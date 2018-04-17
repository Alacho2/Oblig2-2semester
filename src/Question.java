public class Question {

    String question, answer, image;

    /**
     * The main question constructor. Keeps track of the single question added to the quiz.
     * @param question    The question in question.
     * @param answer      The correct answer in question.
     * @param image       The image for the question.
     */
    public Question(String question, String answer, String image) {
        this.question = question;
        this.answer = answer;
        this.image = image;
    }


    /**
     * Regular getters and setters
     */
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
