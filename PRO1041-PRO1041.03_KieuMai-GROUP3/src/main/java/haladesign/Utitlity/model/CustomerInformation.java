package haladesign.Utitlity.model;

import haladesign.Utitlity.ConstantUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author NONG HOANG VU
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerInformation {

    private String customerInfo = ConstantUtil.CUSTOMER_INFO;
    private String customerTitle = ConstantUtil.CUSTOMER_TITLE;
    private String phoneTitle = ConstantUtil.PHONE_TITLE;
    private String phoneItem = ConstantUtil.EMPTY;
    private String customerNameItem = ConstantUtil.EMPTY;
    private String excessCashTilte  = ConstantUtil.EXCESS_CASH;
    private String customerMoneyTile  = ConstantUtil.CUSTOMER_MONEY;
    private String excessCash  = ConstantUtil.EMPTY;
    private String customerMoney  = ConstantUtil.EMPTY;
}
