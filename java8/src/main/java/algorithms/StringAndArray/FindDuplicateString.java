package algorithms.StringAndArray;

public class FindDuplicateString {
    public static void main(String[] args) {
        // find duplicate charater in the string
        String str = "programming";
        int[] charCount = new int[256];  // ASCII limit

        for (int i = 0; i < str.length(); i++) {
            charCount[str.charAt(i)]++;
        }

        System.out.println("Duplicate characters:");
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > 1) {
                System.out.println((char) i + " = " + charCount[i]);
            }
        }
    }
}
