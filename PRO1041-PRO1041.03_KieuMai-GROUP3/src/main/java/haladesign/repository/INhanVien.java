package haladesign.repository;

import haladesign.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BinhQuoc
 */
public interface INhanVien extends JpaRepository<NhanVien, Integer>{
    
}
