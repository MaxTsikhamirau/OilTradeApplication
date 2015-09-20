package org.TikhomirovServiseHyber.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.TikhomirovHyber.pojos.Offer;
import org.TikhomirovHyber.pojos.Order;
import org.TikhomirovHyber.pojos.Role;
import org.TikhomirovHyber.pojos.Sort;
import org.TikhomirovHyber.pojos.User;
import org.TikhomirovVO.OfferVO;
import org.TikhomirovVO.OrderVO;
import org.TikhomirovVO.RoleVO;
import org.TikhomirovVO.SortVO;
import org.TikhomirovVO.UserVO;

public class POJOtoVOTransformation {

	public static UserVO extract(User user) {
		UserVO userVO = null;
		if (user != null) {
			userVO = new UserVO();
			userVO.setUser_id(user.getUser_id());
			userVO.setUser_name(user.getUser_name());
			userVO.setCity(user.getUserDetail().getCity());
			userVO.setCountry(user.getUserDetail().getCountry());
			userVO.setTelephone(user.getUserDetail().getTelephone());
			userVO.setLogin(user.getLogin());
			userVO.setPassword(user.getPassword());
			Set<Role> roles = user.getRoles();
			userVO.setRolesVO(rolesExtract(roles));
			Set<Offer> offers = user.getOffers();
			userVO.setOffersVO(offersExtract(offers));
			Set<Order> orders = user.getOrders();
			userVO.setOrdersVO(ordersExtract(orders));
		}
		return userVO;
	}

	public static Set<OrderVO> ordersExtract(Set<Order> orders) {
		Set<OrderVO> ordersVO = new HashSet<>();

		for (Order order : orders) {
			OrderVO orderVO = new OrderVO();
			orderVO = extract(order);
			ordersVO.add(orderVO);
		}
		return ordersVO;
	}

	public static Set<RoleVO> rolesExtract(Set<Role> roles) {
		Set<RoleVO> rolesVO = new HashSet<>();
		for (Role role : roles) {
			RoleVO roleVO = new RoleVO();
			roleVO.setRole_id(role.getRole_id());
			roleVO.setRole_name(role.getRole_name());
			rolesVO.add(roleVO);
		}
		return rolesVO;
	}

	public static Set<OfferVO> offersExtract(Set<Offer> offers) {
		Set<OfferVO> offersVO = new HashSet<>();

		for (Offer offer : offers) {
			OfferVO offerVO = new OfferVO();
			offerVO.setOffer_id(offer.getOffer_id());
			offerVO.setQuantity(offer.getQuantity());
			offerVO.setPrice(offer.getPrice());
			Sort sort = offer.getSort();
			SortVO sortVO = extract(sort);
			offerVO.setSortVO(sortVO);
			offersVO.add(offerVO);
		}
		return offersVO;
	}

	public static SortVO extract(Sort sort) {
		SortVO sortVO = new SortVO();
		sortVO.setSort_id(sort.getSort_id());
		sortVO.setSort_name(sort.getSort_name());

		return sortVO;
	}

	public static OrderVO extract(Order order) {
		OrderVO orderVO = new OrderVO();
		orderVO.setOrder_id(order.getOrder_id());
		orderVO.setQuantity(order.getQuantity());
		orderVO.setPrice(order.getPrice());
		Sort sort = order.getSort();
		SortVO sortVO = extract(sort);
		orderVO.setSortVO(sortVO);
		return orderVO;
	}

	public static List<UserVO> usersExtract(List<User> users) {
		List<UserVO> usersVO = new ArrayList<>();
		for (User user : users) {
			UserVO userVO = extract(user);
			usersVO.add(userVO);
		}
		return usersVO;
	}

	public static List<OrderVO> ordersExtract(List<Order> orders) {

		List<OrderVO> ordersVO = new ArrayList<>();

		for (Order order : orders) {
			OrderVO orderVO = new OrderVO();
			orderVO.setOrder_id(order.getOrder_id());
			orderVO.setQuantity(order.getQuantity());
			orderVO.setPrice(order.getPrice());
			Sort sort = order.getSort();
			SortVO sortVO = extract(sort);
			User user = order.getUser();
			UserVO userVO = extract(user);
			orderVO.setSortVO(sortVO);
			orderVO.setUserVO(userVO);
			ordersVO.add(orderVO);
		}
		return ordersVO;
	}

	public static List<OfferVO> offersExtract(List<Offer> offers) {
		List<OfferVO> offersVO = new ArrayList<>();

		for (Offer offer : offers) {
			OfferVO offerVO = new OfferVO();
			offerVO.setOffer_id(offer.getOffer_id());
			offerVO.setQuantity(offer.getQuantity());
			offerVO.setPrice(offer.getPrice());
			Sort sort = offer.getSort();
			SortVO sortVO = extract(sort);
			User user = offer.getUser();
			UserVO userVO = extract(user);
			offerVO.setSortVO(sortVO);
			offerVO.setUserVO(userVO);
			offersVO.add(offerVO);
		}
		return offersVO;
	}
}
