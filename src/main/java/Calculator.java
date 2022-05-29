import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AlecE on 6/15/2017.
 * Edited by Mthobisi
 */
public class Calculator {
    private static BigDecimal sum;
    private static BigDecimal number1;
    private static BigDecimal number2;
    static final String regExp = "[0-9]+([,.][0-9]{1,2})?";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String tryAgain = "";
        do {
            if (tryAgain.equalsIgnoreCase("n")) {
                break;
            }
            try {

                System.out.println("Enter first number :");
                number1 = scanner.nextBigDecimal();

                while (!validateNumbers(number1)) {
                    System.out.println("Enter a valid numeric value(non-numeric) :");
                    number1 = scanner.nextBigDecimal();
                }

                scanner.nextLine();
                System.out.println("Which operator would you like to use:eg(+,-, /, *) :");
                String operation = scanner.nextLine();

                System.out.println("Enter second number to calculate :");
                number2 = scanner.nextBigDecimal();

                while (!validateNumbers(number2)) {
                    System.out.println("Enter a valid numeric value(non-numeric) :");
                    number2 = scanner.nextBigDecimal();
                }

                checkNumberForZero(operation, number1, number2);
                scanner.nextLine();
                System.out.println("Would you like to try again(y/n) :");
            }catch (Exception e){
                System.out.println(e.toString());
            }
            tryAgain = scanner.nextLine();
        } while (tryAgain.equalsIgnoreCase("y"));
    }

    public static boolean validateNumbers(BigDecimal num) {
        String number = String.valueOf(num);
        final Pattern pattern = Pattern.compile(regExp);

        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public static void checkNumberForZero(String operation, BigDecimal num1, BigDecimal num2){
        if(num1.intValue() == 0 || num2.intValue() == 0 && operation.equalsIgnoreCase("/")){
                System.out.println(num1.intValue()+ " cannot be divided by "+ num2.intValue());
        }else {
            sum = getTotal(operation, num1, num2);
            System.out.println("Total of two values : " + sum);
        }
    }

    public static BigDecimal getTotal(String operation, BigDecimal num1, BigDecimal num2) {
        return (operation.equals("+")) ? num1.add(num2) :
                (operation.equals("-")) ? num1.subtract(num2) :
                        (operation.equals("/")) ? num1.divide(num2) :
                                (operation.equals("*"))? num1.multiply(num2) : null;
    }
}
