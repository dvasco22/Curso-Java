public class StringBufferExample {
 
   public static void main(String[] args) {
        
       StringBuffer sb = new StringBuffer("Sample StringBuffer's value 22");
        
       // sb.toString() is called here
       System.out.println("original: " + sb);
        
       // length() method call returns the actual length of the string held in the StringBuffer
       // capacity() method call returns StringBuffer object's capacity. This is number of characters that StringBuffer object can currently hold.
       // Capacity of the StringBuffer object is managed automatically.
       System.out.println("length(): " + sb.length() + ", capacity(): " + sb.capacity());
        
       // charAt() method call returns the character that is hold at the given index of the StringBuffer object
       System.out.println("charAt(): " + sb.charAt(5)); //'e' character - [0]S [1]a [2]m [3]p [4]l [5]e [6] [7]S [8] [9]t [10]r [11]i [12]n [13]g...
        
       // codePointAt() method call returns the code point value (unicode code) of the character at the given index
       System.out.println("codePointAt(): " + sb.codePointAt(5)); // 'e' sign unicode code
        
       // append() method call joins StringBuffer value with the String value passed as the argument
       System.out.println("append(): " + sb.append(" by itcuties"));
        
       // insert() method call inserts the string representation of the object passed as the argument at the given index
       System.out.println("insert(): " + sb.insert(7, "[INSERT THIS] "));
        
       // indexOf() method call returns the index within this string of the first occurrence of the String passed as the argument.
       System.out.println("indexOf():" + sb.indexOf("[INSERT THIS]"));
        
       // delete() method call removes the characters from the index 7 up to index 20
       System.out.println("delete(): " + sb.delete(7, 7+ "[INSERT THIS] ".length()));
        
       // substring() method call returns a new String that contains a subsequence of characters currently contained in this sequence.
       // In this example the code returns the substring from the index 31 up to index 38
       System.out.println("substing(): " + sb.substring(31,39));
 
       // reverse() method call results in reversing the characters order of the string held in the StringBuffer object
       System.out.println("reverse(): " + sb.reverse());
        
   }
}