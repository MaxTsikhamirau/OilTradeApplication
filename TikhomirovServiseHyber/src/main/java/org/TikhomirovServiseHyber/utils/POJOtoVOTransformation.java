package org.TikhomirovServiseHyber.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.TikhomirovHyber.pojos.Role;
import org.TikhomirovHyber.pojos.User;
import org.TikhomirovVO.RoleVO;
import org.TikhomirovVO.UserVO;

public class POJOtoVOTransformation {

	public static UserVO extract(User user) {

		UserVO userVO = new UserVO();
		userVO.setUser_id(user.getUser_id());
		userVO.setUser_name(user.getUser_name());
		userVO.setCity(user.getUserDetail().getCity());
		userVO.setCountry(user.getUserDetail().getCountry());
		userVO.setTelephone(user.getUserDetail().getTelephone());
		userVO.setLogin(user.getLogin());
		userVO.setPassword(user.getPassword());
		// Set<Role> roles = user.getRoles();
		// userVO.setRolesVO(extract(roles));

		return userVO;
	}

	public static Set<RoleVO> extract(Set<Role> roles) {
		Set<RoleVO> rolesVO = new HashSet<>();
		for (Role role : roles) {
			RoleVO roleVO = new RoleVO();
			roleVO.setRole_id(role.getRole_id());
			roleVO.setRole_name(role.getRole_name());
			rolesVO.add(roleVO);
		}
		return rolesVO;
	}

	public static List<UserVO> extract(List<User> users) {
		List<UserVO> usersVO = new ArrayList<>();
		// usersVO=null;
		for (User user : users) {
			UserVO userVO = extract(user);
			usersVO.add(userVO);
		}
		return usersVO;
	}

}
