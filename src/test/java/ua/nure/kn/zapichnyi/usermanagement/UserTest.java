package ua.nure.kn.zapichnyi.usermanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

public class UserTest extends TestCase {

	private  User user;  
	protected void setUp() throws Exception {
		user= new User(1L, "Иван", "Иванов",
	new SimpleDateFormat("dd-MM-yyyy").parse("29-04-1984"));
	}
	public void testGetFullName() {
		assertEquals("Иванов, Иван", user.getFullName());
	}
	public void testGetAge(){
		 Date dt = new Date();
	        Calendar c = Calendar.getInstance();
	        c.setTime(dt);
	        c.add(Calendar.YEAR, -5);
	        dt = c.getTime();
		user.setDateOfBirth( dt);
		assertEquals(5, user.getAge());
	}
	public void testGetAge1() throws ParseException{
		 Date dt = new Date();
	        Calendar c = Calendar.getInstance();
	        c.setTime(dt);
	        c.add(Calendar.DATE, -1);
	        dt = c.getTime();
		user.setDateOfBirth(dt);
		assertEquals(0, user.getAge());
	}
	public void testGetAge2() throws ParseException{
		Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        dt = c.getTime();
	user.setDateOfBirth( dt);
	assertEquals(0, user.getAge());
	}
	public void testGetAge3() throws ParseException{
		Date dt = new Date();
	user.setDateOfBirth( dt);
	assertEquals(0, user.getAge());
	}
	public void testGetAge4() throws ParseException{
		Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.YEAR, -1);
        c.add(Calendar.DATE,1 );
        dt = c.getTime();
	user.setDateOfBirth( dt);
	assertEquals(0, user.getAge());
	}
	public void testGetAge5() throws ParseException{
		Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.YEAR, -1);
        c.add(Calendar.DATE, -1 );
        dt = c.getTime();
	user.setDateOfBirth( dt);
	assertEquals(1, user.getAge());
	}
}
