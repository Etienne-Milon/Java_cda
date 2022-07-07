package fr.em.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.em.bases.FizzBuzz;

class FizzBuzzTest {

	@Test
	void testFizzBuzz() {
		assertEquals("0",FizzBuzz.fizzBuzz(0));
		assertEquals("1",FizzBuzz.fizzBuzz(1));
		assertEquals("2",FizzBuzz.fizzBuzz(2));
		assertEquals("Fizz",FizzBuzz.fizzBuzz(3));
		assertEquals("4",FizzBuzz.fizzBuzz(4));
		assertEquals("Buzz",FizzBuzz.fizzBuzz(5));
		assertEquals("Fizz",FizzBuzz.fizzBuzz(6));
		assertEquals("Buzz",FizzBuzz.fizzBuzz(10));
		assertEquals("FizzBuzz",FizzBuzz.fizzBuzz(15));
	}

}
