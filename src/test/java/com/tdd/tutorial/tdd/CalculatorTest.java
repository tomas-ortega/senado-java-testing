package com.tdd.tutorial.tdd;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
	
	@AfterEach
	void doAfterEachTest() {
		System.out.println("Task after One Test!!!");
	}
	
	@AfterAll
	static void doAfterAll() {
		System.out.println("Task After All!");
	}
}
