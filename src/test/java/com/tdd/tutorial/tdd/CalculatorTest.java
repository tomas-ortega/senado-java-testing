package com.tdd.tutorial.tdd;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Class: CalculatorTest")
public class CalculatorTest {
	
	@BeforeAll
	static void doBeforeAll() {
		System.out.println("Task Before All!!!");
	}
	
	@BeforeEach
	void doBeforeEachTest() {
		System.out.println("Task Before One Test!!!");
	}
	
	@Test
	@Disabled("Fix feature 4365")
	@DisplayName("Test: testDivideTwoIntegerNumbers")
	public void testDivideTwoIntegerNumbers() {
		Integer number1 = 6;
		Integer number2 = 6;
		Integer result = null;
		Integer expectedValue = 1;
		
		Calculator calculatorBusiness = new Calculator();
		result = calculatorBusiness.divide(number1, number2);
		
		assertTrue(result != null);
		assertTrue(result.equals(expectedValue));
	}
	
	@Test
	@DisplayName("Test: testDivideTwoIntegerNegativeNumbers")
	public void testDivideTwoIntegerNegativeNumbers() {
		Integer number1 = -6;
		Integer number2 = -6;
		Integer result = null;
		Integer expectedValue = 1;
		
		Calculator calculatorBusiness = new Calculator();
		result = calculatorBusiness.divide(number1, number2);
		
		assertTrue(result != null);
		assertTrue(result.equals(expectedValue));
	}
	
	@Test
	public void testDivideByZero() {
		Integer number1 = 0;
		Integer number2 = 0;
		
		Calculator calculatorBusiness = new Calculator();
		
		assertThrows(ArithmeticException.class, () -> {
			calculatorBusiness.divide(number1, number2);
		});
	}
	
	@Test
	@Tag("development")
	@Tag("production")
	void testCalculateBill() {
		assertTrue(1 == 1);
	}

	@Test
	@Tag("production")
	void testCalculateBillWithVat() {
		assertTrue(2 == 2);
	}
	
	@Test
	void testWithHamCrest() {
		Integer number1 = 2;
		Integer number2 = 3;
		
		assertThat(4, is(not(number1)));
	}
	
	@Test
	void testWithHamCrestHasProperty() {
		Integer number1 = 2;
		Integer number2 = 3;
		
		PairNumberDTO pairNumber = new PairNumberDTO(number1, number2);
		
		assertThat(pairNumber, hasProperty("number1"));
	}
	
	
	@AfterEach
	void doAfterEachTest() {
		System.out.println("Task after One Test!!!");
	}
	
	@AfterAll
	static void doAfterAll() {
		System.out.println("Task After All!");
	}
}
