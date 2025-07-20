
package local.generics;

public class Generic<T, U> {
    T foo;
    U[] baz;

    Generic(T foo, U[] baz) {
        this.foo = foo;
        this.baz = baz;
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        Byte b = 2;
        Integer i = 22;
        String[] s = { "Pepe", "Juan" };
        Integer[] arr = { i };

        Generic<Integer, String> gen1 = new Generic<>(i, s);
        Generic<Byte, Integer> gen2 = new Generic<>(b, arr);

    }

}