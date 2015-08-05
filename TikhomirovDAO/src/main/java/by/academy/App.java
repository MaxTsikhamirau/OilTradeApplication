package by.academy;

import java.sql.SQLException;
import dao.GenericDAO;
import dao.SellerDAOImpl;
import entity.Seller;



public class App {
	public static void main(String[] args) throws SQLException {
		System.out.println("Hello World!");
		GenericDAO<Seller> dao = SellerDAOImpl.getInstance();
		System.out.println(dao.getAll());
		System.out.println("deleted");
		
	}
}
