package haladesign.repository;

import haladesign.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author NONG HOANG VU
 */
public interface ISanPham extends JpaRepository<SanPham, String>{
    
}
