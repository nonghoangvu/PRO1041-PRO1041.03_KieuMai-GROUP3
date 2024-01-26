package haladesign.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author NONG HOANG VU
 */
@Entity
@Table(name = "Size")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "loai_size", nullable = false)
    private String loaiSize;

    @Column(name = "trang_thai", columnDefinition = "BIT DEFAULT 1")
    private Boolean trangThai;

    @Column(name = "ngay_tao", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date ngayTao;

    @OneToMany(mappedBy = "size")
    private List<SanPhamBienThe> sanPhamBienTheList;

    @Override
    public String toString() {
        return loaiSize;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.loaiSize);
        hash = 17 * hash + Objects.hashCode(this.trangThai);
        hash = 17 * hash + Objects.hashCode(this.ngayTao);
        hash = 17 * hash + Objects.hashCode(this.sanPhamBienTheList);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Size other = (Size) obj;
        if (!Objects.equals(this.loaiSize, other.loaiSize)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.trangThai, other.trangThai)) {
            return false;
        }
        if (!Objects.equals(this.ngayTao, other.ngayTao)) {
            return false;
        }
        return Objects.equals(this.sanPhamBienTheList, other.sanPhamBienTheList);
    }

    public Size(String loaiSize) {
        this.loaiSize = loaiSize;
    }

    
}
