package haladesign.Utitlity.service;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.DashedBorder;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import haladesign.Utitlity.FormartData;
import haladesign.Utitlity.model.CustomerInformation;
import haladesign.Utitlity.model.HeaderDetails;
import haladesign.Utitlity.model.MyFooter;
import haladesign.Utitlity.model.Product;
import haladesign.Utitlity.model.ProductTableHeader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author NONG HOANG VU
 */
public class CodingErrorPdfInvoiceCreator {

    Document document;
    PdfDocument pdfDocument;
    String pdfName;
    float threecol = 190f;
    float twocol = 285f;
    float twocol150 = twocol + 150f;
    float twocolumnWidth[] = {twocol150, twocol};
    float threeColumnWidth[] = {threecol, threecol, threecol};
    float fullwidth[] = {threecol * 3};

    public CodingErrorPdfInvoiceCreator(String pdfName) {
        this.pdfName = pdfName;
    }

    public void createDocument() throws FileNotFoundException {
        PdfWriter pdfWriter = new PdfWriter(pdfName);
        pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        this.document = new Document(pdfDocument);
    }

    public void createTnc() {
        List<String> TncList = new ArrayList<>();
        if (false) {
            float threecol = 190f;
            float fullwidth[] = {threecol * 3};
            Table tb = new Table(fullwidth);
            for (String tnc : TncList) {

                tb.addCell(new Cell().add(tnc).setBorder(Border.NO_BORDER));
            }

            document.add(tb);
        } else {
            pdfDocument.addEventHandler(PdfDocumentEvent.END_PAGE, new MyFooter(document, TncList));
        }

        document.close();
    }

