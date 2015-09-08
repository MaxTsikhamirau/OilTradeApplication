package by.academy.tikhomirov.interf;

import java.util.List;

import by.academy.tikhomirov.entity.*;
import by.academy.tikhomirov.exception.DAOException;


public interface CustomOfferDAO extends GenericDAO<Offer> {

	public List<Offer> getAcceptableOffers(String sortName, int quantity) throws DAOException;
}
