
public class Factorial2 {

    static int calculateFactorial(int number) {
        if (number < 0) {
            number = number * -1;
        }

        int result = 1;

        for (int i = number; i > 0; i--) {
            result = result * i;
            // result *= i;
        }
        return result;

    }

    public static void main(String[] args) {

        System.out.println(calculateFactorial(15));

    }

}