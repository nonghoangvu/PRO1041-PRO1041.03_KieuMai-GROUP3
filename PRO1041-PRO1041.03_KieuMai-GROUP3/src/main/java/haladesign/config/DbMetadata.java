package haladesign.config;

import haladesign.Utitlity.BcryptHash;
import haladesign.system.DataConfigSerializationUtil;
import haladesign.system.DatabaseConfig;

public final class DbMetadata {

    private static final String CONNECT_STRING;
    private static final DatabaseConfig config = new DataConfigSerializationUtil().readConfigInfoFromFile();
    private static final BcryptHash bcryptHash = new BcryptHash();

    static {
        StringBuilder connectStringBuilder = new StringBuilder();
        connectStringBuilder.append("jdbc:sqlserver://")
                .append(bcryptHash.decodeBase64(config.getServer())).append(":").append(bcryptHash.decodeBase64(config.getPort())).append(";")
                .append("databaseName=").append(bcryptHash.decodeBase64(config.getDatabase_name())).append(";")
                .append("user=").append(bcryptHash.decodeBase64(config.getUsername())).append(";")
                .append("password=").append("khoa710a").append(";");
        if (config.getUsing_ssl()) {
            connectStringBuilder.append("encrypt=true;trustServerCertificate=true;");
        }
        CONNECT_STRING = connectStringBuilder.toString();
    }

    public static String getConnectString() {
        System.out.println(CONNECT_STRING);
        return CONNECT_STRING;
    }
}
//bcryptHash.decodeBase64(config.getPassword())