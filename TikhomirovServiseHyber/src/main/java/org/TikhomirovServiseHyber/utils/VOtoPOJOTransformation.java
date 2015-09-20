package org.TikhomirovServiseHyber.utils;

import java.util.HashSet;
import java.util.Set;

import org.TikhomirovHyber.pojos.Offer;
import org.TikhomirovHyber.pojos.Order;
import org.TikhomirovHyber.pojos.Role;
import org.TikhomirovHyber.pojos.Sort;
import org.TikhomirovHyber.pojos.User;
import org.TikhomirovHyber.pojos.UserDetail;
import org.TikhomirovVO.OfferVO;
import org.TikhomirovVO.OrderVO;
import org.TikhomirovVO.RoleVO;
import org.TikhomirovVO.SortVO;
import org.TikhomirovVO.UserVO;

public class VOtoPOJOTransformation {

	public static UserDetail userDetailTransform(UserVO userVO) {
		UserDetail userDetail = new UserDetail();
		userDetail.setCity(userVO.getCity());
		userDetail.setCountry(userVO.getCountry());
		userDetail.setTelephone(userVO.getTelephone());
		return userDetail;
	}

	public static Set<Role> roleTransform(Set<RoleVO> rolesVO) {
		Set<Role> roles = new HashSet<>();
		for (RoleVO roleVO : rolesVO) {
			Role role = new Role();
			role.setRole_name(roleVO.getRole_name());
			roles.add(role);
		}
		return roles;
	}

	public static User userTransform(UserVO userVO) {
		User user = new User();
		//user.setUser_id(userVO.getUser_id());
		user.setUser_name(userVO.getUser_name());
		user.setLogin(userVO.getLogin());
		user.setPassword(userVO.getPassword());
		return user;
	}

	public static Sort sortTransform(SortVO sortVO) {
		Sort sort = new Sort();
		sort.setSort_name(sortVO.getSort_name());
		return sort;
	}

	public static Order orderTransform(OrderVO orderVO) {
		Order order = new Order();
		UserVO userVO = orderVO.getUserVO();
		User user = userTransform(userVO);
		UserDetail userDetail = VOtoPOJOTransformation.userDetailTransform(userVO);
		user.setUserDetail(userDetail);
		userDetail.setUser(user);
		order.setUser(user);
		order.setPrice(orderVO.getPrice());
		order.setQuantity(orderVO.getQuantity());
		SortVO sortVO = orderVO.getSortVO();
		order.setSort(sortTransform(sortVO));
		return order;
	}
	public static Offer offerTransform(OfferVO offerVO) {
		Offer offer = new Offer();
		UserVO userVO = offerVO.getUserVO();
		User user = userTransform(userVO);
		UserDetail userDetail = VOtoPOJOTransformation.userDetailTransform(userVO);
		user.setUserDetail(userDetail);
		userDetail.setUser(user);
		offer.setUser(user);
		offer.setPrice(offerVO.getPrice());
		offer.setQuantity(offerVO.getQuantity());
		SortVO sortVO = offerVO.getSortVO();
		offer.setSort(sortTransform(sortVO));
		return offer;
	}
}
