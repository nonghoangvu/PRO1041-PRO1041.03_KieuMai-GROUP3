package haladesign.repository;

import haladesign.model.JPAHoaDon;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author NONG HOANG VU
 */
public interface IHoaDon extends JpaRepository<JPAHoaDon, Integer> {

    @Query("SELECT h FROM JPAHoaDon h WHERE h.khachHang.id = :khachHangId")
    public List<JPAHoaDon> findByKhachHangId(@Param("khachHangId") Integer khachHangId);

    @Query("SELECT hd FROM JPAHoaDon hd WHERE hd.trangThai LIKE :trangThai")
    public List<JPAHoaDon> findBillPending(@Param("trangThai") String trangThai);
    
    @Query("SELECT hd FROM JPAHoaDon hd WHERE hd.id = :id")
    public JPAHoaDon findById(@Param("id") String id);

}
