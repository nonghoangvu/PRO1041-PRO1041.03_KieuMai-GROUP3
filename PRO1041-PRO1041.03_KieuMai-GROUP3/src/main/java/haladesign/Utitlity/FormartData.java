package haladesign.Utitlity;

import java.text.DecimalFormat;

/**
 *
 * @author NONG HOANG VU
 */
public class FormartData {

    public FormartData() {
    }

    public String moneyFormat(Integer number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }
    public String moneyFormatLong(Long number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }
}
