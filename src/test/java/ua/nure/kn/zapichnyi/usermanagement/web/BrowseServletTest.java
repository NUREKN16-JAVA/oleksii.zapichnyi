package ua.nure.kn.zapichnyi.usermanagement.web;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.nure.kn.zapichnyi.usermanagement.User;

public class BrowseServletTest extends MockServletTestCase {
    @Before
	public void setUp() throws Exception {
		super.setUp();
		createServlet(BrowseServlet.class);
	}
	@Test
	public void testBrowse() {
		User user = new User(1000L,"John","Doe",new Date());
		List<User> list=Collections.singletonList(user);
		getMockUserDao().expectAndReturn("findAll",list);
		doGet();
		Collection<User> collection = (Collection) getWebMockObjectFactory().getMockSession().getAttribute("users");
		assertNotNull("Could not find list of users in session",collection);
		assertSame(list, collection);
	}
	@Test
 public void testEdit() {
	 User user = new User(new Long(1000),"John","Doe",new Date());
	 getMockUserDao().expectAndReturn("find", new Long(1000),user);
	 addRequestParameter("editButton","Edit");
	 addRequestParameter("id","1000");
	 doPost();
	 User userInSession = (User) getWebMockObjectFactory().getMockSession().getAttribute("user");
	 assertNotNull("Could not find user in session",user);
	 assertSame(user, userInSession);
 }
	@Test
	 public void testDetails() {
	        User user = new User(1000L, "John", "Doe", new Date());
	        getMockUserDao().expectAndReturn("find", new Long(1000), user);
	        addRequestParameter("detailsButton", "Details");
	        addRequestParameter("id", "1000");
	        doPost();
	        User userInSession = (User) getWebMockObjectFactory().getMockSession().getAttribute("user");
	        assertNotNull(userInSession);
	        assertSame(user, userInSession);
	    }
	
	@Test
   public void testDelete() {
       User user = new User(1000L, "John", "Doe", new Date());
       getMockUserDao().expectAndReturn("find", new Long(1000), user);
       getMockUserDao().expect("delete", user);
       addRequestParameter("deleteButton", "Delete");
       addRequestParameter("id", "1000");
       doPost();
       assertNotNull(getWebMockObjectFactory().getMockRequest().getAttribute("message"));
   }
}
 