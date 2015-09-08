package by.academy.tikhomirov.service;

import java.util.List;

import by.academy.tikhomirov.entity.*;
import by.academy.tikhomirov.exception.DAOException;
import by.academy.tikhomirov.implem.SortDAOImpl;
import by.academy.tikhomirov.interf.CustomSortDAO;
import by.academy.tikhomirov.service.exception.ServiceException;


public class SortService {

	CustomSortDAO dao = SortDAOImpl.getInstance();

	public List<Sort> getAll() throws ServiceException {
		try {
			return dao.getAll();
		} catch (DAOException e) {
			throw new ServiceException("Servise GETALL method exception");
		}
	}

//	public void create(Sort sort) throws ServiceException {
//		dao.create(sort);
//	}
//
//	public void update(Sort sort) throws ServiceException {
//		dao.update(sort);
//	}
//
//	public void delete(Sort sort) throws ServiceException {
//		dao.delete(sort);
//	}

	public Sort getSortByName(String name) throws ServiceException {
		try {
			return dao.getSortByName(name);
		} catch (DAOException e) {
			throw new ServiceException("Servise GETSORTBYNAME method exception");
		}
	}
}
