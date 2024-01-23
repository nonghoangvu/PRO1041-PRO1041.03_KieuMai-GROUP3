package haladesign.repository;

import haladesign.model.SanPhamBienThe;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author NONG HOANG VU
 */
public interface ISanPhamBienThe extends JpaRepository<SanPhamBienThe, Long>{
     @Query("SELECT bienThe FROM SanPhamBienThe bienThe "
            + "LEFT JOIN FETCH bienThe.size size "
            + "LEFT JOIN FETCH bienThe.color color "
            + "LEFT JOIN FETCH bienThe.id_san_pham sanPham "
            + "WHERE sanPham.id = :productId")
    List<SanPhamBienThe> findByIdSanPhamBienThe(@Param("productId") String productId);
}
