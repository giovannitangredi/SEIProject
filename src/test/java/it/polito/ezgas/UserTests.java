package it.polito.ezgas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.polito.ezgas.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {
	
	@Test
	public void testGetUserId() {
		User instance = new User();
	    Integer expResult = 100;
	    instance.setUserId(100);
	    Integer result = instance.getUserId();
	    assertEquals(expResult, result);
	}
	
	@Test
	public void testSetUserId() {
	    Integer value = 100;
	    User instance = new User();
	    instance.setUserId(value);
	    assertEquals(instance.getUserId(), value);
	}

	@Test
	public void testGetUserName() {
		User instance = new User();
	    String expResult = "Test";
	    instance.setUserName("Test");
	    String result = instance.getUserName();
	    assertEquals(expResult, result);
    }

	@Test
    public void testSetUserName() {
    	String value = "Test";
	    User instance = new User();
	    instance.setUserName(value);
	    assertEquals(instance.getUserName(), value);
    }
    
	@Test
    public void testGetPassword() {
    	User instance = new User();
	    String expResult = "Test";
	    instance.setPassword("Test");
	    String result = instance.getPassword();
	    assertEquals(expResult, result);
    }
    
	@Test
    public void testSetPassword() {
    	String value = "Test";
	    User instance = new User();
	    instance.setPassword(value);
	    assertEquals(instance.getPassword(), value);
    }
    
	@Test
    public void testGetEmail() {
    	User instance = new User();
	    String expResult = "Test";
	    instance.setEmail("Test");
	    String result = instance.getEmail();
	    assertEquals(expResult, result);
    }
    
	@Test
    public void testSetEmail() {
    	String value = "Test";
	    User instance = new User();
	    instance.setEmail(value);
	    assertEquals(instance.getEmail(), value);
    }
    
	@Test
    public void testGetReputation() {
    	User instance = new User();
	    Integer expResult = 100;
	    instance.setReputation(100);
	    Integer result = instance.getReputation();
	    assertEquals(expResult, result);
	}

	@Test
	public void testSetReputation() {
		Integer value = 100;
	    User instance = new User();
	    instance.setReputation(value);
	    assertEquals(instance.getReputation(), value);
	}
    
	@Test
    public void testGetAdmin() {
    	User instance = new User();
	    Boolean expResult = true;
	    instance.setAdmin(true);
	    Boolean result = instance.getAdmin();
	    assertEquals(expResult, result);
    }
    
	@Test
    public void testSetAdmin() {
    	Boolean value = true;
	    User instance = new User();
	    instance.setAdmin(value);
	    assertEquals(instance.getAdmin(), value);
    }
	@Test
    public void testConstructor() {
	    User instance = new User("admin", "12345", "admin@admin.com",5);
	    assertEquals(instance.getAdmin(), null);
	    assertEquals(instance.getEmail(),"admin@admin.com");
	    assertEquals(instance.getUserId(),null);
	    assertEquals(instance.getPassword(),"12345");
	    assertEquals(instance.getUserName(),"admin");
	    assertEquals(instance.getReputation(),5);
    }
}