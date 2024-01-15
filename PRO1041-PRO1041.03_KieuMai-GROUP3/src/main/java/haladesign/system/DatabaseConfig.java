package haladesign.system;

import java.io.Serializable;

/**
 *
 * @author NONG HOANG VU
 */
public class DatabaseConfig implements Serializable{

    private String username;
    private String password;
    private String server;
    private String port;
    private String database_name;
    private Boolean using_ssl;

    public DatabaseConfig() {
    }

    public DatabaseConfig(String username, String password, String server, String port, String database_name, Boolean using_ssl) {
        this.username = username;
        this.password = password;
        this.server = server;
        this.port = port;
        this.database_name = database_name;
        this.using_ssl = using_ssl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDatabase_name() {
        return database_name;
    }

    public void setDatabase_name(String database_name) {
        this.database_name = database_name;
    }

    public Boolean getUsing_ssl() {
        return using_ssl;
    }

    public void setUsing_ssl(Boolean using_ssl) {
        this.using_ssl = using_ssl;
    }

}
