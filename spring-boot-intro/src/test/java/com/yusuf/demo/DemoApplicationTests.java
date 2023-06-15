package com.yusuf.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DemoApplicationTests {
    private final Calculator underTest = new Calculator();

    @Test
    void itShouldAAddTwoNumbers() {
//        Given
        int firstNumber = 0;
        int secondNumber = 5;

//        When
        int result = underTest.add(firstNumber, secondNumber);

//        Expected
        assertThat(result).isEqualTo(5);
    }

    static class Calculator {
        public int add(int firstNumber, int secondNumber) {
            return firstNumber + secondNumber;
        }
    }

}
