package az.yigim.linkpayment.utils.dbConnection;

import java.sql.Connection;

public interface DbConnectionInter {

    Connection connect() throws Exception;

}
