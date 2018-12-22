package ua.nure.kn.zapichnyi.usermanagement.web;

import java.util.Properties;

import com.mockobjects.dynamic.Mock;
import com.mockrunner.servlet.BasicServletTestCaseAdapter;

import junit.framework.TestCase;
import ua.nure.kn.zapichnyi.usermanagement.db.DaoFactory;
import ua.nure.kn.zapichnyi.usermanagement.db.MockDaoFactory;

public abstract class MockServletTestCase extends BasicServletTestCaseAdapter{
	 private Mock mockUserDao;
	public void setUp() throws Exception {
	  super.setUp();
	  Properties properties = new Properties();
	  properties.setProperty("dao.factory", MockDaoFactory.class.getName());
	  DaoFactory.init(properties);
	  setMockUserDao(((MockDaoFactory)DaoFactory.getInstance()).getMockUserDao());
	}

	
	public void tearDown() throws Exception {
	  getMockUserDao().verify();
	  super.tearDown();
	}
	  public Mock getMockUserDao() {
	  return mockUserDao;
	}

	public void setMockUserDao(Mock mockUserDao) {
	  this.mockUserDao = mockUserDao;
	}
	}

