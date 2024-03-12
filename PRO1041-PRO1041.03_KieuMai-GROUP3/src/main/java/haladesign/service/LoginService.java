package haladesign.service;
import haladesign.model.Account;
import haladesign.repository.IAccount;
import org.springframework.data.repository.query.Param;

import static haladesign.Application.getBean;

public class LoginService {
    public static IAccount account = getBean(IAccount.class);
    public static Account getLoginAccount(String phoneNum) {
        return LoginService.account.getUser(phoneNum);
    }
}
