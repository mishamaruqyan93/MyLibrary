package manager;

import db.DBConnectionProvider;
import model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorManager {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();

    public void addAuthor(Author author) {
        String sql = "Insert into author(name,surname,email,age,profile_pic) Values (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getSurName());
            preparedStatement.setString(3, author.getEmail());
            preparedStatement.setInt(4, author.getAge());
            preparedStatement.setString(5, author.getProfilePic());
            preparedStatement.executeLargeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Author getById(int id) {
        String sql = "SELECT * FROM author WHERE id =" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return getUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Author> getAll() {
        String sql = "SELECT * FROM author";
        List<Author> authors = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                authors.add(getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    private Author getUserFromResultSet(ResultSet resultSet) throws SQLException {
        Author author = new Author();
        author.setId(resultSet.getInt(1));
        author.setName(resultSet.getString("name"));
        author.setSurName(resultSet.getString("surname"));
        author.setEmail(resultSet.getString("email"));
        author.setAge(resultSet.getInt(5));
        author.setProfilePic(resultSet.getString("profile_pic"));
        return author;
    }

    public void removeAuthorById(int authorId) {
        String sql = "Delete from auhtor where id = " + authorId;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(Author author) {
        String sql = "Update  author set name=?,surname=?,email=?,age=?,profile_pic=? WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getSurName());
            preparedStatement.setString(3, author.getEmail());
            preparedStatement.setInt(4, author.getAge());
            preparedStatement.setInt(5, author.getId());
            preparedStatement.setString(6,author.getProfilePic());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
