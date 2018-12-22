package ua.nure.kn.zapichnyi.usermanagement.web;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ua.nure.kn.zapichnyi.usermanagement.User;

public class BrowseServletTest extends MockServletTestCase {

	public void setUp() throws Exception {
		super.setUp();
		createServlet(BrowseServlet.class);
	}

	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testBrowse() {
		User user = new User(1000L,"John","Doe",new Date());
		List<User> list=Collections.singletonList(user);
		getMockUserDao().expectAndReturn("findAll",list);
		doGet();
		Collection<User> collection = (Collection) getWebMockObjectFactory().getMockSession().getAttribute("users");
		assertNotNull("Could not find list of users in session",collection);
		assertSame(list, collection);
	}

}
