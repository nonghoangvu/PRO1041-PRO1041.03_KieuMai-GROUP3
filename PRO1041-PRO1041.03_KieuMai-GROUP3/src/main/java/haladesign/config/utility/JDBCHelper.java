package haladesign.config.utility;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCHelper {

    public static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String url = """
                                        jdbc:sqlserver://localhost:1433;databaseName=HalaDesign;
                                        encrypt=true;trustServerCertificate=true;""";
    public static final String user = "sa";
    public static final String password = "123";
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCHelper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi Driver");
            ex.printStackTrace();
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        
        Connection cn = DriverManager.getConnection(url, user, password);
        PreparedStatement pstmt;
        if (sql.trim().startsWith("{")) {
            pstmt = cn.prepareCall(sql);
        } else {
            pstmt = cn.prepareStatement(sql); //SQL
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt; 
    }
    public static ResultSet query(String sql, Object... args) throws SQLException {
        PreparedStatement pstmt = JDBCHelper.getStmt(sql, args);
        return pstmt.executeQuery(); //C2
    }
    public static Object value(String sql, Object... args) throws SQLException {
        ResultSet rs = JDBCHelper.query(sql, args);
        Object result = null; //khai báo biến có lưu giá trị trả về.
        if (rs.next()) {
            return rs.getObject(1);
        }
        rs.getStatement().getConnection().close(); // đóng kết nối
        return result; //trả về biến result. 
    }
    public static int update(String sql, Object... args) {
        try {
            PreparedStatement stmt = JDBCHelper.getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }
}
