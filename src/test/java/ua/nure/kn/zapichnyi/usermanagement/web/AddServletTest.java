package ua.nure.kn.zapichnyi.usermanagement.web;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.nure.kn.zapichnyi.usermanagement.User;

public class AddServletTest extends MockServletTestCase {

	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		createServlet(AddServlet.class);
	}

	@Test
	public void testAdd() {
		Date date = new Date();
		User newUser = new User("John","Doe",date);
		User user = new User(new Long(1000),"John","Doe",date);
		getMockUserDao().expectAndReturn("create",user,newUser);
		
		
		addRequestParameter("firstName","John");
		addRequestParameter("lastName","Doe");
		addRequestParameter("dateOfBirth",DateFormat.getDateInstance().format(date));
		addRequestParameter("okButton","Ok");
		doPost();
		
	}
	@Test
	public void testAddEmptyFirstName() {
		Date date = new Date();
		addRequestParameter("lastName","Doe");
		addRequestParameter("dateOfBirth",DateFormat.getDateInstance().format(date));
		addRequestParameter("okButton","Ok");
		doPost();
		String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
		assertNotNull("Could not find error message in session scope",errorMessage);
		
	}
	@Test
	public void testAddEmptyLastName() {
		Date date = new Date();
		addRequestParameter("firstName","John");
		addRequestParameter("dateOfBirth",DateFormat.getDateInstance().format(date));
		addRequestParameter("okButton","Ok");
		doPost();
		String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
		assertNotNull("Could not find error message in session scope",errorMessage);
		
	}
	@Test
	public void testAddEmptyDate() {
		addRequestParameter("firstName","John");
		addRequestParameter("lastName","Doe");
		addRequestParameter("okButton","Ok");
		doPost();
		String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
		assertNotNull("Could not find error message in session scope",errorMessage);
		
	}
	@Test
	public void testAddEmptyDateIncorrect() {
		Date date = new Date();
		addRequestParameter("firstName","John");
		addRequestParameter("lastName","Doe");
		addRequestParameter("dateOfBirth","jawsdfchcxt");
		addRequestParameter("okButton","Ok");
		doPost();
		String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
		assertNotNull("Could not find error message in session scope",errorMessage);
		
	}
	


}
