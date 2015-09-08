package by.academy.tikhomirov.service;

import java.util.List;
import by.academy.tikhomirov.entity.*;
import by.academy.tikhomirov.exception.DAOException;
import by.academy.tikhomirov.implem.RoleDAOImpl;
import by.academy.tikhomirov.interf.CustomRoleDAO;
import by.academy.tikhomirov.service.exception.ServiceException;

public class RoleService {

	CustomRoleDAO dao = RoleDAOImpl.getInstance();

	public List<Role> getAll() throws ServiceException {
		try {
			return dao.getAll();
		} catch (DAOException e) {
			throw new ServiceException("Servise GETALL method exception");
		}
	}

	// public void create(Role role) throws ServiceException {
	// dao.create(role);
	// }
	//
	// public void update(Role role) throws ServiceException {
	// dao.update(role);
	// }

	// public void delete(Role role) throws ServiceException {
	// dao.delete(role);
	// }

	public Role getRoleByName(String name) throws ServiceException {
		try {
			return dao.getRoleByName(name);
		} catch (DAOException e) {
			throw new ServiceException("Servise GETROLEBYNAME method exception");
		}
	}
}
