package by.academy.tikhomirov.service;

import java.sql.SQLException;
import java.util.List;
import by.academy.tikhomirov.entity.Role;
import by.academy.tikhomirov.implem.RoleDAOImpl;
import by.academy.tikhomirov.interf.GenericDAO;


public class RoleService {

	GenericDAO<Role> dao = RoleDAOImpl.getInstance();

	public List<Role> getAll() throws ClassNotFoundException, SQLException {
		return dao.getAll();
	}

	public void create(Role role)throws SQLException {
		dao.create(role);
	}

	public void update(Role role)throws SQLException {
		dao.update(role);
	}

	public void delete(Role role) throws SQLException {
		dao.delete(role);
	}
	
}
