package haladesign.repository;

import haladesign.model.NhanVien;
import haladesign.model.QuyenHan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author BinhQuoc
 */
public interface IQuyenHan extends JpaRepository<QuyenHan, Integer>{
    @Query("SELECT nv FROM QuyenHan nv WHERE nv.roleName = :ten_quyen_han")
    QuyenHan findByName(@Param("ten_quyen_han") String ten_quyen_han);
}
