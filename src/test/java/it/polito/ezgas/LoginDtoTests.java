package it.polito.ezgas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import it.polito.ezgas.dto.LoginDto;


public class LoginDtoTests {
	@Test
	public void testGetUserId() {
		LoginDto instance = new LoginDto();
	    Integer expResult = 100;
	    instance.setUserId(100);
	    Integer result = instance.getUserId();
	    assertEquals(expResult, result);
	}
	
	@Test
	public void testSetUserId() {
	    Integer value = 100;
	    LoginDto instance = new LoginDto();
	    instance.setUserId(value);
	    assertEquals(instance.getUserId(), value);
	}

	@Test
	public void testGetUserName() {
		LoginDto instance = new LoginDto();
	    String expResult = "Test";
	    instance.setUserName("Test");
	    String result = instance.getUserName();
	    assertEquals(expResult, result);
    }

	@Test
    public void testSetUserName() {
    	String value = "Test";
    	LoginDto instance = new LoginDto();
	    instance.setUserName(value);
	    assertEquals(instance.getUserName(), value);
    }
    
	@Test
    public void testGetEmail() {
		LoginDto instance = new LoginDto();
	    String expResult = "Test";
	    instance.setEmail("Test");
	    String result = instance.getEmail();
	    assertEquals(expResult, result);
    }
    
	@Test
    public void testSetEmail() {
    	String value = "Test";
    	LoginDto instance = new LoginDto();
	    instance.setEmail(value);
	    assertEquals(instance.getEmail(), value);
    }
    
	@Test
    public void testGetReputation() {
		LoginDto instance = new LoginDto();
	    Integer expResult = 100;
	    instance.setReputation(100);
	    Integer result = instance.getReputation();
	    assertEquals(expResult, result);
	}

	@Test
	public void testSetReputation() {
		Integer value = 100;
		LoginDto instance = new LoginDto();
	    instance.setReputation(value);
	    assertEquals(instance.getReputation(), value);
	}
	
	@Test
	public void testGetToken() {
		String value = "Test";
		LoginDto instance = new LoginDto();
		instance.setToken(value);
		assertEquals(value, instance.getToken());
	}
	
	@Test
	public void testSetToken() {
		LoginDto instance = new LoginDto();
	    String expResult = "Test";
	    instance.setToken("Test");
	    String result = instance.getToken();
	    assertEquals(expResult, result);
	}
	
	@Test
    public void testGetAdmin() {
		LoginDto instance = new LoginDto();
	    Boolean expResult = true;
	    instance.setAdmin(true);
	    Boolean result = instance.getAdmin();
	    assertEquals(expResult, result);
    }
    
	@Test
    public void testSetAdmin() {
    	Boolean value = true;
    	LoginDto instance = new LoginDto();
	    instance.setAdmin(value);
	    assertEquals(instance.getAdmin(), value);
    }
}
