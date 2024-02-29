package haladesign.Utitlity.model;

import com.itextpdf.kernel.color.Color;
import haladesign.Utitlity.ConstantUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 *
 * @author NONG HOANG VU
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HeaderDetails {
    String logoTitle= ConstantUtil.LOGO_TITLE;
    String invoiceCode=ConstantUtil.INVOICE_CODE;
    String invoiceDateText=ConstantUtil.INVOICE_DATE_TEXT;
    String invoiceNo=ConstantUtil.EMPTY;
    String invoiceDate=ConstantUtil.EMPTY;
    Color borderColor=Color.GRAY;

    public HeaderDetails setLogoTitle(String invoiceTitle) {
        this.logoTitle = invoiceTitle;
        return this;
    }

    public HeaderDetails setInvoiceCode(String invoiceNoText) {
        this.invoiceCode = invoiceNoText;
        return this;
    }

    public HeaderDetails setInvoiceDateText(String invoiceDateText) {
        this.invoiceDateText = invoiceDateText;
        return this;
    }

    public HeaderDetails setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
        return this;
    }

    public HeaderDetails setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
        return this;
    }

    public HeaderDetails setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        return this;
    }
    public HeaderDetails build()
    {
        return  this;
    }
}
