package haladesign.repository;

import haladesign.model.SanPhamChiTiet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author NONG HOANG VU
 */
public interface ISanPhamChiTiet extends JpaRepository<SanPhamChiTiet, Long> {

    @Query("SELECT bienThe FROM SanPhamChiTiet bienThe "
            + "LEFT JOIN FETCH bienThe.size size "
            + "LEFT JOIN FETCH bienThe.color color "
            + "LEFT JOIN FETCH bienThe.chatLieu chatLieu "
            + "LEFT JOIN FETCH bienThe.id_san_pham sanPham "
            + "WHERE sanPham.id = :productId")
    List<SanPhamChiTiet> findByIdSanPhamBienThe(@Param("productId") String productId);

    @Query("SELECT bienThe FROM SanPhamChiTiet bienThe "
            + "LEFT JOIN FETCH bienThe.size size "
            + "LEFT JOIN FETCH bienThe.color color "
            + "LEFT JOIN FETCH bienThe.chatLieu chatLieu "
            + "LEFT JOIN FETCH bienThe.id_san_pham sanPham "
            + "WHERE bienThe.id = :productId")
    SanPhamChiTiet findByIdSanPhamBienTheFirstItem(@Param("productId") String productId);

    @Query("SELECT bienThe FROM SanPhamChiTiet bienThe "
            + "LEFT JOIN FETCH bienThe.size size "
            + "LEFT JOIN FETCH bienThe.color color "
            + "LEFT JOIN FETCH bienThe.chatLieu chatLieu "
            + "LEFT JOIN FETCH bienThe.id_san_pham sanPham "
            + "WHERE sanPham.id = :productId AND size.loaiSize = :targetSize AND color.loaiMau = :targetColor AND chatLieu.loaiChatLieu = :targetChatLieu")
    List<SanPhamChiTiet> findBySizeAndColorAndChatLieu(@Param("productId") String productId, @Param("targetSize") String targetSize, @Param("targetColor") String targetColor, @Param("targetChatLieu") String targetChatLieu);

    @Query("SELECT bienThe FROM SanPhamChiTiet bienThe "
            + "LEFT JOIN FETCH bienThe.size size "
            + "LEFT JOIN FETCH bienThe.color color "
            + "LEFT JOIN FETCH bienThe.chatLieu chatLieu "
            + "LEFT JOIN FETCH bienThe.id_san_pham sanPham "
            + "WHERE sanPham.id = :productId AND size.loaiSize = :targetSize AND color.loaiMau = :targetColor AND chatLieu.loaiChatLieu = :targetChatLieu")
    public SanPhamChiTiet findByThuocTinh(@Param("productId") String productId, @Param("targetSize") String targetSize, @Param("targetColor") String targetColor, @Param("targetChatLieu") String targetChatLieu);
}
