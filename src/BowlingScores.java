import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BowlingScores {

    static String[] allFrames = new String[10];
    static int[] scores = new int[10];

    // get value of mark
    public static int getval(char c) {
        return switch (c) {
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> c - '0';
            case 'x' -> 10;
            default -> 0;
        };
    }

    /**
     * Calculate the score of a game in the form:
     * 8/9-44729-xx8-359/7
     *
     * @param frames game date like above
     * @return final score as int
     */
    public static int processFrames(String frames) {
        int x = 0;
        int score = 0;
        frames = frames.toLowerCase();
        for (int i = 0; i < allFrames.length - 1; i++) {
            char c = frames.charAt(x);
            if (c == 'x') {
                allFrames[i] = String.valueOf(c);
                scores[i] = score + 10 + ((frames.charAt(x + 2) == '/') ? 10
                        : getval(frames.charAt(x + 1)) + getval(frames.charAt(x + 2)));
                x++;
            } else {
                char c1 = frames.charAt(x + 1);
                allFrames[i] = String.valueOf(c) + c1;
                scores[i] = score + ((c1 == '/') ? 10 + getval(frames.charAt(x + 2))
                        : getval(c) + getval(c1));
                x += 2;
            }
            score = scores[i];
        }

        // final frame
        String last = frames.substring(x);
        allFrames[9] = last;
        score += switch (last.charAt(1)) {
            case '/' -> 10 + getval(last.charAt(2));
            case '-' -> getval(last.charAt(0)) + getval(last.charAt(1));
            default -> getval(last.charAt(0)) + getval(last.charAt(1)) + getval(last.charAt(2));
        };
        scores[9] = score;

        for (String allFrame : allFrames) {
            System.out.printf("%4s", allFrame);
        }
        return score;
    }

    public static void printRunner() {
        for (int x = 0; x < allFrames.length; x++)
            System.out.print("+-------");
        System.out.println("+");
    }

    public static void printFrameNums() {
        for (int x = 0; x < allFrames.length; x++)
            System.out.printf("|%4d   ", x);
        System.out.println("|");
    }

    public static void printFrames() {
        for (String frame : allFrames)
            System.out.printf("|%5s  ", frame);
        System.out.println("|");
    }

    public static void printScores() {
        for (int x = 0; x < allFrames.length; x++)
            System.out.printf("|%5d  ", scores[x]);
        System.out.println("|");
    }

    /**
     * Make a pretty version of:
     * 8/9-44729-xx8-359/7
     */
    public static void prettyPrint() {
        printRunner();
        printFrameNums();
        printRunner();
        printFrames();
        printRunner();
        printScores();
        printRunner();
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner infile = new Scanner(new File(args[0]));

        while (infile.hasNextLine()) {
            String line = infile.nextLine();
            String[] tokens = line.split("=");
            if (tokens.length != 2) {
                System.out.println(line + " is not a valid bowling score entry.");
            } else {
                int expected = Integer.parseInt(tokens[1]);
                String frames = tokens[0];

                int score = processFrames(frames);
                System.out.println(score + " " + expected + " " + frames);
                prettyPrint();
            }
        }
    }
}
