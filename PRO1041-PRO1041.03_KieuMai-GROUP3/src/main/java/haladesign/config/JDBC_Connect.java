package haladesign.config;

import haladesign.Utitlity.BcryptHash;
import haladesign.system.DataConfigSerializationUtil;
import haladesign.system.DatabaseConfig;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author NONG HOANG VU
 */
public class JDBC_Connect {

    private static final DatabaseConfig config = new DataConfigSerializationUtil().readConfigInfoFromFile();
    private static final BcryptHash bcryptHash = new BcryptHash();

    public static java.sql.Connection getConnection() {
        String connectionUrl = "jdbc:sqlserver://" + bcryptHash.decodeBase64(config.getServer()) + ":" + bcryptHash.decodeBase64(config.getPort()) + ";"
                + "databaseName=" + bcryptHash.decodeBase64(config.getDatabase_name()) + ";encrypt=true;trustservercertificate=true;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(connectionUrl, bcryptHash.decodeBase64(config.getUsername()), bcryptHash.decodeBase64(config.getPassword()));

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