    public void createProduct(List<Product> productList) {
        float threecol = 190f;
        float fullwidth[] = {threecol * 3};
        Table threeColTable2 = new Table(threeColumnWidth);
        Long totalSum = getTotalSum(productList);
        for (Product product : productList) {
            Long total = product.getQuantity() * product.getPriceperpeice();
            threeColTable2.addCell(new Cell().add(product.getPname().orElse("")).setBorder(Border.NO_BORDER)).setMarginLeft(10f);
            threeColTable2.addCell(new Cell().add(String.valueOf(product.getQuantity())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
            threeColTable2.addCell(new Cell().add(String.valueOf(new FormartData().moneyFormatLong(total))).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER)).setMarginRight(15f);
        }

        document.add(threeColTable2.setMarginBottom(20f));
        float onetwo[] = {threecol + 125f, threecol * 2};
        Table threeColTable4 = new Table(onetwo);
        threeColTable4.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
        threeColTable4.addCell(new Cell().add(fullwidthDashedBorder(fullwidth)).setBorder(Border.NO_BORDER));
        document.add(threeColTable4);

        Table threeColTable3 = new Table(threeColumnWidth);
        threeColTable3.addCell(new Cell().add("").setBorder(Border.NO_BORDER)).setMarginLeft(10f);
        threeColTable3.addCell(new Cell().add("TONG TIEN").setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
        threeColTable3.addCell(new Cell().add(String.valueOf(new FormartData().moneyFormatLong(totalSum))).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER)).setMarginRight(15f);

        document.add(threeColTable3);
        document.add(fullwidthDashedBorder(fullwidth));
        document.add(new Paragraph("\n"));
        document.add(getDividerTable(fullwidth).setBorder(new SolidBorder(Color.GRAY, 1)).setMarginBottom(15f));
    }

    public Long getTotalSum(List<Product> productList) {
        return (Long) productList.stream().mapToLong((p) -> (Long) (p.getQuantity() * p.getPriceperpeice())).sum();
    }

    public void createTableHeader(ProductTableHeader productTableHeader) {
        Paragraph producPara = new Paragraph("DANH SACH MUA HANG");
        document.add(producPara.setBold());
        Table threeColTable1 = new Table(threeColumnWidth);
        threeColTable1.setBackgroundColor(Color.BLACK, 0.7f);

        threeColTable1.addCell(new Cell().add("TEN SAN PHAM").setBold().setFontColor(Color.WHITE).setBorder(Border.NO_BORDER));
        threeColTable1.addCell(new Cell().add("SO LUONG").setBold().setFontColor(Color.WHITE).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
        threeColTable1.addCell(new Cell().add("GIA").setBold().setFontColor(Color.WHITE).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER)).setMarginRight(15f);
        document.add(threeColTable1);
    }

    public void createCustomer(CustomerInformation customer) {
        Table twoColTable = new Table(twocolumnWidth);
        twoColTable.addCell(getBillingandShippingCell(customer.getCustomerInfo()));
        document.add(twoColTable.setMarginBottom(12f));

        Table twoColTable3 = new Table(twocolumnWidth);
        twoColTable3.addCell(getCell10fLeft(customer.getPhoneTitle(), true));
        document.add(twoColTable3);
        float oneColoumnwidth[] = {twocol150};

        Table oneColTable1 = new Table(oneColoumnwidth);
        oneColTable1.addCell(getCell10fLeft(customer.getPhoneItem(), false));
        oneColTable1.addCell(getCell10fLeft(customer.getCustomerTitle(), true));
        oneColTable1.addCell(getCell10fLeft(customer.getCustomerNameItem(), false));

        oneColTable1.addCell(getCell10fLeft(customer.getCustomerMoneyTile(), true));
        oneColTable1.addCell(getCell10fLeft(customer.getCustomerMoney(), false));

        oneColTable1.addCell(getCell10fLeft(customer.getExcessCashTilte(), true));
        oneColTable1.addCell(getCell10fLeft(customer.getExcessCash(), false));
        document.add(oneColTable1.setMarginBottom(10f));
        document.add(fullwidthDashedBorder(fullwidth));
    }

    public void createHeader(HeaderDetails header) {
        Table table = new Table(twocolumnWidth);
        table.addCell(new Cell().add(header.getLogoTitle()).setFontSize(20f).setBorder(Border.NO_BORDER).setBold());
        Table nestedtabe = new Table(new float[]{twocol / 2, twocol / 2});
        nestedtabe.addCell(getHeaderTextCell(header.getInvoiceCode()));
        nestedtabe.addCell(getHeaderTextCellValue(header.getInvoiceNo()));
        nestedtabe.addCell(getHeaderTextCell(header.getInvoiceDateText()));
        nestedtabe.addCell(getHeaderTextCellValue(header.getInvoiceDate()));
        table.addCell(new Cell().add(nestedtabe).setBorder(Border.NO_BORDER));
        Border gb = new SolidBorder(header.getBorderColor(), 2f);
        document.add(table);
        document.add(getNewLineParagraph());
        document.add(getDividerTable(fullwidth).setBorder(gb));
        document.add(getNewLineParagraph());
    }

    public List<Product> modifyProductList(List<Product> productList) {
        Map<String, Product> map = new HashMap<>();
        productList.forEach((i) -> {
            if (map.containsKey(i.getPname().orElse(""))) {
                i.setQuantity(map.getOrDefault(i.getPname().orElse(""), null).getQuantity() + i.getQuantity());
                map.put(i.getPname().orElse(""), i);
            } else {
                map.put(i.getPname().orElse(""), i);
            }
        });
        return map.values().stream().collect(Collectors.toList());

    }

    static Table getDividerTable(float[] fullwidth) {
        return new Table(fullwidth);
    }

    static Table fullwidthDashedBorder(float[] fullwidth) {
        Table tableDivider2 = new Table(fullwidth);
        Border dgb = new DashedBorder(Color.GRAY, 0.5f);
        tableDivider2.setBorder(dgb);
        return tableDivider2;
    }

    static Paragraph getNewLineParagraph() {
        return new Paragraph("\n");
    }

    static Cell getHeaderTextCell(String textValue) {

        return new Cell().add(textValue).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);
    }

    static Cell getHeaderTextCellValue(String textValue) {

        return new Cell().add(textValue).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
    }

    static Cell getBillingandShippingCell(String textValue) {

        return new Cell().add(textValue).setFontSize(12f).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
    }

    static Cell getCell10fLeft(String textValue, Boolean isBold) {
        Cell myCell = new Cell().add(textValue).setFontSize(10f).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
        return isBold ? myCell.setBold() : myCell;

    }
}
