package org.TikhomirovServiseHyber.interf;

import java.util.List;

import org.TikhomirovServiseHyber.exception.ServiseException;
import org.TikhomirovVO.UserVO;

public interface UserServise {

	public void add(UserVO userVO) throws ServiseException;

	public List<UserVO> getAll() throws ServiseException;

	public void delete(UserVO userVO) throws ServiseException;

	public UserVO getById(UserVO userVO) throws ServiseException;

	public UserVO getAuthorizedUser(String login, String password) throws ServiseException;

}
