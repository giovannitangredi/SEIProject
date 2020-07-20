package it.polito.ezgas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.UserRepository;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@SpringBootTest
public class UserRepositoryTests {
	
	@Autowired
	UserRepository userRepository;
	@Before
	public void setUp() {
		userRepository.deleteAll();
	}

	@Test
	public void testFindOne() {
		User user = new User("user1", "password", "user1@user1.com", 0);
		
		userRepository.save(user);
		assertNotNull(userRepository.findOne(user.getUserId()));
	}
	
	@Test
	public void testFindAll() {
		User user1 = new User("user1", "password", "user1@user1.com", 0);
		User user2 = new User("user2", "password", "user2@user1.com", 0);
		
		userRepository.save(user1);
		userRepository.save(user2);
		List<User> result = userRepository.findAll();
		assertNotNull(result);
		assertEquals(2,result.size());
	}
	
	@Test
	public void testFindByEmail() {
		User user = new User("user1", "password", "user1@user1.com", 0);
		
		userRepository.save(user);
		List<User> result = userRepository.findByEmail(user.getEmail());
		assertNotNull(result);
		assertEquals(user.getEmail(),result.get(0).getEmail());
	}
	
	@Test
	public void testFindByEmailAndPassword() {
		User user = new User("user1", "password", "user1@user1.com", 0);
		
		userRepository.save(user);
		User result = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		assertNotNull(result);
		assertEquals(user.getEmail(),result.getEmail());
		assertEquals(user.getPassword(),result.getPassword());
	}
	
	@Test
	public void testExists() {
		User user = new User("user1", "password", "user1@user1.com", 0);
		
		userRepository.save(user);
		assertTrue(userRepository.exists(user.getUserId()));
	}
	
	@Test
	public void testSave() {
		User user = new User("user1", "password", "user1@user1.com", 0);
		
		userRepository.save(user);
		User result = userRepository.findOne(user.getUserId());
		assertNotNull(result);
		assertEquals(user.getUserName(), result.getUserName());
		assertEquals(user.getPassword(), result.getPassword());
		assertEquals(user.getEmail(), result.getEmail());
		assertEquals(user.getReputation(), result.getReputation());
		assertEquals(user.getAdmin(), result.getAdmin());
	}
	
	@Test
	public void testDelete() {
		User user = new User("user1", "password", "user1@user1.com", 0);
		
		userRepository.save(user);
		userRepository.delete(user.getUserId());
		assertNull(userRepository.findOne(user.getUserId()));
	}
}
