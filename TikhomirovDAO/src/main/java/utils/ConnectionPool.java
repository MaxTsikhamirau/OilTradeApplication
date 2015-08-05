package utils;

import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.dbcp.BasicDataSource;
import java.sql.Connection;

public class ConnectionPool {
	
	    private static ConnectionPool instance;
	    private BasicDataSource dataSource;
	    ResourceBundle rb=ResourceBundle.getBundle("resourses.database");
	   
	    private ConnectionPool() {
	        dataSource = new BasicDataSource();
	        dataSource.setDriverClassName(rb.getString("db.classname"));
	        dataSource.setUrl(rb.getString("db.url"));
	        dataSource.setUsername(rb.getString("db.login"));
	        dataSource.setPassword(rb.getString("db.password"));
	    }

	    public synchronized static ConnectionPool getInstance() {
	        if (instance == null) {
	            instance = new ConnectionPool();
	        }
	        return instance;
	    }

	    public Connection getConnection() throws SQLException {
	        return dataSource.getConnection();
	    }

	    public void closeConnection() throws SQLException {
	        dataSource.close();
	    }

	}


