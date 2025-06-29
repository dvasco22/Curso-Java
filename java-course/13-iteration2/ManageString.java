public class ManageString {

    static void countDown() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
    }

    static String removeFirstLast(String value) {
        String result = "";

        for (int i = 1; i < value.length() - 1; i++) {
            result = result + value.charAt(i);
        }
        return result;
    }

    static String reverseString(String value) {
        String result = "";

        for (int i = 0; i < value.length(); i++) {
            result = value.charAt(i) + result;
        }
        return result;
    }

    static String reverseString2(String value) {
        String result = "";

        for (int i = value.length() - 1; i >= 0; i--) {
            result = result + value.charAt(i);
        }
        return result;
    }

    static String removeSpaces(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                continue;
            }
            result += text.charAt(i);
        }
        return result;
    }
}
