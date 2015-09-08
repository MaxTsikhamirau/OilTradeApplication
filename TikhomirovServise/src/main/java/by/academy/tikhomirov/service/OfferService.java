package by.academy.tikhomirov.service;


import java.util.List;

import by.academy.tikhomirov.entity.*;
import by.academy.tikhomirov.exception.DAOException;
import by.academy.tikhomirov.implem.OfferDAOImpl;
import by.academy.tikhomirov.interf.CustomOfferDAO;
import by.academy.tikhomirov.service.exception.ServiceException;

public class OfferService {

	CustomOfferDAO dao = OfferDAOImpl.getInstance();

	public List<Offer> getAll() throws ServiceException {
		try {
			return dao.getAll();
		} catch (DAOException e) {
			throw new ServiceException("Servise GETALL method exception");
				
		}
	}

	public void create(Offer offer) throws ServiceException {
		try {
			dao.create(offer);
		} catch (DAOException e) {
			throw new ServiceException("Servise CREATE method exception");
		}
	}

	public void update(Offer offer) throws ServiceException {
		try {
			dao.update(offer);
		} catch (DAOException e) {
			throw new ServiceException("Servise UPDATE method exception");
		}
	}

	public void delete(Offer offer) throws ServiceException {
		try {
			dao.delete(offer);
		} catch (DAOException e) {
			throw new ServiceException("Servise DELETE method exception");
		}
	}

	public List<Offer> getAcceptableOffers(String sortName, int quantity) throws ServiceException {
		try {
			return dao.getAcceptableOffers(sortName, quantity);
		} catch (DAOException e) {
			throw new ServiceException("Servise GETACCEPTABLEOFFERS method exception");
		}
	}

}
