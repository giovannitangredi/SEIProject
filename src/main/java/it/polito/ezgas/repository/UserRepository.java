package it.polito.ezgas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.polito.ezgas.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmailAndPassword(String email,String password);
	List<User> findByEmail(String email);

}
