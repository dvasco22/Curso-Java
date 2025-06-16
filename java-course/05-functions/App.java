public class App {

    public static void main(String[] args) {

        int num1 = Integer.valueOf(args[0]);
        int num2 = Integer.valueOf(args[1]);

        System.out.println(num1);
        System.out.println(num2);

        int result = Calculator.multiply(num1, num2);
        Calculator.showResult("multiplicación", result);

    }

}
