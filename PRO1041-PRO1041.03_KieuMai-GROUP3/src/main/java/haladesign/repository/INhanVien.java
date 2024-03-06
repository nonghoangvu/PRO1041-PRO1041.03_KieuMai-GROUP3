package haladesign.repository;

import haladesign.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author BinhQuoc
 */
public interface INhanVien extends JpaRepository<Account, Integer>{
    @Query("SELECT nv FROM Account nv WHERE nv.phoneNum = :sdt AND nv.userState NOT LIKE 'deleted'")
    Account findBySdtAndNotDeleted(@Param("sdt") String sdt);
}
