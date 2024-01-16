package haladesign.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author NONG HOANG VU
 */
@Entity
@Table(name = "SanPhamHinhAnh")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SanPhamHinhAnh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_san_pham_bien_the")
    private SanPhamBienThe sanPhamBienThe;

    @ManyToOne
    @JoinColumn(name = "id_hinh_anh")
    private HinhAnh hinhAnh;
}
