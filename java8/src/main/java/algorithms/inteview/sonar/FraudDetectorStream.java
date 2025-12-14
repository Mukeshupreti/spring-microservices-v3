package algorithms.inteview.sonar;

import java.util.*;
import java.util.stream.*;

public class FraudDetectorStream {

    static class Transaction {
        String userId;
        long amount;
        long timestamp;

        Transaction(String userId, long amount, long timestamp) {
            this.userId = userId;
            this.amount = amount;
            this.timestamp = timestamp;
        }
    }

    public static List<String> findSuspiciousUsers(List<Transaction> transactions) {

        final long AMOUNT_LIMIT = 10000;
        final long TIME_WINDOW = 100;

        // Step 1: Users who exceeded the amount limit
        Set<String> amountFraud =
                transactions.stream()
                        .filter(t -> t.amount > AMOUNT_LIMIT)
                        .map(t -> t.userId)
                        .collect(Collectors.toSet());
        transactions.stream()
                .collect(Collectors.groupingBy(t -> t.userId,
                        Collectors.mapping(t -> t.amount,Collectors.counting())));
        // Step 2: Users who made 2 transactions within 100 seconds
        Set<String> timeFraud =
                transactions.stream()
                        .collect(Collectors.groupingBy(t -> t.userId,
                                Collectors.mapping(t -> t.timestamp, Collectors.toList())))
                        .entrySet()
                        .stream()
                        .filter(entry -> {
                            List<Long> times = entry.getValue();
                            Collections.sort(times);
                            for (int i = 1; i < times.size(); i++) {
                                if (times.get(i) - times.get(i - 1) <= TIME_WINDOW) {
                                    return true;
                                }
                            }
                            return false;
                        })
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toSet());

        // Combine and return sorted list
        return Stream.concat(amountFraud.stream(), timeFraud.stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Transaction> transactions = Arrays.asList(
                new Transaction("Alice", 5000, 10050),
                new Transaction("Bob", 12000, 10400),
                new Transaction("John", 3000, 10060),
                new Transaction("Alice", 2000, 10200),
                new Transaction("Alice", 6000, 10070)
        );

        System.out.println(findSuspiciousUsers(transactions));  
        // Output: [Alice, Bob]
    }
}
