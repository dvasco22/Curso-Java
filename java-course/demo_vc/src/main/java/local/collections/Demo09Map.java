
package local.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo09Map {
    // Map is a collection that maps keys to values
    // We can use a HashMap to implement a map
    Map<Character, String> map = new HashMap<>();
    
    /**
     * Demonstrates the use of a map data structure using HashMap.
     * A map is a collection that maps keys to values, allowing for fast retrieval.
     */

    void makeStringMap() {

        // Put elements into the map
        map.put('A', "Alpha");
        map.put('B', "Beta");
        map.put('C', "Charlie");
        map.put('D', "Delta");
        map.put('E', "Echo");
        map.put('F', "Foxtrot");
        map.put('G', "Golf");

        // Display the size of the map
        System.out.println("Size of the map: " + map.size());
        System.out.println(map);

        // Claves
        Set<Character> keys = map.keySet();
        System.out.println("Keys in the map: " + keys);
        // Keys in the map: [A, B, C, D, E, F, G]
        
        // Values
        Collection<String> values = map.values();
        System.out.println("Values in the map: " + values);
        // Values in the map: [Alpha, Beta, Charlie, Delta, Echo, Foxtrot, Golf]
        
        // Entradas
        // Conjunto (Set) de entradas que son tuplas: key-value pairs
        Set<Map.Entry<Character, String>> entries = map.entrySet();
        System.out.println("Entries in the map: " + entries);
        // Entries in the map: [A=Alpha, B=Beta, C=Charlie, D=Delta, E=Echo, F=Foxtrot, G=Golf]


        // Retrieve elements from the map
        for (Character key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }

    void modifyMap() {
        // Modify an element in the map
        String previous = map.put('A', "Alfalfa");
        System.out.println("Modified map: " + map);
        System.out.println("Previous value for key 'A': " + previous);

        // Remove an element from the map
        map.remove('B');
        System.out.println("After removing B: " + map);

        // Replace an element in the map
        String replaced = map.replace('C', "Cobra");
        System.out.println("After replacing C: " + map);
        System.out.println("Replaced value for key 'C': " + replaced);

        replaced = map.replace('Z', "Zebra");
        System.out.println("After replacing Z: " + map);
        System.out.println("Replaced value for key 'Z': " + replaced);

        // Replace with two parameters
        boolean isReplaced = map.replace('D', "Delta", "Dog");
        System.out.println("After conditional replace D: " + map);
        System.out.println("Was D replaced? " + isReplaced);    

        // Check if a key exists
        if (map.containsKey('C')) {
            System.out.println("Key C exists in the map.");
        } else {
            System.out.println("Key C does not exist in the map.");
        }

        // Check if a value exists
        if (map.containsValue("Delta")) {
            System.out.println("Value Delta exists in the map.");
        } else {
            System.out.println("Value Delta does not exist in the map.");
        }
    }

    public static void main(String[] args) {
        Demo09Map demo = new Demo09Map();
        demo.makeStringMap();
        System.out.println("--------------------");
        demo.modifyMap();
    }

}
