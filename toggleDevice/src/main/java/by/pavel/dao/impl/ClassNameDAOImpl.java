package by.pavel.dao.impl;

import by.pavel.dao.ClassNameDAO;
import by.pavel.db.DB;
import by.pavel.entity.ClassName;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassNameDAOImpl implements ClassNameDAO {

    @Override
    public ClassName loadClassNameByKeyword(String keyword) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ClassName result = null;

        try {
            connection = DB.getInstance().getConnection();
            String query = "SELECT * FROM classname JOIN keyword ON classname.id = keyword.binded_class" +
                    " WHERE keyword.keyword = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, keyword);
            resultSet = statement.executeQuery();

            if(resultSet.next()) {
                result = new ClassName();
                result.setName(resultSet.getString("classname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.getInstance().close(connection, statement, resultSet);
        }

        return result;
    }
}
