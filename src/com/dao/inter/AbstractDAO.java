package com.dao.inter;

import com.database.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author suret
 */
public abstract class AbstractDAO {

    public Connection getConnect() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(Database.DB_URL, Database.DB_USERNAME, Database.DB_PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }

}
