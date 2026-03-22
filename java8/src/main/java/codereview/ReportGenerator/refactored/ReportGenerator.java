package codereview.ReportGenerator.refactored;

import java.util.List;/*
✅ Lazy-loaded singleton is not thread-safe
✅ No private constructor → singleton can be bypassed
✅ String concatenation inside loop → poor performance O(n²); use StringBuilder
✅ No null-check for data → NullPointerException
✅ No immutability — instance is not volatile
✅ Logic building the string is verbose; enhanced for-loop or streams are cleaner
✅ If this class is stateless, a singleton may be unnecessary; could be a static utility method*/
public class ReportGenerator {

    private ReportGenerator() {}

    private static final ReportGenerator INSTANCE = new ReportGenerator();

    public static ReportGenerator getInstance() {
        return INSTANCE;
    }

    public String buildReport(List<String> data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }

        StringBuilder sb = new StringBuilder();
        for (String line : data) {
            sb.append(line).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
