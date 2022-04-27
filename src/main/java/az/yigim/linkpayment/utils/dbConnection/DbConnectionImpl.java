package az.yigim.linkpayment.utils.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DbConnectionImpl implements DbConnectionInter {

//    @Override
//    public Connection connect() throws Exception {
//        ResourceBundle bundle = ResourceBundle.getBundle("configurations.configuration");
//        Class.forName(bundle.getString("name"));
//        String url = bundle.getString("url");
//        String username = bundle.getString("username");
//        String password = bundle.getString("password");
//        return DriverManager.getConnection(url, username, password);
//    }

    @Override
    public Connection connect() throws Exception {
//        ResourceBundle bundle = ResourceBundle.getBundle("configurations.configuration");
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/linkpay";
        String username = "postgres";
        String password = "112358";
        return DriverManager.getConnection(url, username, password);
    }
}
