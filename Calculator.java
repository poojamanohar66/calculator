import java.util.Scanner;


public class Calculator {

    
    public static double add(double a, double b) {
        return a + b;
    }

    
    public static double subtract(double a, double b) {
        return a - b;
    }

    
    public static double multiply(double a, double b) {
        return a * b;
    }

    
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN; // Not a Number
        }
        return a / b;
    }

   
    public static void main(String[] args) {
        // Create a Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        System.out.println("--- Java Console Calculator ---");
        System.out.println("Enter 'q' at any time to quit.");

        while (continueCalculating) {
            System.out.print("\nEnter the first number: ");
            String inputA = scanner.nextLine();
            if (inputA.equalsIgnoreCase("q")) {
                continueCalculating = false;
                continue;
            }

            double num1;
            try {
                num1 = Double.parseDouble(inputA);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            System.out.print("Enter an operator (+, -, *, /): ");
            String operator = scanner.nextLine();
            if (operator.equalsIgnoreCase("q")) {
                continueCalculating = false;
                continue;
            }

            System.out.print("Enter the second number: ");
            String inputB = scanner.nextLine();
            if (inputB.equalsIgnoreCase("q")) {
                continueCalculating = false;
                continue;
            }

            double num2;
            try {
                num2 = Double.parseDouble(inputB);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            double result = 0;
            switch (operator) {
                case "+":
                    result = add(num1, num2);
                    break;
                case "-":
                    result = subtract(num1, num2);
                    break;
                case "*":
                    result = multiply(num1, num2);
                    break;
                case "/":
                    result = divide(num1, num2);
                    break;
                default:
                    System.out.println("Invalid operator.");
                    continue;
            }

            if (!Double.isNaN(result)) {
                System.out.println("Result: " + result);
            }
        }

        scanner.close();
        System.out.println("Calculator terminated. Goodbye!");
    }
}
