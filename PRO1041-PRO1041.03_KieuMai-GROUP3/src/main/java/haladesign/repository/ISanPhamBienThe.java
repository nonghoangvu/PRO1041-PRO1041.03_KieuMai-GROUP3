package haladesign.repository;

import haladesign.model.SanPhamBienTheKhoa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author NONG HOANG VU
 */
public interface ISanPhamBienThe extends JpaRepository<SanPhamBienTheKhoa, Long>{
    @Query("SELECT sp FROM SanPham sp "
            + "LEFT JOIN FETCH sp.bienTheList bienThe "
            + "LEFT JOIN FETCH bienThe.size size "
            + "LEFT JOIN FETCH bienThe.color color "
            + "WHERE sp.id = :productId")
    List<SanPhamBienTheKhoa> findByIdSanPham(@Param("productId") String productId);
}
