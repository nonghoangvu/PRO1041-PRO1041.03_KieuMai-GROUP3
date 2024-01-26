package haladesign.repository;

import haladesign.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author NONG HOANG VU
 */
public interface IColor extends JpaRepository<Color, Long> {

    @Query("SELECT c FROM Color c WHERE c.loaiMau = :loaiMau")
    public Color findByLoaiMau(@Param("loaiMau") String loaiMau);
}
