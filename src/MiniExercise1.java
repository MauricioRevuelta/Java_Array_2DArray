import java.util.Random;
import java.util.Scanner;

/*  MiniExercise 1
    Student: Mauricio Revuelta
    Student ID: 200564696
    Course: Intro Obj Oriented Prog-Java
 */

public class MiniExercise1 {

    // Call of the 2 main methods inside the main method
    public static void main(String[] args) {
        Task1();
        Task2();
    }

    // Creating Task 1 method
    public static void Task1() {
        Scanner sc = new Scanner(System.in);

        // Step 1: Ask user to input how many items would like to add.
        System.out.print("Please enter the number of elements to create: ");
        int numElements = sc.nextInt();

        // Step 2: Create the object array with number of  elements based on user's input
        Object[] array = new Object[numElements];

        // Step 3: Using for loop to ask the user input value for each element
        for (int i = 0; i < numElements; i++) {
            System.out.print("Enter value for element " + (i + 1) + ": ");
            String input = sc.next();

            // a) Checks if the value is 0 or 1 and then convert it to a Boolean
            if (input.equals("0") || input.equals("1")) {
                array[i] = Boolean.parseBoolean(input);
            }
            // b) Checks if the value is within the byte range and then convert it to a byte
            else if (byteRange(input)) {
                array[i] = Byte.parseByte(input);
            }
            // c) Checks if the value is within the short range and then convert it to a short
            else if (shortRange(input)) {
                array[i] = Short.parseShort(input);
            }
            // d) Checks if the value is a number and then convert it to integer
            else if (isNumeric(input)) {
                array[i] = Integer.parseInt(input);
            }
        }

        // Display each element of the array
        System.out.println("Task 1: List of array elements:");
        for (Object element : array) {
            System.out.println(element);
        }
    }

    private static boolean byteRange(String value) {
        try {
            byte byteValue = Byte.parseByte(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean shortRange(String value) {
        try {
            short shortValue = Short.parseShort(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Creating Task 2 method
    public static void Task2() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // Step 1: Create the multi-dimensional array
        int[][] multTable = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                multTable[i][j] = (i + 1) * (j + 1);
            }
        }

        // Step 2: Asking user the number of questions that he/she would like to answer
        System.out.print("Please enter the number of questions that you would like to answer: ");
        int numQuestions = sc.nextInt();
        int answers = 0;

        // Step 3: In a loop
        for (int qNumber = 1; qNumber <= numQuestions; qNumber++) {
            // a) Randomly chose two indices from the array
            int randomIndex1 = random.nextInt(10);
            int randomIndex2 = random.nextInt(10);

            // b) Display the question
            int expectedAnswer = multTable[randomIndex1][randomIndex2];
            System.out.println("Question " + qNumber + ":");
            System.out.println("What is " + (randomIndex1 + 1) + " x " + (randomIndex2 + 1) + " ?");
            System.out.print("Your answer: ");

            // c) Store the user’s answer for the expression
            int userAnswer = sc.nextInt();

            // Checking if answer is correct
            if (userAnswer == expectedAnswer) {
                System.out.println("Correct! Well done!");
                answers++;
            } else {
                // ii) Display the correct answer if the answer is incorrect
                System.out.println("Incorrect. The correct answer is: " + expectedAnswer);
            }
        }

        // Step 4: Show summary of correct answers
        int percentage = (int) ((double) answers / numQuestions * 100);
        System.out.printf("You answered %d out of %d. That’s a percentage of %d%%\n",
                answers, numQuestions, percentage);
    }
}
