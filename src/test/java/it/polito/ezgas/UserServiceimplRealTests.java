package it.polito.ezgas;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import exception.InvalidLoginDataException;
import exception.InvalidUserException;

import it.polito.ezgas.converter.UserConverter;
import it.polito.ezgas.dto.IdPw;
import it.polito.ezgas.dto.LoginDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.impl.UserServiceimpl;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@SpringBootTest
public class UserServiceimplRealTests {
	
	@Autowired
	private UserServiceimpl userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Before
	public void setUp() {
		userRepository.deleteAll();
	}

	@Test
	public void testGetUserById() throws InvalidUserException {
		User user = new User("user1", "user1", "user1@example.com", 4);
		user = userRepository.save(user);
		UserDto userDto = userService.getUserById(user.getUserId());
		assertNotNull(userDto);
		assertEquals(user.getUserId(), userDto.getUserId());
	}

	@Test
	public void testSaveUser() {
		User user = new User("user1", "user1", "user1@example.com", 4);
		user = userRepository.save(user);
		user.setEmail("user1.user1@example.com");
		UserDto savedUserDto = userService.saveUser(UserConverter.toUserDto(user)); // Update user's email
		assertTrue(savedUserDto.getEmail().equals(user.getEmail()));
		
		User user2 = new User("user2", "user2", "user2@example.com", 4);
		userRepository.save(user2);
		user.setEmail(user2.getEmail());
		UserDto nullUserDto = userService.saveUser(UserConverter.toUserDto(user)); // Try to update user's email with another existing user's email 
		assertNull(nullUserDto);
		
		User user3 = new User("user3", "user3", "user3@example.com", 1);
		UserDto savedNewUserDto = userService.saveUser(UserConverter.toUserDto(user3)); // Add new user
		assertNotNull(savedNewUserDto.getUserId());
		assertTrue(savedNewUserDto.getUserName().equals(user3.getUserName()));
		assertTrue(savedNewUserDto.getPassword().equals(user3.getPassword()));
		assertTrue(savedNewUserDto.getEmail().equals(user3.getEmail()));
		assertEquals(user3.getReputation(), savedNewUserDto.getReputation());
		assertEquals(user3.getAdmin(), savedNewUserDto.getAdmin());
		
		User user4 = new User("user4", "user4", user.getEmail(), 4);
		UserDto nullUser4Dto = userService.saveUser(UserConverter.toUserDto(user4)); // Try to add new user with same email as an existing user
		assertNull(nullUser4Dto);
	}

	@Test
	public void testGetAllUsers() {
		User user1 = new User("user1", "user1", "user1@example.com", 4);
		User user2 = new User("user2", "user2", "user2@example.com", 2);
		User user3 = new User("user3", "user3", "user3@example.com", 2);
		User user4 = new User("user4", "user4", "user4@example.com", 2);
		User user5 = new User("user5", "user5", "user5@example.com", 2);
		
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		userRepository.save(user5);
		
		List<UserDto> userDtoList = userService.getAllUsers();
		assertEquals(userList.size(), userDtoList.size());
	}

	@Test
	public void testDeleteUser() throws InvalidUserException {
		User user = new User("user1", "user1", "user1@example.com", 4);
		
		user = userRepository.save(user);
		assertTrue(userService.deleteUser(user.getUserId()));
		
		Integer nonExistingUserId = 21;
		assertFalse(userService.deleteUser(nonExistingUserId));
	}
	
	@Test
	public void testLogin() throws InvalidLoginDataException {
		User user = new User("user1", "user1", "user1@example.com", 4);
		user = userRepository.save(user);
		IdPw credentials = new IdPw(user.getEmail(), user.getPassword());
		LoginDto loginDto = userService.login(credentials);
		assertTrue(loginDto.getEmail().equals(user.getEmail()));
	}

	@Test
	public void testIncreaseUserReputation() throws InvalidUserException {
		User user = new User("user1", "user1", "user1@example.com", 4);
		user = userRepository.save(user);
		Integer expectedRep = user.getReputation() + 1;
		Integer reputation = userService.increaseUserReputation(user.getUserId());
		assertEquals(expectedRep, reputation);
		userRepository.delete(user.getUserId());
		assertThrows(InvalidUserException.class, () -> userService.increaseUserReputation(1));
	}
	
	@Test
	public void testDecreaseUserReputation() throws InvalidUserException {
		User user = new User("user1", "user1", "user1@example.com", 4);
		user = userRepository.save(user);
		Integer expectedRep = user.getReputation() - 1;
		Integer reputation = userService.decreaseUserReputation(user.getUserId());
		assertEquals(expectedRep, reputation);
		userRepository.delete(user.getUserId());
		assertThrows(InvalidUserException.class, () -> userService.increaseUserReputation(1));
	}

}
