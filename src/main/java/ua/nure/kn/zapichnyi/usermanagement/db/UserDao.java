package ua.nure.kn.zapichnyi.usermanagement.db;

import java.util.Collection;

import ua.nure.kn.zapichnyi.usermanagement.User;

public interface UserDao {
 User create(User user) throws DatabaseException;
 void update(User user)throws DatabaseException;
 void delete(User user)throws DatabaseException;
 User find(long id)throws DatabaseException;
 Collection<User> findAll() throws DatabaseException;
 Collection<User> find(String firstName,String lastName) throws DatabaseException;
 void setConnectionFactory(ConnectionFactory connectionFactory);
 
 
}
