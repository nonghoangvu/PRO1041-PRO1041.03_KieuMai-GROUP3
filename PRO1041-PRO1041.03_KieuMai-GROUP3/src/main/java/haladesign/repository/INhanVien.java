package haladesign.repository;

import haladesign.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author BinhQuoc
 */
public interface INhanVien extends JpaRepository<NhanVien, Integer>{
    @Query("SELECT nv FROM NhanVien nv WHERE nv.phoneNum = :sdt AND nv.userState NOT LIKE 'deleted'")
    NhanVien findBySdtAndNotDeleted(@Param("sdt") String sdt);
}
