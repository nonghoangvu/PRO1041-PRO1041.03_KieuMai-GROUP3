package haladesign.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author NONG HOANG VU
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "SanPhamBienThe")
public class SanPhamBienThe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_san_pham", referencedColumnName = "id")
    private SanPham id_san_pham;

    @Column(name = "ten_bien_the", nullable = false)
    private String tenBienThe;

    @ManyToOne
    @JoinColumn(name = "id_size")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "id_color")
    private Color color;

    @Column(name = "so_luong", columnDefinition = "INT DEFAULT 0")
    private Integer soLuong = 0;

    @Column(name = "gia", nullable = false, columnDefinition = "INT CHECK (gia >= 0)")
    private Integer gia;

    @OneToMany(mappedBy = "sanPhamBienThe", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SanPhamHinhAnh> sanPhamHinhAnhList;
}
