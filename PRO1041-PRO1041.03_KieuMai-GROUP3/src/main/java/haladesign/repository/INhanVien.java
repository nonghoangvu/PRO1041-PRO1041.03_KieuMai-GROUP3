package haladesign.repository;

import haladesign.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Nong Hoang Vu
 */
public interface INhanVien extends JpaRepository<Account, Integer>{
    @Query("SELECT ac FROM Account ac WHERE ac.phoneNum = :phoneNum AND ac.password = :password")
    NhanVien checkLoginWithNumberPhone(@Param("phoneNum") String phoneNum, @Param("password") String password);
}
