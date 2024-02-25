package haladesign.repository;

import haladesign.model.SanPham;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author NONG HOANG VU
 */
public interface ISanPham extends JpaRepository<SanPham, String> {

    @Query("SELECT sp FROM SanPham sp "
            + "LEFT JOIN FETCH sp.bienTheList bienThe "
            + "LEFT JOIN FETCH bienThe.size size "
            + "LEFT JOIN FETCH bienThe.color color "
            + "WHERE sp.id = :productId")
    List<SanPham> findByIdSanPham(@Param("productId") String productId);

    @Override
    @Query("SELECT sp FROM SanPham sp WHERE sp.trang_thai = TRUE")
    public List<SanPham> findAll();

    @Query("SELECT sp FROM SanPham sp")
    public List<SanPham> findAllStatus();

    @Query("SELECT sp FROM SanPham sp WHERE sp.trang_thai = FALSE")
    public List<SanPham> findAllStatusIsOff();

    @Query("SELECT sp FROM SanPham sp WHERE (sp.id LIKE %:search% OR sp.ten_san_pham LIKE %:search%) AND sp.trang_thai = :status")
    public List<SanPham> findByIdAndName(@Param("search") String search, @Param("status") Boolean status);

    @Query("SELECT sp FROM SanPham sp "
            + "LEFT JOIN FETCH sp.bienTheList bienThe "
            + "LEFT JOIN FETCH bienThe.size size "
            + "LEFT JOIN FETCH bienThe.color color "
            + "WHERE sp.id = :productId")
    SanPham findSanPham(@Param("productId") String productId);
}
