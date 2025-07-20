package local.collections;

import java.util.ArrayList;

public class Demo04ArrayList {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(10);
        arrayList.add("Element 1");
        arrayList.add("Element 2");
        System.out.println("ArrayList: " + arrayList.getClass().getSimpleName());
        System.out.println("Size: " + arrayList.size());
        System.out.println("Elements: " + arrayList);
        // Ver diferencia en el debugger
        // desactivando Logical Structure View
        arrayList.trimToSize();
        arrayList.ensureCapacity(20); // Aumenta la capacidad a 20
    }

}