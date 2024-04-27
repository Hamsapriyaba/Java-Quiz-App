import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {

    public static void main(String[] args) {
        List<Question> questions = initializeQuestions();
        int score = startQuiz(questions);
        displayFeedback(score, questions.size());
    }

    private static List<Question> initializeQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "Who is known as the father of Java language?",
                new String[]{"a) Dennis Ritchie", "b) Bjarne Stroustrup", "c) James Gosling", "d) Guido van Rossum"},
                'c'
        ));
        questions.add(new Question(
                "What is the time complexity of inserting an element at the end of an ArrayList in Java?",
                new String[]{"a) O(1)", "b) O(log n)", "c) O(n)", "d) O(n^2)"},
                'a'
        ));
        questions.add(new Question(
                "What protocol is used to transfer web pages over the Internet?",
                new String[]{"a) FTP", "b) HTTP", "c) SMTP", "d) TCP"},
                'b'
        ));
        questions.add(new Question(
                "Which of the below is not built-in class loaders in java?",
                new String[]{"a) Bootstrap Class Loader", "b) Extensions Class Loader", "c) Runtime Class Loader", "d) System Class Loader"},
                'c'
        ));
        questions.add(new Question(
                "This is the parent of Error and Exception classes.",
                new String[]{"a) Throwable", "b) Catchable", "c) MainError", "d) MainException"},
                'a'
        ));
        questions.add(new Question(
                "What annotation is used to map a URL pattern to a servlet in Java?",
                new String[]{"a) @WebServlet", "b) @ServletMapping", "c) @WebRoute", "d) @Servlet"},
                'a'
        ));
        questions.add(new Question(
                "Which keyword is used for Debugging in Java?",
                new String[]{"a) Abstract", "b) Insert", "c) Assert", "d) Not Attempted"},
                'c'
        ));
        questions.add(new Question(
                "Parent class of all java classes is",
                new String[]{"a) Java.lang.system", "b) Java.lang.object", "c) Java.lang.class", "d) Java.lang,reflect.object"},
                'b'
        ));
        questions.add(new Question(
                "Which of the following is not a java primitive type?",
                new String[]{"a) short", "b) long", "c) long double", "d) boolean"},
                'c'
        ));
        questions.add(new Question(
                "Which component is used to compile, debug and execute the java programs?",
                new String[]{"a) JRE", "b) JIT", "c) JDK", "d) JVM"},
                'c'
        ));
        return questions;
    }

    private static int startQuiz(List<Question> questions) {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            for (String option : question.getOptions()) {
                System.out.println(option);
            }
            String userAnswer;
            do {
                System.out.print("Your answer (a, b, c, or d): ");
                userAnswer = sc.nextLine().trim().toLowerCase();
                if (!isValidInput(userAnswer)) {
                    System.out.println("Invalid input. Please enter a valid option (a, b, c, or d).");
                }
            } while (!isValidInput(userAnswer));

            if (isCorrectAnswer(userAnswer, question)) {
                score++;
            }
            System.out.println(); // Add a newline for better readability
        }

        return score;
    }

    private static boolean isValidInput(String input) {
        return input.length() == 1 && input.matches("[a-d]");
    }

    private static boolean isCorrectAnswer(String userAnswer, Question question) {
        char userChoice = userAnswer.charAt(0);
        return userChoice == question.getCorrectAnswer();
    }

    private static void displayFeedback(int score, int totalQuestions) {
        double percentage = ((double) score / totalQuestions) * 100;
        String feedback;

        if (percentage >= 90) {
            feedback = "Excellent! You scored " + score + "/" + totalQuestions + ". Keep up the good work!";
        } else if (percentage >= 70) {
            feedback = "Good job! You scored " + score + "/" + totalQuestions + ". Well done!";
        } else if (percentage >= 50) {
            feedback = "Not bad. You scored " + score + "/" + totalQuestions + ". Keep practicing!";
        } else {
            feedback = "You need more practice. You scored " + score + "/" + totalQuestions + ". Better luck next time!";
        }

        System.out.println(feedback);
    }
}

class Question {
    private final String questionText;
    private final String[] options;
    private final char correctAnswer;

    public Question(String questionText, String[] options, char correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}
