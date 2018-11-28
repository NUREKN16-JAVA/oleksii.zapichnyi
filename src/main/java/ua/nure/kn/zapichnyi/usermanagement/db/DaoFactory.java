package ua.nure.kn.zapichnyi.usermanagement.db;

import java.io.IOException;
import java.util.Properties;

public class DaoFactory {
	private static final String USER_DAO = "dao.nure.kn.zapichnyi.usermanagement.db.UserDao";
	private final Properties properties;
	private final static DaoFactory INSTANCE = new DaoFactory();
private DaoFactory(){
	properties= new Properties();
	try {
			properties.load(getClass().getClassLoader().getResourceAsStream(
					"settings.properties"));
	} catch (IOException e) {
	  throw new RuntimeException(e);
	}
}
public static DaoFactory getInstance(){
	return INSTANCE;
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
	try {
			Class clazz = Class.forName(properties.getProperty(USER_DAO));
		UserDao userDao= (UserDao)clazz.newInstance();
		userDao.setConnectionFactory(getConnectionFactory());
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
	return result;
}
}
