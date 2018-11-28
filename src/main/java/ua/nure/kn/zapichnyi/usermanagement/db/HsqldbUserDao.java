package ua.nure.kn.zapichnyi.usermanagement.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.sql.Date;

import ua.nure.kn.zapichnyi.usermanagement.User;

public class HsqldbUserDao implements UserDao {
  
	private static final String INSERT_QUERY = "INSERT INTO users (firstname,lastname,dateofbirth) VALUES (?,?,?)";
	private ConnectionFactory connectionFactory;
	 
	
	public HsqldbUserDao(ConnectionFactory connectionFactory) {
		super();
		this.connectionFactory = connectionFactory;
		
	}


	@Override
	public User create(User user) throws DatabaseException {
		try {
			Connection connection = connectionFactory.createConnection();
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			ps.setString(1,user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setDate(3, new Date(user.getDateOfBirth().getTime()));
			int n = ps.executeUpdate();
			if(n!=1){
				throw new DatabaseException("Number of the inserted rows" + n );
			}
			CallableStatement callableStatement = connection.prepareCall("call IDENTITY()");
			ResultSet keys = callableStatement.executeQuery();
			if(keys.next()){
				user.setId(new Long(keys.getLong(1)));
			}
			keys.close();
			callableStatement.close();
			ps.close();
			connection.close();
			return user;
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e){
			throw new DatabaseException(e);
		}
	}


	@Override
	public void update(User user) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(User user) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public User find(long id) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Collection<User> findAll() throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
