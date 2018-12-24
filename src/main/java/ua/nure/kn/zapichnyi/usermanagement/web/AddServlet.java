package ua.nure.kn.zapichnyi.usermanagement.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.kn.zapichnyi.usermanagement.User;
import ua.nure.kn.zapichnyi.usermanagement.db.DaoFactory;
import ua.nure.kn.zapichnyi.usermanagement.db.DatabaseException;

public class AddServlet extends EditServlet {
	
		
	@Override
		protected void processUser(User user) throws DatabaseException {
			
			DaoFactory.getInstance().getUserDao().create(user);
		}
	
		@Override
	protected void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("/add.jsp").forward(req, resp);
	}
	
}
