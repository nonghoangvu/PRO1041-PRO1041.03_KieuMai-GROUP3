package haladesign.repository;

import haladesign.model.KhachHang;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Phương Thảo
 */
public interface IKhachHang extends JpaRepository<KhachHang, Integer> {

    public KhachHang getKhachHangById(Integer id);

    @Query("SELECT kh FROM KhachHang kh WHERE kh.ho_ten LIKE %:searchTerm% OR kh.so_dien_thoai LIKE %:searchTerm%")
    public List<KhachHang> searchByNameOrPhoneNumber(@Param("searchTerm") String searchTerm);

    @Query("SELECT kh FROM KhachHang kh WHERE kh.so_dien_thoai LIKE %:phone%")
    public KhachHang findByPhoneNumber(@Param("phone") String phone);
}
