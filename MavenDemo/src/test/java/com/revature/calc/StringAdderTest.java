package com.revature.calc;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.logging.CalculatorException;
import com.revature.logging.StringAdder;

public class StringAdderTest {
	private static StringAdder sa;

	/*
	 * TDD: red-green refactoring: start with requirement, write test, build code to match
	 * 
	 * String Adder: compute Double values from comma-separated string
	 * 
	 * 1. calling add("") returns Double value of 0
	 * 2. calling add() with null returns 0
	 * 3. calling add() with > 2 arguments throws a CalculatorException
	 * 4. calling add() with incorrect characters throws a CalculatorException
	 * 5. calling add() with two comma-separated values returns sum of those values
	 * 
	 */
	
	@Rule
	public ExpectedException thrown = ExpectedException.none(); // if any exception is thrown, test will fail
	
	
	@BeforeClass
	public static void initializeStringAdder() {
		sa = new StringAdder();
	}
	
	@Test
	public void emptyStringReturnsZero() throws CalculatorException {
		assertEquals(0, sa.add(""), .0001); // floating-point assertions require an offset 
	}
	
	@Test 
	public void nullReturnsZero() throws CalculatorException {
		assertEquals(0, sa.add(null), .0001);
	}
	
	@Test
	public void moreThanTwoThrowsException() throws CalculatorException {
		thrown.expect(CalculatorException.class);
		sa.add("1,2,3");
	}
	
	@Test
	public void twoNumbersReturnsSum()throws CalculatorException{
		assertEquals(44.0,sa.add("22.0,22.0"),.0001);
	}
	
	@Test
	public void incorrectCharactersThrowsException() throws CalculatorException {
		thrown.expect(CalculatorException.class);
		sa.add("4,cat");
	}

}
