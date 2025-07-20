import java.util.Random;

public class RandomNumbers {
    public static void main(String[] args) {

        // ✅ Genera un número decimal aleatorio (tipo double) entre 0.0 y 1.0 (excluye
        // 1.0).
        double random = Math.random();
        System.out.println(random);

        // ✅ Genera un número entero aleatorio entre 1 y 9, ambos inclusive:
        Random randomCreator = new Random();
        //int random2 = randomCreator.nextInt(9) + 1;
        //System.out.println(random2);
        
        int scope=1;
        //double randomValue = (Math.random() * 2 * scope) - scope; // value ramdom bwn -1 and +1

        int randomValue = (int) randomCreator.nextInt(2 * scope + 1) - (scope); 
        System.out.println(randomValue);

    }
}
