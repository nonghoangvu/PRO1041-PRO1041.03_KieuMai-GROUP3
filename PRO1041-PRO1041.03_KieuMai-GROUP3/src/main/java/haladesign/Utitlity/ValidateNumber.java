package haladesign.Utitlity;

/**
 *
 * @author NONG HOANG VU
 */
public class ValidateNumber {

    public ValidateNumber() {
    }

    public Boolean isNumber(String number) {
        try {
            Long.valueOf(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
