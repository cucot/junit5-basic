package com.cucot;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    static MathUtils mathUtils;

    @BeforeAll
    static void initMathUtil() {
        mathUtils = new MathUtils();
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