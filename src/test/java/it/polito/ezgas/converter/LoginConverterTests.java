package it.polito.ezgas.converter;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.polito.ezgas.converter.LoginConverter;
import it.polito.ezgas.dto.LoginDto;
import it.polito.ezgas.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginConverterTests {

	@Test
	public void testToLoginDto1() {
		User user= new User();
		user.setPassword("12345");
		user.setEmail("user@user.com");
		user.setAdmin(true);
		user.setUserId(1);
		user.setUserName("user1");
		user.setReputation(0);
		LoginDto expected= new LoginDto(); 
		expected.setToken("token");
		expected.setEmail("user@user.com");
		expected.setAdmin(true);
		expected.setUserId(1);
		expected.setUserName("user1");
		expected.setReputation(0);
		LoginDto conv= LoginConverter.toLoginDto(user);
		assertEquals(conv.getReputation(),expected.getReputation());
		assertEquals(conv.getToken(),expected.getToken());
		assertEquals(conv.getAdmin(),expected.getAdmin());
		assertEquals(conv.getUserId(),expected.getUserId());
		assertEquals(conv.getUserName(),expected.getUserName());
		assertEquals(conv.getEmail(),expected.getEmail());
	}
	@Test
	public void testToLoginDto2() {
		User user= new User();
		user.setPassword("12345");
		user.setEmail("user@user.com");
		user.setAdmin(true);
		user.setUserId(null);
		user.setUserName("user1");
		user.setReputation(0);
		LoginDto expected= new LoginDto(); 
		expected.setToken("token");
		expected.setEmail("user@user.com");
		expected.setAdmin(true);
		expected.setUserName("user1");
		expected.setReputation(0);
		LoginDto conv= LoginConverter.toLoginDto(user);
		assertEquals(conv.getReputation(),expected.getReputation());
		assertEquals(conv.getToken(),expected.getToken());
		assertEquals(conv.getAdmin(),expected.getAdmin());
		assertEquals(conv.getUserId(),null);
		assertEquals(conv.getUserName(),expected.getUserName());
		assertEquals(conv.getEmail(),expected.getEmail());
	}
	@Test
	public void testToLoginDto3() {
		User user= new User();
		user.setPassword("54321");
		user.setEmail("user@user.com");
		user.setAdmin(true);
		user.setUserName("user1");
		user.setReputation(0);
		LoginDto expected= new LoginDto(); 
		expected.setToken("token35");
		expected.setEmail("user@user.com");
		expected.setAdmin(true);
		expected.setUserName("user1");
		expected.setReputation(0);
		LoginDto conv= LoginConverter.toLoginDto(user);
		assertEquals(conv.getReputation(),expected.getReputation());
		assertNotEquals(conv.getToken(),expected.getToken());//for now token is always equal to Token
		assertEquals(conv.getAdmin(),expected.getAdmin());
		assertEquals(conv.getUserId(),null);
		assertEquals(conv.getUserName(),expected.getUserName());
		assertEquals(conv.getEmail(),expected.getEmail());
	}
	@Test
	public void testToLoginDto4() {
		User user= new User();
		LoginDto expected= new LoginDto(); 
		LoginDto conv= LoginConverter.toLoginDto(user);
		assertEquals(conv.getReputation(),expected.getReputation());
		assertEquals(conv.getToken(),"token");
		assertEquals(conv.getAdmin(),expected.getAdmin());
		assertEquals(conv.getUserId(),expected.getUserId());
		assertEquals(conv.getUserName(),expected.getUserName());
		assertEquals(conv.getEmail(),expected.getEmail());
	}

}
