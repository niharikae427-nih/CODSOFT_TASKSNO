
    import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {

    static boolean timeUp = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] questions = {
                "1. Java is developed by?",
                "2. Which keyword is used for inheritance?",
                "3. Size of int?"
        };

        String[][] options = {
                {"A. Microsoft","B. Sun Microsystems","C. Google","D. Apple"},
                {"A. extends","B. implement","C. super","D. final"},
                {"A. 2","B. 4","C. 8","D. 16"}
        };

        char[] answers = {'B','A','B'};

        int score = 0;

        for(int i=0;i<questions.length;i++){

            timeUp=false;

            System.out.println("\n"+questions[i]);

            for(String option:options[i])
                System.out.println(option);

            Timer timer = new Timer();

            timer.schedule(new TimerTask() {
                public void run() {
                    timeUp=true;
                    System.out.println("\nTime Up!");
                }
            },10000);

            System.out.print("Answer: ");

            String input=sc.next();

            timer.cancel();

            if(!timeUp && input.toUpperCase().charAt(0)==answers[i]){
                score++;
            }
        }

        System.out.println("\nQuiz Finished");
        System.out.println("Score = "+score+"/"+questions.length);
    }
}

