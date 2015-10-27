package lesson151027;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {
	
	private FizzBuzz fb;

	@Before
	public void setup() {
		fb = new FizzBuzz();
	}

	@Test
	public void testCreate() {
		assertTrue(fb instanceof FizzBuzz);
	}
	
	@Test
	public void call() throws Exception {
		String result = fb.check(10);
		assertTrue(result instanceof String);
	}
	
	@Test
	public void fizz() throws Exception {
		assertEquals("fizz", fb.check(3));
		assertEquals("fizz", fb.check(6));
		assertNotEquals("fizz", fb.check(1));
	}

	@Test
	public void buzz() throws Exception {
		assertEquals("buzz", fb.check(5));
		assertEquals("buzz", fb.check(10));
		assertNotEquals("buzz", fb.check(1));
	}
	
	@Test
	public void fizzbuzz() throws Exception {
		assertEquals("fizzbuzz", fb.check(15));
		assertEquals("fizzbuzz", fb.check(90));
		assertNotEquals("fizzbuzz", fb.check(3));
		assertNotEquals("fizzbuzz", fb.check(5));
		assertNotEquals("fizzbuzz", fb.check(1));
	}

	@Test
	public void number() throws Exception {
		assertEquals("1", fb.check(1));
		assertEquals("14", fb.check(14));
		assertNotEquals("3", fb.check(3));
		assertNotEquals("5", fb.check(5));
		assertNotEquals("15", fb.check(15));
	}
	
}
