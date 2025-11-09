package com.example.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    private final StringUtils utils = new StringUtils(); // class containing firstUnique

    @Test
    @DisplayName("Normal case: first unique character exists")
    void testFirstUnique_Normal() {
        assertEquals('w', utils.firstUnique("swiss"));
        assertEquals('c', utils.firstUnique("aabcbd"));
    }

    @Test
    @DisplayName("All characters repeat → should return null")
    void testFirstUnique_AllRepeat() {
        assertNull(utils.firstUnique("aabb"));
        assertNull(utils.firstUnique("ccdd"));
    }

    @Test
    @DisplayName("Null or empty input → should return null")
    void testFirstUnique_NullOrEmpty() {
        assertNull(utils.firstUnique(null));
        assertNull(utils.firstUnique(""));
    }

    @ParameterizedTest(name = "Input: {0} → Expected: {1}")
    @CsvSource({
            "abac, b",      // first unique = b
            "a, a",         // only character
            "aa, null",     // all repeated → null
            "'', null",     // empty string → null
            "xyz, x"        // first unique = x
    })
    @DisplayName("Parameterized test for multiple inputs")
    void testFirstUnique_Parameterized(String input, String expected) {
        Character expectedChar = expected == null ? null : expected.charAt(0);
        assertEquals(expectedChar, utils.firstUnique(input));
    }

    @Test
    @DisplayName("Edge case: string with spaces and special chars")
    void testFirstUnique_EdgeCases() {
        assertEquals('!', utils.firstUnique("!!a!b!c!!"));
        assertEquals(' ', utils.firstUnique("  abc  "));
    }
}
