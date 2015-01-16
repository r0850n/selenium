import static org.junit.Assert.*;
import helpers.Validation;
import model.Message;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ValidationTest {
	
	
	Validation val;
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		val=new Validation();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	
	public void validatorTest(){
		assertTrue(val.getEmail().isValid("aaa@wp.pl"));
		assertTrue(val.getEmail().isValid("a.aa@wp.pl"));
		assertFalse(val.getEmail().isValid("aa.a11@a"));
		assertTrue(val.getMmsNumber().isValid("111 222 333"));
		assertTrue(val.getMmsNumber().isValid("111222333"));
		assertTrue(val.getMmsNumber().isValid("111 222333"));
		assertTrue(val.getMmsNumber().isValid("111222 333"));
		assertFalse(val.getMmsNumber().isValid("11222333"));
		
	}

}
