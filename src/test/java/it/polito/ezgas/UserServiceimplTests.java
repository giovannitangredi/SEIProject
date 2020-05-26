package it.polito.ezgas;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceimplTests {
	
	@Autowired
	private UserServiceimpl userService;
	
	@MockBean
	private UserRepository userRepositoryMock;
	
	private Integer userId = 1;
	private Integer invalidUserId = -1;
	
	private User userNoId;
	private User matchingUser;
	private ArrayList<User> matchingUserList;
	private ArrayList<User> emptyUserList;
	
	private User user1;
	private User user2;
	private User user3;
	private User user4;
	private User user5;
	private User user6;
	private ArrayList<User> userList;
	
	private IdPw credentials;
	private IdPw invalidCredentials;
	
	private Integer expectedIncrRep;
	private Integer expectedDecrRep;
	private User userOverRep;
	private User userUnderRep;
	
	@Before
	public void setUp() {
		
		userNoId = new User("user", "user", "user@example.com", 1);
		matchingUser = new User("userX", "userX", "user@example.com", 1);
		matchingUser.setUserId(10);
		matchingUserList = new ArrayList<User>();
		matchingUserList.add(matchingUser);
		emptyUserList = new ArrayList<User>();
		
		user1 = new User("user1", "user1", "user1@example.com", 4);
		user1.setUserId(1);
		user2 = new User("user2", "user2", "user2@example.com", 2);
		user2.setUserId(2);
		user3 = new User("user3", "user3", "user3@example.com", 2);
		user3.setUserId(3);
		user4 = new User("user4", "user4", "user4@example.com", 2);
		user4.setUserId(4);
		user5 = new User("user5", "user5", "user5@example.com", 2);
		user5.setUserId(5);
		user6 = new User("user6", "user6", "user6@example.com", 2);
		user6.setUserId(6);
		
		userList = new ArrayList<User>();
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		userList.add(user6);
		
		credentials = new IdPw(user1.getEmail(), user1.getPassword());
		invalidCredentials = new IdPw(user1.getEmail(), "incorrect pw");
		
		expectedIncrRep = user1.getReputation() + 1;
		expectedDecrRep = user1.getReputation() - 1;
		userOverRep = new User("userOver", "userOver", "userover@example.com", 5);
		userOverRep.setUserId(15);
		userUnderRep = new User("userUnder", "userUnder", "userunder@example.com", -5);
		userUnderRep.setUserId(16);
	}

	@Test
	public void testGetUserById() throws InvalidUserException {
		when(userRepositoryMock.findOne(anyInt())).thenReturn(user1);
		UserDto userDto = userService.getUserById(userId);
		assertEquals(userId, userDto.getUserId());
		
		when(userRepositoryMock.findOne(anyInt())).thenReturn(null);
		UserDto nullUserDto = userService.getUserById(userId);
		assertNull(nullUserDto);
		
		assertThrows(InvalidUserException.class, () -> userService.getUserById(invalidUserId));
		assertThrows(InvalidUserException.class, () -> userService.getUserById(null));
	}

	@Test
	public void testSaveUser() {
		when(userRepositoryMock.findOne(anyInt())).thenReturn(user1);
		when(userRepositoryMock.save(any(User.class))).thenReturn(user1);
		UserDto savedUserDto = userService.saveUser(UserConverter.toUserDto(user1));
		assertEquals(user1.getUserId(), savedUserDto.getUserId());
		assertTrue(savedUserDto.getUserName().equals(user1.getUserName()));
		assertTrue(savedUserDto.getPassword().equals(user1.getPassword()));
		assertTrue(savedUserDto.getEmail().equals(user1.getEmail()));
		assertEquals(user1.getReputation(), savedUserDto.getReputation());
		assertEquals(user1.getAdmin(), savedUserDto.getAdmin());
		
		when(userRepositoryMock.findOne(anyInt())).thenReturn(user2);
		when(userRepositoryMock.findByEmail(anyString())).thenReturn(matchingUserList);
		UserDto nullUserDto = userService.saveUser(UserConverter.toUserDto(user1));
		assertNull(nullUserDto);
		
		when(userRepositoryMock.findOne(anyInt())).thenReturn(user2);
		when(userRepositoryMock.findByEmail(anyString())).thenReturn(emptyUserList);
		UserDto savedUserDto2 = userService.saveUser(UserConverter.toUserDto(user1));
		assertEquals(user1.getUserId(), savedUserDto2.getUserId());
		assertTrue(savedUserDto2.getUserName().equals(user1.getUserName()));
		assertTrue(savedUserDto2.getPassword().equals(user1.getPassword()));
		assertTrue(savedUserDto2.getEmail().equals(user1.getEmail()));
		assertEquals(user1.getReputation(), savedUserDto2.getReputation());
		assertEquals(user1.getAdmin(), savedUserDto2.getAdmin());
		
		when(userRepositoryMock.findByEmail(anyString())).thenReturn(matchingUserList);
		UserDto nullUserDto2 = userService.saveUser(UserConverter.toUserDto(userNoId));
		assertNull(nullUserDto2);
		
		when(userRepositoryMock.findByEmail(anyString())).thenReturn(emptyUserList);
		when(userRepositoryMock.save(any(User.class))).thenReturn(userNoId);
		UserDto savedNewUserDto = userService.saveUser(UserConverter.toUserDto(userNoId));
		assertEquals(userNoId.getUserId(), savedNewUserDto.getUserId());
		assertTrue(savedNewUserDto.getUserName().equals(userNoId.getUserName()));
		assertTrue(savedNewUserDto.getPassword().equals(userNoId.getPassword()));
		assertTrue(savedNewUserDto.getEmail().equals(userNoId.getEmail()));
		assertEquals(userNoId.getReputation(), savedNewUserDto.getReputation());
		assertEquals(userNoId.getAdmin(), savedNewUserDto.getAdmin());
	}

	@Test
	public void testGetAllUsers() {
		when(userRepositoryMock.findAll()).thenReturn(userList);
		List<UserDto> userDtos = userService.getAllUsers();
		assertEquals(userList.size(), userDtos.size());
		
		when(userRepositoryMock.findAll()).thenReturn(null);
		List<UserDto> emptyUserDtos = userService.getAllUsers();
		assertEquals(emptyUserList.size(), emptyUserDtos.size());
	}

	@Test
	public void testDeleteUser() throws InvalidUserException {
		doNothing().when(userRepositoryMock).delete(anyInt());
		
		when(userRepositoryMock.exists(anyInt())).thenReturn(true).thenReturn(false);
		assertTrue(userService.deleteUser(userId));
		when(userRepositoryMock.exists(anyInt())).thenReturn(false);
		assertFalse(userService.deleteUser(userId));
		when(userRepositoryMock.exists(anyInt())).thenReturn(true).thenReturn(true);
		assertFalse(userService.deleteUser(userId));
		
		assertThrows(InvalidUserException.class, () -> userService.deleteUser(invalidUserId));
		assertThrows(InvalidUserException.class, () -> userService.deleteUser(null));
	}
	
	@Test
	public void testLogin() throws InvalidLoginDataException {
		when(userRepositoryMock.findByEmailAndPassword(anyString(), eq(user1.getPassword()))).thenReturn(user1);
		LoginDto loginDto = userService.login(credentials);
		assertTrue(loginDto.getEmail().equals(user1.getEmail()));
		
		assertThrows(InvalidLoginDataException.class, () -> userService.login(invalidCredentials));
		
		assertThrows(InvalidLoginDataException.class, () -> userService.login(null));
	}

	@Test
	public void testIncreaseUserReputation() throws InvalidUserException {
		when(userRepositoryMock.findOne(anyInt())).thenReturn(user1);
		when(userRepositoryMock.save(any(User.class))).thenReturn(user1);
		Integer reputation = userService.increaseUserReputation(userId);
		assertEquals(expectedIncrRep, reputation);
		
		when(userRepositoryMock.findOne(anyInt())).thenReturn(userOverRep);
		when(userRepositoryMock.save(any(User.class))).thenReturn(userOverRep);
		Integer overReputation = userService.increaseUserReputation(userId);
		assertEquals(overReputation, userOverRep.getReputation());
		
		when(userRepositoryMock.findOne(anyInt())).thenReturn(null);
		Integer nullReputation = userService.increaseUserReputation(userId);
		assertNull(nullReputation);
		
		assertThrows(InvalidUserException.class, () -> userService.increaseUserReputation(invalidUserId));
		assertThrows(InvalidUserException.class, () -> userService.increaseUserReputation(null));
	}
	
	@Test
	public void testDecreaseUserReputation() throws InvalidUserException {
		when(userRepositoryMock.findOne(anyInt())).thenReturn(user1);
		when(userRepositoryMock.save(any(User.class))).thenReturn(user1);
		Integer reputation = userService.decreaseUserReputation(userId);
		assertEquals(expectedDecrRep, reputation);
		
		when(userRepositoryMock.findOne(anyInt())).thenReturn(userUnderRep);
		when(userRepositoryMock.save(any(User.class))).thenReturn(userUnderRep);
		Integer underReputation = userService.decreaseUserReputation(userId);
		assertEquals(underReputation, userUnderRep.getReputation());
		
		when(userRepositoryMock.findOne(anyInt())).thenReturn(null);
		Integer nullReputation = userService.decreaseUserReputation(userId);
		assertNull(nullReputation);
		
		assertThrows(InvalidUserException.class, () -> userService.decreaseUserReputation(invalidUserId));
		assertThrows(InvalidUserException.class, () -> userService.decreaseUserReputation(null));
	}

}
