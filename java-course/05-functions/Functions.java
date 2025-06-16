public class Functions {

    // Función: código ejecutable
    // Puedo invocarlo por su nombre
    // Puede recibir valores -> los recoge como parámetros
    // Puede devolver un valor

    static int add(int num1, int num2) {
        int result = num1 + num2;
        return result;
    }

    static int subtraction(int num1, int num2) {
        int result = num1 - num2;
        return result;
        // return num1 - num2;
    }

    static void showResult(int result) {
        System.out.println("El resultado es " + result);
    }

    public static void main(String[] args) {
        // Los argumentos son los valores que llegarán a los parámetros
        int result = add(24, 4);
        showResult(result);
        result = add(345, result);
        showResult(result);
        showResult(subtraction(23, 56));
    }

}
