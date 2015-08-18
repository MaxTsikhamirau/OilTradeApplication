package by.academy.tikhomirov.service;

import java.sql.SQLException;
import java.util.List;

import by.academy.tikhomirov.entity.*;

import by.academy.tikhomirov.implem.OfferDAOImpl;
import by.academy.tikhomirov.interf.CustomOfferDAO;


public class OfferService {
	private static final OfferService instance = new OfferService();
	private OfferService() {
			}

	public static OfferService getInstance() {
		return instance;
	}
	CustomOfferDAO dao = OfferDAOImpl.getInstance();

	public List<Offer> getAll() throws ClassNotFoundException, SQLException {
		return dao.getAll();
	}

	public void create(Offer offer) throws SQLException {
		dao.create(offer);
	}

	public void update(Offer offer) throws SQLException {
		dao.update(offer);
	}

	public void delete(Offer offer) throws SQLException {
		dao.delete(offer);
	}

	public List<Offer> getSortedByQuantity() throws ClassNotFoundException, SQLException {
		return dao.sortByQuantity();
	}

	public List<Offer> getSortedByPrice() throws ClassNotFoundException, SQLException {
		return dao.sortByPrice();
	}

}
