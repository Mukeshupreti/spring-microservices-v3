package codereview.ReportGenerator;

import java.util.List;
// My review
// Not thread safe sigalton Implementation //Fixes: synchronized, double-checked locking, or enum singleton
// Dependency injection should be there.
// use String builder which create unnessary object
//
// more readbility use enhance for loop fo collction.
// breaking single resposibility--This is wrong
// no null check for data
// Missing from me private constructor


public class ReportGenerator {
    private static ReportGenerator instance;

    public static ReportGenerator getInstance() {
        if (instance == null) {
            instance = new ReportGenerator();
        }
        return instance;
    }

    public String buildReport(List<String> data) {
        String result = "";
        for (int i = 0; i < data.size(); i++) {
            result = result + data.get(i) + "\n";   // use spring builder
        }
        return result;
    }
}
