package dao;


import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
	
	public void create(T Object) throws SQLException;
	public List<T> getAll() throws SQLException;
	public void delete(int PK) throws SQLException;
	//public void update(T object) throws SQLException;
	
}

