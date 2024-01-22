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
            Integer.valueOf(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
