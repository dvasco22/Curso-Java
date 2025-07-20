package local.collections.exercises;

import java.util.Stack;

public class Exx02Pali {

    String word;
    String inverse;

    public Exx02Pali(String word) {
        this.word = word;
        this.inverse = generateInverse();
    }

    private String generateInverse() {
        Stack<Character> stack = new Stack<>();
        ;
        StringBuffer inverse = new StringBuffer();
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        while (!stack.isEmpty()) {
            inverse.append(stack.pop());
        }
        return inverse.toString();
    }

    public void showResult() {
        System.out.println(word + " - " + inverse);
        String message = word.equals(inverse) ? "si" : "no";
        System.out.println(message.toUpperCase() + " son palíndomos");

    }

    public static void main(String[] args) {
        Exx02Pali pali = new Exx02Pali(args[0]);
        pali.showResult();
    }

}