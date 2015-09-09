package org.TikhomirovServiseHyber.impl;

import java.util.List;

import org.TikhomirovHyber.dao.impl.UserDAOImpl;
import org.TikhomirovHyber.dao.interf.UserDAOH;
import org.TikhomirovHyber.pojos.User;
import org.TikhomirovHyber.pojos.UserDetail;
import org.TikhomirovServiseHyber.exception.ServiseException;
import org.TikhomirovServiseHyber.interf.UserServise;
import org.TikhomirovServiseHyber.utils.POJOtoVOTransformation;
import org.TikhomirovServiseHyber.utils.VOtoPOJOTransformation;
import org.TikhomirovVO.UserVO;
import org.apache.log4j.Logger;

import exceptions.DAOException;

public class UserServiseImpl implements UserServise {
	private static final Logger logger = Logger.getLogger(UserServiseImpl.class.getName());
	UserDAOH userdao = UserDAOImpl.getInstance();

	@Override
	public void add(UserVO userVO) throws ServiseException {
		logger.info("Start adding userVO: " + userVO + " to DataBase: ");
		logger.debug("Start transformation userVO: " + userVO + " to user");
		User user = VOtoPOJOTransformation.userTransform(userVO);
		UserDetail userDetail = VOtoPOJOTransformation.userDetailTransform(userVO);
		user.setUserDetail(userDetail);
		userDetail.setUser(user);
		logger.debug("Successful transformation from userVO to user. Transformed user: " + user);
		logger.info("Trying to add user: " + user + " to DataBase");
		try {
			if (!isExist(user)) {
				userdao.add(user);
				logger.info("New User: " + user + " was successfully created");
			} else {
				logger.info("Warning! Can't creater user. User with such login or/and password already exists!");
			}
		} catch (DAOException e) {
			logger.error("Add user: " + user + " to DataBase: failed");
			throw new ServiseException("Add user: " + user + " to DataBase: failed", e);

		}
	}

	private boolean isExist(User user) throws DAOException {
		if (userdao.getAuthorizedUser(user.getLogin(), user.getPassword()) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<UserVO> getAll() throws ServiseException {
		logger.info("Start getting List of users");
		List<UserVO> usersVO = null;
		try {
			List<User> users = userdao.getAll();
			logger.debug("Start transformation List<User> to List<UserVO>");
			usersVO = POJOtoVOTransformation.extract(users);
			logger.debug("Successfull transformation List<User> to List<UserVO>");
		} catch (DAOException e) {
			logger.error("Getting List of users: failed");
			throw new ServiseException("Getting List of users: failed", e);
		}
		logger.info("Successfull getting List of users");
		return usersVO;
	}

	@Override
	public void delete(UserVO userVO) throws ServiseException {
		logger.info("Start deleting user: " + userVO);
		User user = new User();
		user.setUser_id(userVO.getUser_id());
		try {

			if (userdao.getById(user) != null) {
				userdao.delete(user);
				logger.info("User: " + user + " was successfully deleted");
			} else {
				logger.info("Warning! Can't delete user. User wasn't found in DataBase!");
			}
		} catch (DAOException e) {
			logger.error("Delete user: " + user + " from DataBase: failed");
			throw new ServiseException("Delete user: " + user + " from DataBase: failed", e);

		}

	}

	@Override
	public UserVO getById(UserVO userVO) throws ServiseException {
		logger.info("Start getting user by ID: " + userVO.getUser_id());
		User user = new User();
		user.setUser_id(userVO.getUser_id());
		try {
			user = (User) userdao.getById(user);
			System.out.println(user.getOrders());
			logger.info("Get user by ID: " + userVO.getUser_id() + " :" + user);
		} catch (DAOException e) {
			logger.error("Get user by ID: " + userVO.getUser_id() + " from DataBase: failed");
			throw new ServiseException("Get user by ID: " + userVO.getUser_id() + " from DataBase: failed", e);
		}
		userVO = POJOtoVOTransformation.extract(user);
		return userVO;
	}

	@Override
	public UserVO getAuthorizedUser(String login, String password) throws ServiseException {
		logger.info("Start getting  AuthorizedUser ");
		UserVO userVO = null;
		try {
			User user = (User) userdao.getAuthorizedUser(login, password);
			userVO = POJOtoVOTransformation.extract(user);
		} catch (DAOException e) {
			logger.error("Get AuthorizedUser: failed");
			throw new ServiseException("Get AuthorizedUser: failed", e);
		}
		return userVO;
	}

}
