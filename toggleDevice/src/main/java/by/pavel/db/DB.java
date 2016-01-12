package by.pavel.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {

    private DataSource ds;
    private static DB instance = new DB();

    private DB() {
        try {
            Context context = new InitialContext();
            ds = (DataSource) context.lookup("java:/comp/env/jdbc/test1");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public static DB getInstance() {
        return instance;
    }

    public Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        close(resultSet);
        close(preparedStatement);
        close(connection);
    }

    public void close(Connection connection, PreparedStatement preparedStatement) {
        close(preparedStatement);
        close(connection);
    }

    private void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {

        }
    }

    private void close(PreparedStatement preparedStatement) {
        try {
            preparedStatement.close();
        } catch (SQLException e) {

        }
    }

    private void close(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException e) {

        }
    }
}
