
package mathquiz;

import java.util.Scanner;

public class MathQuiz {
    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < 5; i++) {
            QuestionGenerator.Question q = QuestionGenerator.generateQuestion();
            System.out.println("Q" + (i + 1) + ": " + q.question);
            int answer = scanner.nextInt();
            if (answer == q.answer) {
                score++;
            }
        }
        System.out.println("Quiz Completed! Your Score: " + score + "/5");
    }
}