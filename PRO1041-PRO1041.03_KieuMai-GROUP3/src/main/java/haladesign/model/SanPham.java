package haladesign.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author NONG HOANG VU
 */
@Entity
@Table(name = "SanPham")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SanPham {

    @Id
    private String id;

    @Column(name = "ten_san_pham")
    private String ten_san_pham;

    @Column(name = "thuong_hieu")
    private String thuong_hieu;

    @Column(name = "mo_ta")
    private String mo_ta;

    @Column(name = "trang_thai")
    private Boolean trang_thai;

    @Column(name = "ngay_tao")
    private Date ngay_tao;

    @Column(name = "id_nhan_vien")
    private Integer id_nhan_vien;
}
