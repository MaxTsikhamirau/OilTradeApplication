package by.academy.tikhomirov.interf;

import java.sql.SQLException;
import java.util.List;

import by.academy.tikhomirov.entity.Offer;

public interface CustomOfferDAO extends GenericDAO<Offer> {
	public List<Offer> sortByPrice() throws SQLException;

	public List<Offer> sortByQuantity() throws SQLException;

}
