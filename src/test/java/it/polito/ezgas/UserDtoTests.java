package it.polito.ezgas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import it.polito.ezgas.dto.UserDto;

public class UserDtoTests {
	@Test
	public void testGetUserId() {
		UserDto instance = new UserDto();
	    Integer expResult = 100;
	    instance.setUserId(100);
	    Integer result = instance.getUserId();
	    assertEquals(expResult, result);
	}
	
	@Test
	public void testSetUserId() {
	    Integer value = 100;
	    UserDto instance = new UserDto();
	    instance.setUserId(value);
	    assertEquals(instance.getUserId(), value);
	}

	@Test
	public void testGetUserName() {
		UserDto instance = new UserDto();
	    String expResult = "Test";
	    instance.setUserName("Test");
	    String result = instance.getUserName();
	    assertEquals(expResult, result);
    }

	@Test
    public void testSetUserName() {
    	String value = "Test";
	    UserDto instance = new UserDto();
	    instance.setUserName(value);
	    assertEquals(instance.getUserName(), value);
    }
    
	@Test
    public void testGetPassword() {
    	UserDto instance = new UserDto();
	    String expResult = "Test";
	    instance.setPassword("Test");
	    String result = instance.getPassword();
	    assertEquals(expResult, result);
    }
    
	@Test
    public void testSetPassword() {
    	String value = "Test";
	    UserDto instance = new UserDto();
	    instance.setPassword(value);
	    assertEquals(instance.getPassword(), value);
    }
    
	@Test
    public void testGetEmail() {
    	UserDto instance = new UserDto();
	    String expResult = "Test";
	    instance.setEmail("Test");
	    String result = instance.getEmail();
	    assertEquals(expResult, result);
    }
    
	@Test
    public void testSetEmail() {
    	String value = "Test";
	    UserDto instance = new UserDto();
	    instance.setEmail(value);
	    assertEquals(instance.getEmail(), value);
    }
    
	@Test
    public void testGetReputation() {
    	UserDto instance = new UserDto();
	    Integer expResult = 100;
	    instance.setReputation(100);
	    Integer result = instance.getReputation();
	    assertEquals(expResult, result);
	}

	@Test
	public void testSetReputation() {
		Integer value = 100;
	    UserDto instance = new UserDto();
	    instance.setReputation(value);
	    assertEquals(instance.getReputation(), value);
	}
    
	@Test
    public void testGetAdmin() {
    	UserDto instance = new UserDto();
	    Boolean expResult = true;
	    instance.setAdmin(true);
	    Boolean result = instance.getAdmin();
	    assertEquals(expResult, result);
    }
    
	@Test
    public void testSetAdmin() {
    	Boolean value = true;
	    UserDto instance = new UserDto();
	    instance.setAdmin(value);
	    assertEquals(instance.getAdmin(), value);
    }
}
