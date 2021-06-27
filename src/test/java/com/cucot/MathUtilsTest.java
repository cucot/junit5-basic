package com.cucot;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Testing Math Utils")
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
    @DisplayName("This test will be disabled")
    @Disabled
    void failThis() {
        fail("This test should not be run");
    }

    @Test
    @DisplayName("This test will be disabled on LINUX")
    @DisabledOnOs(OS.LINUX)
    void disabledOnLinux() {
        fail("Inprogress");
    }

    @Test
    @DisplayName("This test will be disabled on WINDOWS")
    @DisabledOnOs(OS.WINDOWS)
    void disabledOnWindows() {
        fail("Inprogress on windows");
    }

    @Test
    @DisplayName("Test will be enabled on Linux, which lead to a fail")
    @EnabledOnOs(OS.LINUX)
    void enabledOnLinux() {
        fail();
    }

    @Test
    @DisplayName("Programmatically running the test")
    void skipthis() {
        assumeTrue(false);
        fail("This will fail if run through this");
    }

    @RepeatedTest(3)
    void checkMe(RepetitionInfo repetitionInfo) {
        System.out.println("Testing " + repetitionInfo.getCurrentRepetition() + " time");
    }

    @Nested
    @DisplayName("Testing add function")
    class AddTest {
        @Test
        @DisplayName("Normal Add execution, neither overflow nor underflow")
        void addNormal() {
            assertAll(
                    () -> assertEquals(-10, mathUtils.add(-3, -7), String.format("%d + %d should return %d", -3, -7, -10)),
                    () -> assertEquals(-50, mathUtils.add(-100, 50)),
                    () -> assertEquals(0, mathUtils.add(-500, 500), () -> String.format("%d + %d should return %d", -3, -7, -10))
            );
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
    }
}