package haladesign.repository;

import haladesign.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author NONG HOANG VU
 */
public interface ISize extends JpaRepository<Size, Long> {

    @Query("SELECT s FROM Size s WHERE s.loaiSize = :loaiSize")
    public Size findByLoaiSize(@Param("loaiSize") String loaiSize);
    
}
