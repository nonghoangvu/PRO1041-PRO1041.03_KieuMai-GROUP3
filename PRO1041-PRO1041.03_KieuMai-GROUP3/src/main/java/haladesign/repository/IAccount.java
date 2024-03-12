package haladesign.repository;

import haladesign.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Nong Hoang Vu
 */
public interface IAccount extends JpaRepository<Account, Integer>{
    @Query("SELECT ac FROM Account ac WHERE ac.phoneNum = :phoneNum")
    Account getUser(@Param("phoneNum") String phoneNum);
}
