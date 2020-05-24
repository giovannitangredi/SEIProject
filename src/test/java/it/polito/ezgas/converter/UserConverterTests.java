package it.polito.ezgas.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.polito.ezgas.converter.UserConverter;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserConverterTests {

	@Test
	public void testToUserDto1() {
		User user=new User();
		user.setAdmin(false);
		user.setEmail("user@user.com");
		user.setUserId(1);
		user.setUserName("user1");
		user.setReputation(5);
		user.setPassword("12345");
		UserDto expected=new UserDto();
		expected.setAdmin(false);
		expected.setEmail("user@user.com");
		expected.setUserId(1);
		expected.setUserName("user1");
		expected.setReputation(5);
		expected.setPassword("12345");
		UserDto converted=UserConverter.toUserDto(user);
		assertEquals(expected.getAdmin(),converted.getAdmin());
		assertEquals(expected.getEmail(),converted.getEmail());
		assertEquals(expected.getPassword(),converted.getPassword());
		assertEquals(expected.getReputation(),converted.getReputation());
		assertEquals(expected.getUserId(),converted.getUserId());
		assertEquals(expected.getUserName(),converted.getUserName());
	}
	@Test
	public void testToUserDto2() {
		User user=new User();
		user.setAdmin(false);
		user.setEmail("user@user.com");
		user.setUserId(null);
		user.setUserName("user1");
		user.setReputation(5);
		user.setPassword("12345");
		UserDto expected=new UserDto();
		expected.setAdmin(false);
		expected.setEmail("user@user.com");
		expected.setUserId(null);
		expected.setUserName("user1");
		expected.setReputation(5);
		expected.setPassword("12345");
		UserDto converted=UserConverter.toUserDto(user);
		assertEquals(expected.getAdmin(),converted.getAdmin());
		assertEquals(expected.getEmail(),converted.getEmail());
		assertEquals(expected.getPassword(),converted.getPassword());
		assertEquals(expected.getReputation(),converted.getReputation());
		assertEquals(expected.getUserId(),converted.getUserId());
		assertEquals(expected.getUserName(),converted.getUserName());
	}
	@Test
	public void testToUserDto3() {
		User user=new User();
		user.setAdmin(null);
		user.setEmail("user@user.com");
		user.setUserId(1);
		user.setUserName("user1");
		user.setReputation(5);
		user.setPassword("12345");
		UserDto expected=new UserDto();
		expected.setEmail("user@user.com");
		expected.setUserId(1);
		expected.setUserName("user1");
		expected.setReputation(5);
		expected.setPassword("12345");
		UserDto converted=UserConverter.toUserDto(user);
		assertEquals(null,converted.getAdmin());
		assertEquals(expected.getEmail(),converted.getEmail());
		assertEquals(expected.getPassword(),converted.getPassword());
		assertEquals(expected.getReputation(),converted.getReputation());
		assertEquals(expected.getUserId(),converted.getUserId());
		assertEquals(expected.getUserName(),converted.getUserName());
	}

	@Test
	public void testToUser1() {
		UserDto userDto=new UserDto();
		userDto.setAdmin(false);
		userDto.setEmail("user@user.com");
		userDto.setUserId(1);
		userDto.setUserName("user1");
		userDto.setReputation(5);
		userDto.setPassword("12345");
		User expected=new User();
		expected.setAdmin(false);
		expected.setEmail("user@user.com");
		expected.setUserId(1);
		expected.setUserName("user1");
		expected.setReputation(5);
		expected.setPassword("12345");
		User converted=UserConverter.toUser(userDto);
		assertEquals(expected.getAdmin(),converted.getAdmin());
		assertEquals(expected.getEmail(),converted.getEmail());
		assertEquals(expected.getPassword(),converted.getPassword());
		assertEquals(expected.getReputation(),converted.getReputation());
		assertEquals(expected.getUserId(),converted.getUserId());
		assertEquals(expected.getUserName(),converted.getUserName());
	}
	@Test
	public void testToUser2() {
		UserDto userDto=new UserDto();
		userDto.setAdmin(false);
		userDto.setEmail("user@user.com");
		userDto.setUserId(1);
		userDto.setUserName(null);
		userDto.setReputation(5);
		userDto.setPassword("12345");
		User expected=new User();
		expected.setAdmin(false);
		expected.setEmail("user@user.com");
		expected.setUserId(1);
		expected.setUserName(null);
		expected.setReputation(5);
		expected.setPassword("12345");
		User converted=UserConverter.toUser(userDto);
		assertEquals(expected.getAdmin(),converted.getAdmin());
		assertEquals(expected.getEmail(),converted.getEmail());
		assertEquals(expected.getPassword(),converted.getPassword());
		assertEquals(expected.getReputation(),converted.getReputation());
		assertEquals(expected.getUserId(),converted.getUserId());
		assertEquals(expected.getUserName(),converted.getUserName());
	}
	@Test
	public void testToUser3() {
		UserDto userDto=new UserDto();
		User expected=new User();
		User converted=UserConverter.toUser(userDto);
		assertEquals(expected.getAdmin(),converted.getAdmin());
		assertEquals(expected.getEmail(),converted.getEmail());
		assertEquals(expected.getPassword(),converted.getPassword());
		assertEquals(expected.getReputation(),converted.getReputation());
		assertEquals(expected.getUserId(),converted.getUserId());
		assertEquals(expected.getUserName(),converted.getUserName());
	}
}
