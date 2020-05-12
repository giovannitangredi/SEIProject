package it.polito.ezgas.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.InvalidLoginDataException;
import exception.InvalidUserException;
import it.polito.ezgas.converter.LoginConverter;
import it.polito.ezgas.converter.UserConverter;
import it.polito.ezgas.dto.IdPw;
import it.polito.ezgas.dto.LoginDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.UserService;

/**
 * Created by softeng on 27/4/2020.
 */
@Service
public class UserServiceimpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDto getUserById(Integer userId) throws InvalidUserException {
		// TODO Auto-generated method stub
		User user;
		if(userId==null || userId<0)
			throw new InvalidUserException("ERROR:ID IS NOT VALID!");
		user=userRepository.findOne(userId);
		if(user==null)
			return null;
		return UserConverter.toUserDto(user);
	}

	@Override
	public UserDto saveUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user=UserConverter.toUser(userDto);
		if(userRepository.findByEmail(user.getEmail()).size()>0)
			return null;
		if(userRepository.exists(user.getUserId()))
			return null;
		user=userRepository.save(user);
		return UserConverter.toUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> listUser;
		listUser=userRepository.findAll();
		if(listUser==null)
			return new ArrayList<UserDto>();
		return listUser.stream()
				.map(u ->UserConverter.toUserDto(u))//convert to UserDto
				.collect(Collectors.toList());
	}

	@Override
	public Boolean deleteUser(Integer userId) throws InvalidUserException {
		// TODO Auto-generated method stub
		if(userId==null || userId<0)
			throw new InvalidUserException("ERROR:ID IS NOT VALID!");
		if(!userRepository.exists(userId))
			return false;
		userRepository.delete(userId);
		if(userRepository.exists(userId))
			return false;
		return true;
	}

	@Override
	public LoginDto login(IdPw credentials) throws InvalidLoginDataException {
		// TODO Auto-generated method stub
		User user= userRepository.findByEmailAndPassword(credentials.getUser(), credentials.getPw());
		if(user==null)
			throw new InvalidLoginDataException("WRONG CREDENTIALS");
		return LoginConverter.toLoginDto(user);
	}

	@Override
	public Integer increaseUserReputation(Integer userId) throws InvalidUserException {
		// TODO Auto-generated method stub
		Integer newreputation=-6;
		if(userId==null || userId<0)
			throw new InvalidUserException("ERROR:ID IS NOT VALID!");
		User user= userRepository.findOne(userId);
		if(user==null)
			return null;
		if(user.getReputation()<5)
			newreputation= user.getReputation()+1;
		else
			newreputation=user.getReputation();
		user.setReputation(newreputation);
		user=userRepository.save(user);
		return user.getReputation();
	}

	@Override
	public Integer decreaseUserReputation(Integer userId) throws InvalidUserException {
		// TODO Auto-generated method stub
		Integer newreputation=-6;
		if(userId==null || userId<0)
			throw new InvalidUserException("ERROR:ID IS NOT VALID!");
		User user= userRepository.findOne(userId);
		if(user==null)
			return null;
		if(user.getReputation()>-5)
			newreputation= user.getReputation()-1;
		else
			newreputation=user.getReputation();
		user.setReputation(newreputation);
		user=userRepository.save(user);
		return user.getReputation();
	}
	
}
