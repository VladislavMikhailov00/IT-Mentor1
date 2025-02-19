import java.util.Scanner;

public class Main {
    public static String calc(String input) throws Exception {

        String[] aValues = input.split("[+\\-*/]");
        if (aValues.length != 2) throw new Exception("Должно быть два операнда");

        String arithmeticExpression = detectedOperation(input);
        if (arithmeticExpression == null) {
            throw new Exception("Неподдерживаемая математическая операция");
        }

        int numberOne = Integer.parseInt(aValues[0]);
        int numberTwo = Integer.parseInt(aValues[1]);

        if (numberOne>10 || numberTwo>10 || numberOne<1||numberTwo<1) {
            throw new Exception("Числа должны быть от 1 до 10");
        }

        return String.valueOf(calc(numberOne, numberTwo, arithmeticExpression));
    }

    static String detectedOperation(String inputValue) {
        if (inputValue.contains("+")) {
            return "+";
        } else if (inputValue.contains("-")) {
            return "-";
        } else if (inputValue.contains("*")) {
            return "*";
        } else if (inputValue.contains("/")) {
            return "/";
        } else {
            return null;
        }
    }

    static int calc(int valueOne, int valueTwo, String arithmeticExpression) {

        if (arithmeticExpression.equals("+")) {
            return valueOne + valueTwo;
        } else if (arithmeticExpression.equals("-")) {
            return valueOne - valueTwo;
        } else if (arithmeticExpression.equals("*")) {
            return valueOne * valueTwo;
        } else {
            return valueOne / valueTwo;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Введите два числа: ");
        String inputValue = new Scanner(System.in).nextLine();
        System.out.println(calc(inputValue));
    }
}
