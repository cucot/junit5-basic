package com.cucot;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeAll
    void initMathUtil() {
        mathUtils = new MathUtils();
    }

    @AfterAll
    static void showCompleteness() {
        System.out.println("Completed all test cases in this class");
    }

    @AfterEach
    void showEachCompletion() {
        System.out.println("Complete one test");
    }

    @BeforeEach
    void init() {
        System.out.println("This is executed before each test is run");
    }

    @Test
    @DisplayName("Normal Add execution, neither overflow nor underflow")
    void addNormal() {
        assertEquals(3, mathUtils.add(1, 2));
    }

    @Test
    @DisplayName("Add with overflow")
    void addExceedMaxInteger() {
        assertThrows(RuntimeException.class, () -> mathUtils.add(Integer.MAX_VALUE, 1), "Adding with overflow will lead to incorrect calculation and should be prevent. Consider to use long instead");
    }

    @Test
    @DisplayName("Add with underflow")
    void addExceedMinInteger() {
        assertThrows(RuntimeException.class, () -> mathUtils.add(Integer.MIN_VALUE, -1), "Result < Integer.MIN_VALUE will lead to overflow, cause unintended incorrect calculation");
    }

    @Test
    @DisplayName("Fail this test")
    @Disabled
    void failThis() {
        fail("This test should not be run");
    }

}