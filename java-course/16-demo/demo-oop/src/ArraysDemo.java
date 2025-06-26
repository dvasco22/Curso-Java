
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ArraysDemo {

    public static int[] foo(int[] data) {
        int[] newData = data.clone();
        newData[0] = 400;
        return newData;

    }

    public static void showArray(int[] data) {
        System.out.print("[");
        System.out.print(data[0]);

        int[] shortArray = Arrays.copyOfRange(data, 1, data.length);

        for (int item : shortArray) {
            System.out.print(", " + item);
        }
        System.out.println("]");

    }

    public static void main(String[] args) {
        int[] data = { 1, 2, 34, 5, 89 };
        int[] data2 = data;
        int[] data3 = { 1, 2, 34, 5, 89 };
        System.out.println(data == data2);
        System.out.println(data == data3); // false

        foo(data3);
        System.out.println("Mi array " + Arrays.toString(data));

        Integer[] numbers = { 1, 2, 34, 5, 89 };
        List<Integer> temp = Arrays.asList(numbers);
        System.out.println("Temp list " + temp);
        // showArray(data3);

        int[] numbers2 = { 1, 2, 34, 5, 89 };
        List temp2 = Arrays.asList(numbers);
        System.out.println("Temp list " + temp2);

        System.out.println(data3[0]); // 1

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(34);
        list.add(5);
        list.add(89);
        System.out.println(list);

    }
}
