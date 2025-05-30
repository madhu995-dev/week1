
package mathquiz;

import java.util.Random;

public class QuestionGenerator {
    public static class Question {
        public String question;
        public int answer;

        public Question(String question, int answer) {
            this.question = question;
            this.answer = answer;
        }
    }

    public static Question generateQuestion() {
        Random rand = new Random();
        int a = rand.nextInt(10);
        int b = rand.nextInt(10);
        int op = rand.nextInt(3);
        switch (op) {
            case 0: return new Question(a + " + " + b, a + b);
            case 1: return new Question(a + " - " + b, a - b);
            default: return new Question(a + " * " + b, a * b);
        }
    }
}