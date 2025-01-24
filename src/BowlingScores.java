import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BowlingScores {

    /**
     * Calculate the score of a game in the form:
     * 8/9-44729-xx8-359/7
     *
     * @param frames game date like above
     * @return final score as int
     */
    public static int processFrames(String frames) {

        return 0;
    }

    /**
     * Make a pretty version of:
     * 8/9-44729-xx8-359/7
     *
     * @param frames game data like above
     */
    public static void prettyPrint(String frames) {

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
                prettyPrint(frames);
            }
        }
    }
}
