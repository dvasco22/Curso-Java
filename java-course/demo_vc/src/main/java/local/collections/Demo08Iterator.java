
package local.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class Demo08Iterator {

    void useIterators(Collection<Integer> coll) {
        Iterator<Integer> ite = coll.iterator();
        while (ite.hasNext()) {
            Integer item = ite.next();
            System.out.println(item);
        }
    }

    void useIteratorForEach(Collection<Integer> coll) {

        // Integer accumulator = 0;
        // Consumer<Integer> foo = (item) -> {
        // accumulator = accumulator + item;
        // System.out.println("Item: " + item);
        // };

        coll.forEach((item) -> System.out.println("Item: " + item));
        // return accumulator;
    }

    public static void main(String[] args) {
        Demo08Iterator demo = new Demo08Iterator();
        Collection<Integer> coll = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            coll.add(i);
        }

        demo.useIterators(coll);
        demo.useIteratorForEach(coll);
    }

}