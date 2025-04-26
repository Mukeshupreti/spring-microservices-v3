package algorithms.StringAndArray;

// is result have that not that character add it
public class RemoveDuplicatesFromString {
    public static void main(String[] args) {
        String str = "programming";
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (result.indexOf(c) == -1) {
                result += c;
            }
        }

        System.out.println("Original: " + str);
        System.out.println("Without duplicates: " + result);
    }
}

