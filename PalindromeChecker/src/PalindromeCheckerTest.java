import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PalindromeCheckerTest {

	PalindromChecker testObject;

	@Before
	public void setUp() throws Exception {
		testObject = new PalindromChecker();
	}

	@After
	public void tearDown() throws Exception {

		testObject = null;
	}

	@Test
	public void testCreatePalindromeTestObject() throws Exception {

		assertNotNull(testObject);
	}
	@Test
	public void testSimplePalindromeMethod() throws Exception {

		assertTrue(testObject.isPalindrome("MOM"));
	}

	@Test
	public void testNotPalindrome() throws Exception {

		assertFalse(testObject.isPalindrome("Hi"));
	}
	@Test
	public void testNotPalindrome2() throws Exception {

		assertFalse(testObject.isPalindrome("Junit"));
	}
	
	
	@Test
	public void testNotPalindrome3() throws Exception {

		assertTrue(testObject.isPalindrome("malayalam"));
	}
}
