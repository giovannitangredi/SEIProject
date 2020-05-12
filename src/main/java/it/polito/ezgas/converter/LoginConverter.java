package it.polito.ezgas.converter;

import it.polito.ezgas.dto.LoginDto;
import it.polito.ezgas.entity.User;

public class LoginConverter {
	public static LoginDto toLoginDto(User user) {
		LoginDto login= new LoginDto();
		login.setEmail(user.getEmail());
		login.setAdmin(user.getAdmin());
		login.setUserId(user.getUserId());
		login.setReputation(user.getReputation());
		login.setUserName(user.getUserName());
		login.setToken("token");
		return login;
	}
}
