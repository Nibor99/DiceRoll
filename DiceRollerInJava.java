import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// dice roller java source code
// Also outputs the dice face as ASCII art
public class DiceRollerInJava {

    // This has printing information for all numbers
    // For each number,3x3 matrix represents the face
    int[][][] faceConfig = { { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } },
            { { 0, 0, 1 }, { 0, 0, 0 }, { 1, 0, 0 } },
            { { 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 } },
            { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } },
            { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } },
            { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } } };



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DiceRollerInJava dice = new DiceRollerInJava();

        while (true) {
            System.out.println("Do you want to roll dice? (type yes to contine and no to quit):");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("n") ||
                    input.equalsIgnoreCase("no")) {
                System.out.println("Bye!");
                scanner.close();
                break;
            }
            ArrayList<Integer> values = new ArrayList<Integer>();


            System.out.println("How many dices do you want to roll? (type an integer value):");
            Integer dices = Integer.valueOf(scanner.nextLine());

            for (int i = 0; i < dices; i++) {
                int result = dice.roll();
                values.add(result);
                System.out.println("dice face value:" + result);
                dice.draw(result);

            }

            System.out.println("Average: " + calcAverage(values));
            System.out.println("Sum: " + calcSum(values));
            System.out.println("now ");

        }
    }

    // Draw the dice face using ascii characters
    private void draw(int value) {
        int[][] displayVal = faceConfig[value - 1];
        System.out.println("-----");

        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                if (displayVal[i][j] == 1) {
                    System.out.print("o");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        System.out.println("-----");

    }

    // Roll the dice in Java
    private int roll() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }

    private static float calcAverage(ArrayList<Integer> values) {
        float average = 0;
        for(int value : values) {
            average += value;
        }
        return average/values.size();
    }

    private static int calcSum(ArrayList<Integer> values) {
        int sum = 0;
        for(int value : values) {
            sum += value;
        }
        return sum;
    }
}