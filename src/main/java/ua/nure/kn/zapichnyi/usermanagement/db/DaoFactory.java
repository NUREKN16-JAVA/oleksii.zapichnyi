package ua.nure.kn.zapichnyi.usermanagement.db;

import java.io.IOException;
import java.util.Properties;

public class DaoFactory {
	private final Properties properties;
public DaoFactory(){
	properties= new Properties();
	try {
			properties.load(getClass().getClassLoader().getResourceAsStream(
					"settings.properties"));
	} catch (IOException e) {
	  throw new RuntimeException(e);
	}
}

private ConnectionFactory getConnectionFactory(){
	String user = properties.getProperty("sa");
	String password = properties.getProperty("password");
	String url = properties.getProperty("url");
	String driver = properties.getProperty("driver");
	return new ConnectionFactoryImpl(driver,url,user,password);
}
public UserDao getUserDao(){
	UserDao result = null;
	
	return result;
}
}
