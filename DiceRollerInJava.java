import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// dice roller java source code
// Also outputs the dice face as ASCII art
public class DiceRollerInJava {

    // This has printing information for all numbers
    // For each number,3x3 matrix represents the face
    int[][][] faceConfig = {
            { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } },
            { { 0, 0, 1 }, { 0, 0, 0 }, { 1, 0, 0 } },
            { { 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 } },
            { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } },
            { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } },
            { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } },
            { { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 } },
            { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } },
            { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } },
    };

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";


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
            else if (input.equalsIgnoreCase("y") ||
                    input.equalsIgnoreCase("yes")) {
                ArrayList<Integer> values = new ArrayList<Integer>();


                System.out.println("How many dices do you want to roll? (type an integer value):");
                Integer dices = Integer.parseInt(scanner.nextLine());

                int minValue = -1;
                int maxValue = -1;

                while (minValue <= 0) {
                    System.out.println("What do you want the minimum dice value to be?");
                    minValue = Integer.parseInt(scanner.nextLine());
                }

                while (maxValue <= minValue) {
                    System.out.println("What do you want the maximum dice value to be (must be bigger than the minimum value)?");
                    maxValue = Integer.parseInt(scanner.nextLine());
                }

                for (int i = 0; i < dices; i++) {
                    int result = dice.roll(minValue, maxValue);
                    values.add(result);
                    System.out.println("Value: " + ANSI_RED + result + ANSI_RESET);
                    dice.draw(result);
                }

                System.out.println("Average: "  + ANSI_RED + calcAverage(values) + ANSI_RESET);
                System.out.println("Sum: " + ANSI_RED + calcSum(values) + ANSI_RESET);



            }
            else{
                System.out.println("Try again");
                System.out.println("Only use 'yes', 'y', 'no' & 'n' to answer the question.");

            }
        }
    }

    // Draw the dice face using ascii characters
    private void draw(int value) {
        if(value <= 9) {
            int[][] displayVal = faceConfig[value - 1];
            System.out.println("-----");

            for (int i = 0; i < 3; i++) {
                System.out.print("|");
                for (int j = 0; j < 3; j++) {
                    if (displayVal[i][j] == 1) {
                        System.out.print(ANSI_RED + "o" + ANSI_RESET);
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println("|");
            }
            System.out.println("-----");
        }

        else {
            System.out.println();
        }

    }

    // Roll the dice in Java
    private int roll(int minValue, int maxValue) {
        Random r = new Random();
        return minValue + r.nextInt(maxValue-(minValue-1));
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