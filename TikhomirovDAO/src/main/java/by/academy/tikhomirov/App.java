package by.academy.tikhomirov;

import java.sql.SQLException;
import java.util.List;

import by.academy.tikhomirov.entity.Offer;
import by.academy.tikhomirov.entity.Role;
import by.academy.tikhomirov.entity.Seller;
import by.academy.tikhomirov.entity.Sort;
import by.academy.tikhomirov.interf.*;
import by.academy.tikhomirov.implem.*;

public class App {
	public static void main(String[] args) throws SQLException {
		System.out.println("Hello World!");
		CustomOfferDAO dao=OfferDAOImpl.getInstance();
		System.out.println(dao.getAll());
	}
}
