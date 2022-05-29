import java.util.Scanner;

/**
 * Created by AlecE on 6/15/2017.
 * Edited by Mthobisi
 */
public class Calculator {
    private static double sum = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String tryAgain = "";
        do {
            if (tryAgain.equalsIgnoreCase("n")) {
                break;
            }
            System.out.println("Enter first number :");
            String number1 = scanner.nextLine();

            while (!validateNumbers(number1)) {
                System.out.println("Enter a valid numeric value(non-numeric) :");
                number1 = scanner.nextLine();
            }

            System.out.println("Which operator would you like to use:eg(+,-, /, *) :");
            String operation = scanner.nextLine();

            System.out.println("Enter second number to calculate :");
            String number2 = scanner.nextLine();

            while (!validateNumbers(number2)) {
                System.out.println("Enter a valid numeric value(non-numeric) :");
                number2 = scanner.nextLine();
            }

            double num1 = Double.valueOf(number1);
            double num2 = Double.valueOf(number2);

            checkNumberForZero(operation, num1, num2);
            System.out.println("Would you like to try again(y/n) :");

            tryAgain = scanner.nextLine();
        } while (tryAgain.equalsIgnoreCase("y"));
    }

    public static boolean validateNumbers(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    public static void checkNumberForZero(String operation, double num1, double num2){
        if(num1==0 || num2==0){
            if(num1==0 && num2 > 0){
                System.out.println(num1+ " cannot be calculated with "+ num2);
            }else if(num1>0 && num2==0){
                System.out.println(num1+ " cannot be calculated with "+ num2);
            }
        }else {
            sum = getTotal(operation, String.valueOf(num1), String.valueOf(num2));
            System.out.println("Total of two values : " + sum);
            sum=0;
        }
    }

    public static double getTotal(String operation, String number1, String number2) {
        double num1 = Double.valueOf(number1);
        double num2 = Double.valueOf(number2);
        return (operation.equals("+")) ? num1 + num2 :
                (operation.equals("-")) ? num1 - num2 :
                        (operation.equals("/")) ? num1 / num2 : (operation.equals("*"))? num1*num2: 0;
    }
}
