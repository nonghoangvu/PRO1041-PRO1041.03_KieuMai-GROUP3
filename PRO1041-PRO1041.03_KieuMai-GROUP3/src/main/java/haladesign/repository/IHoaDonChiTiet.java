package haladesign.repository;

import haladesign.model.JPAHoaDonChiTiet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author NONG HOANG VU
 */
public interface IHoaDonChiTiet extends JpaRepository<JPAHoaDonChiTiet, Integer> {

    @Query("SELECT ct FROM JPAHoaDonChiTiet ct LEFT JOIN FETCH ct.hoaDon hd WHERE hd.id = :id")
    public List<JPAHoaDonChiTiet> findById(@Param("id") String id);

    @Query("SELECT ct FROM JPAHoaDonChiTiet ct LEFT JOIN FETCH ct.sanPhamChiTiet sp LEFT JOIN FETCH ct.hoaDon hd WHERE hd.id = :idHoaDon AND sp.id = :idSanPham")
    public JPAHoaDonChiTiet checkProductAlreadyExists(@Param("idHoaDon") String idHoaDon, @Param("idSanPham") String idSanPham);
}
