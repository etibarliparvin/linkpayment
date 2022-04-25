package az.yigim.linkpayment.repository.userRepository;

import az.yigim.linkpayment.entity.concretes.User;
import az.yigim.linkpayment.utils.context.BeanContext;
import az.yigim.linkpayment.utils.dbConnection.DbConnectionInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepositoryImpl implements UserRepositoryInter{

    private final DbConnectionInter connection = BeanContext.dbConnectionImpl();

    @Override
    public User findByUsernameAndPassword(String username, String password) throws Exception {
        User user = null;
        String sql = "select * from istifadeci where username = ? and password = ?";
        Connection c = connection.connect();
        PreparedStatement statement = c.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        statement.execute();
        ResultSet rs = statement.getResultSet();
        if (rs.next()) {
            Integer id = rs.getInt("id");
            String foundUsername = rs.getString("username");
            String foundPassword = rs.getString("password");
            user = new User(id, foundUsername, foundPassword);
        }
        return user;
    }
}
