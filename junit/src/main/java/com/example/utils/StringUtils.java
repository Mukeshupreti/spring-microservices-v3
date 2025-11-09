package com.example.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringUtils {

    /**
     * Finds the first non-repeating character in a string.
     * Returns null if none found.
     */
    public Character firstUnique(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        Map<Character, Integer> charCounts = new LinkedHashMap<>();

        // Count occurrences
        for (char c : input.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        // Find first with count = 1
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null;
    }
}
