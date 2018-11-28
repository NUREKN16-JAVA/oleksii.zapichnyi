package ua.nure.kn.zapichnyi.usermanagement.db;

import java.sql.Connection;

public interface ConnectionFactory {
  Connection createConnection() throws DatabaseException;
}
