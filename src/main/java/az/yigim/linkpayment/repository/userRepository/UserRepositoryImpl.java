package az.yigim.linkpayment.repository.userRepository;

import az.yigim.linkpayment.entity.concretes.User;
import az.yigim.linkpayment.utils.encrypter.MyEncrypterImpl;
import az.yigim.linkpayment.utils.context.BeanContext;
import az.yigim.linkpayment.utils.dbConnection.DbConnectionInter;
import az.yigim.linkpayment.utils.encrypter.MyEncrypterInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepositoryImpl implements UserRepositoryInter {

    private final DbConnectionInter connection = BeanContext.dbConnectionImpl();
    private final MyEncrypterInter encrypter = BeanContext.encrypterImpl();

    @Override
    public User findByUsernameAndPassword(String username, String password) throws Exception {
        User user = findByUsername(username);
        if (user != null) {
            String salt = user.getSalt();
            byte[] bytes = encrypter.decode(salt);
            String encryptedUserPassword = encrypter.encode(encrypter.generateHash(password, bytes));
            if (encryptedUserPassword.equals(user.getPassword()))
                return user;
        }
        return null;
    }

    private User findByUsername(String username) throws Exception {
        User user = null;
        String sql = "select * from istifadeci where username = ?";
        Connection c = connection.connect();
        PreparedStatement statement = c.prepareStatement(sql);
        if (username != null && !username.trim().isEmpty())
            statement.setString(1, username);
        statement.execute();
        ResultSet rs = statement.getResultSet();
        if (rs.next()) {
            Integer id = rs.getInt("id");
            String foundUsername = rs.getString("username");
            String foundPassword = rs.getString("password");
            String foundSalt = rs.getString("salt");
            user = new User(id, foundUsername, foundPassword, foundSalt);
        }
        return user;
    }
}
