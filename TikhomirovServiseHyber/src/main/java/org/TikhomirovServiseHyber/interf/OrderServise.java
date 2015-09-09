package org.TikhomirovServiseHyber.interf;

import java.util.List;
import java.util.Set;

import org.TikhomirovServiseHyber.exception.ServiseException;
import org.TikhomirovVO.OrderVO;
import org.TikhomirovVO.UserVO;

public interface OrderServise {
	public void add(OrderVO orderVO) throws ServiseException;

	public List<OrderVO> getAll() throws ServiseException;

	public void delete(OrderVO orderVO) throws ServiseException;

	public OrderVO getById(OrderVO orderVO) throws ServiseException;

	public Set<OrderVO> getOrdersByUser(UserVO userVO) throws ServiseException;

}
