package ua.nure.kn.zapichnyi.usermanagement.db;

import java.util.Date;

import ua.nure.kn.zapichnyi.usermanagement.User;
import junit.framework.TestCase;

public class HsqldbUserDaoTest extends TestCase {
 private HsqldbUserDao dao;
 private ConnectionFactory connectionFactory;
  
	protected void  setUp() throws Exception {
		super.setUp();
		connectionFactory= new ConnectionFactoryImpl();
		dao = new HsqldbUserDao(connectionFactory);
	}

	public void testCreate() {
	try {
		User user = new User();
		user.setFirstName("Ivan");
		user.setLastName("Ivanov");
		user.setDateOfBirth(new Date());
		//assertNull(user.getId());
        user=dao.create(user);
		assertNotNull(user);
		assertNotNull(user.getId());
	} catch (DatabaseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		fail(e.toString()); 
	}
	}

}
