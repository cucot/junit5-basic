package com.cucot;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

    public MathUtilsTest() {
        System.out.println("One instance is created");
    }

    static MathUtils mathUtils;

    @BeforeAll
    static void initMathUtil() {
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
        System.out.println("This should be used for member variable instantiation");
    }

    @Test
    void addNormal() {
        assertEquals(3, mathUtils.add(1, 2));
    }

    @Test
    void addExceedMaxInteger() {
        assertThrows(RuntimeException.class, () -> mathUtils.add(Integer.MAX_VALUE, 1), "Adding with overflow will lead to incorrect calculation and should be prevent. Consider to use long instead");
    }

    @Test
    void addExceedMinInteger() {
        assertThrows(RuntimeException.class, () -> mathUtils.add(Integer.MIN_VALUE, -1), "Result < Integer.MIN_VALUE will lead to overflow, cause unintended incorrect calculation");
    }

}