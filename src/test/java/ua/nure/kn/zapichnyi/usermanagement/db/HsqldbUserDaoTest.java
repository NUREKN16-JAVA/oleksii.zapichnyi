package ua.nure.kn.zapichnyi.usermanagement.db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;

import ua.nure.kn.zapichnyi.usermanagement.User;


public class HsqldbUserDaoTest extends DatabaseTestCase {
 private static final long USER_TO_UPDATE_TEST = 1000L;
private static final long USER_ID = 1001L;
private static final String NEW_LAST_NAME = "Doe";
private static final String NEW_NAME = "John";
private static final String FIRST_NAME = "Paco";
private static final String LAST_NAME = "Alcacer";
private static final String DATE_OF_BIRTH = "1993-08-30";
private static final String NEW_DATE_OF_BIRTH = "1998-10-25";
private HsqldbUserDao dao;
 private ConnectionFactory connectionFactory;
 private SimpleDateFormat dt = new SimpleDateFormat ("yyyy-MM-dd");
  
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
	public void testFind() throws DatabaseException {
		User user = dao.find(USER_ID);
		assertNotNull("User not found", user);
		assertEquals(" Incorrect id", user.getId(), USER_ID);
		assertEquals("Incorrect first name",user.getFirstName(), FIRST_NAME);
		assertEquals("Incorrect last name",user.getLastName(), LAST_NAME);
		try {
			assertEquals("Incorrect date of birth",user.getDateOfBirth(),dt.parse(DATE_OF_BIRTH));
		} catch (ParseException e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	  public void testDelete() {
	        User user = new User();
	        
	        
	        user.setId(USER_ID);
	        try {
	        	Collection<User> all = dao.findAll();
	        	int before = all.size();
	            dao.delete(user);
	            all = dao.findAll();
	           assertEquals(before-1, all.size());
	        } catch (DatabaseException e) {
	        fail(e.toString());
	        }
	    }
	  public void testUpdate() throws DatabaseException {
	        User user = dao.find(USER_TO_UPDATE_TEST);
	        user.setFirstName(NEW_NAME);
			user.setLastName(NEW_LAST_NAME);
			
			Date newDateOfBirth = new Date();
			try {
				newDateOfBirth=dt.parse(NEW_DATE_OF_BIRTH);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        user.setDateOfBirth(newDateOfBirth);
			dao.update(user);
			User UpdatedUser = dao.find(USER_TO_UPDATE_TEST);
			assertEquals(NEW_NAME, UpdatedUser.getFirstName());
			assertEquals(NEW_LAST_NAME, UpdatedUser.getLastName());
			assertEquals(newDateOfBirth, UpdatedUser.getDateOfBirth());
	    }
	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		connectionFactory= new ConnectionFactoryImpl("org.hsqldb.jdbcDriver", "jdbc:hsqldb:file:db/usermanagement", "sa", "");
		return new DatabaseConnection(connectionFactory.createConnection());
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new XmlDataSet(getClass().getClassLoader()
				.getResourceAsStream("usersDataSet.xml"));
		return dataSet;
	}

}
