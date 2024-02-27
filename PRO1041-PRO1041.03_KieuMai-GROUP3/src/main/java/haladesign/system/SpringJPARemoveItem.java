package haladesign.system;

import haladesign.config.JDBC_Connect;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author NONG HOANG VU
 */
public class SpringJPARemoveItem {

    public SpringJPARemoveItem() {
    }

    public void removeById(Integer id) {
        try {
            PreparedStatement ps = JDBC_Connect.getConnection().prepareStatement("DELETE FROM HoaDonChiTiet WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    public void removeByIdHoaDon(Integer id) {
        try {
            PreparedStatement ps = JDBC_Connect.getConnection().prepareStatement("DELETE FROM HoaDonChiTiet WHERE id_hoa_don = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    public void removeHoaDonById(Integer id) {
        try {
            PreparedStatement ps = JDBC_Connect.getConnection().prepareStatement("DELETE FROM HoaDon WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}
