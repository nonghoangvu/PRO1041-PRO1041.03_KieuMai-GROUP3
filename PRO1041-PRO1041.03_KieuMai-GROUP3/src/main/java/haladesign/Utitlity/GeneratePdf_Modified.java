package haladesign.Utitlity;

import haladesign.Utitlity.model.CustomerInformation;
import haladesign.Utitlity.model.HeaderDetails;
import haladesign.Utitlity.model.Product;
import haladesign.Utitlity.model.ProductTableHeader;
import haladesign.Utitlity.service.CodingErrorPdfInvoiceCreator;
import haladesign.model.JPAHoaDon;
import haladesign.model.JPAHoaDonChiTiet;
import haladesign.model.KhachHang;
import haladesign.service.BillService;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NONG HOANG VU
 */
public class GeneratePdf_Modified {

    private final BillService bill;

    public GeneratePdf_Modified() {
        this.bill = new BillService();
    }

    public void printBill(String id) {
        JPAHoaDon hoaDon = this.bill.getJPAHoaDonById(id);
        KhachHang kh = new KhachHang();
        kh.setHo_ten("KHACH LE");
        kh.setSo_dien_thoai("SO DIEN THOAI TRONG");
        if (hoaDon.getKhachHang() == null) {
            hoaDon.setKhachHang(kh);
        }
        try {
            LocalDate ld = LocalDate.now();
            String pdfName = "NHV-HD" + id + "-" + ld + ".pdf";
            CodingErrorPdfInvoiceCreator cepdf = new CodingErrorPdfInvoiceCreator(pdfName);
            cepdf.createDocument();
            HeaderDetails header = new HeaderDetails();
            header.setInvoiceNo(String.valueOf(hoaDon.getId())).setInvoiceDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))).build();
            cepdf.createHeader(header);
            CustomerInformation customer = new CustomerInformation();
            customer.setPhoneItem(hoaDon.getKhachHang().getSo_dien_thoai());
            customer.setCustomerNameItem(hoaDon.getKhachHang().getHo_ten());
            customer.setCustomerMoney(new FormartData().moneyFormatLong(hoaDon.getTienDua()));
            customer.setExcessCash(new FormartData().moneyFormatLong(hoaDon.getTienThua()));
            cepdf.createCustomer(customer);
            ProductTableHeader productTableHeader = new ProductTableHeader();
            cepdf.createTableHeader(productTableHeader);
            List<Product> productList = new ArrayList<>();
            for (JPAHoaDonChiTiet hoaDonChiTiet : hoaDon.getHoaDonChiTiets()) {
                productList.add(new Product(hoaDonChiTiet.getSanPhamChiTiet().getId_san_pham().getTen_san_pham() + " " + hoaDonChiTiet.getSanPhamChiTiet().getTenBienThe(), hoaDonChiTiet.getSoLuong(), hoaDonChiTiet.getSanPhamChiTiet().getGia()));
            }
            productList = cepdf.modifyProductList(productList);
            cepdf.createProduct(productList);
            cepdf.createTnc();
        } catch (FileNotFoundException e) {
            System.out.println("Error call Nong Hoang Vu Right now!");
        }
    }
}
