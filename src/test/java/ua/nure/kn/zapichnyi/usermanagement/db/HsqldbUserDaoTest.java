package ua.nure.kn.zapichnyi.usermanagement.db;

import java.util.Collection;
import java.util.Date;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;

import ua.nure.kn.zapichnyi.usermanagement.User;


public class HsqldbUserDaoTest extends DatabaseTestCase {
 private HsqldbUserDao dao;
 private ConnectionFactory connectionFactory;
  
	protected void  setUp() throws Exception {
		super.setUp();
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

	public void testFindAll(){
		try {
		Collection<User> collection= dao.findAll();
		assertNotNull("Collection is null",collection);
		assertEquals("Collection size.",2, collection.size());
		} catch (DatabaseException e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		connectionFactory= new ConnectionFactoryImpl();
		return new DatabaseConnection(connectionFactory.createConnection());
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new XmlDataSet(getClass().getClassLoader()
				.getResourceAsStream("usersDataSet.xml"));
		return dataSet;
	}

}
