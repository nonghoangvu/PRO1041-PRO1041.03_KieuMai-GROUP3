package haladesign.service;

import org.springframework.beans.factory.annotation.Autowired;
import static haladesign.Application.getBean;
import haladesign.model.JPAHoaDon;
import haladesign.model.JPAHoaDonChiTiet;
import haladesign.model.KhachHang;
import haladesign.model.SanPhamChiTiet;
import haladesign.repository.IHoaDon;
import haladesign.repository.IHoaDonChiTiet;
import haladesign.repository.IKhachHang;
import haladesign.repository.ISanPhamChiTiet;
import haladesign.system.SpringJPARemoveItem;
import java.util.List;

/**
 *
 * @author NONG HOANG VU
 */
public class BillService {

    private final IHoaDon iHoaDon = getBean(IHoaDon.class);
    private final IHoaDonChiTiet iHoaDonChiTiet = getBean(IHoaDonChiTiet.class);
    private final ISanPhamChiTiet iSanPhamChiTiet = getBean(ISanPhamChiTiet.class);
    private final IKhachHang iKhachHang = getBean(IKhachHang.class);

    @Autowired
    public BillService() {
    }

    public JPAHoaDon getJPAHoaDonById(String id) {
        return iHoaDon.findById(id);
    }

    public List<JPAHoaDon> getBillPending() {
        return this.iHoaDon.findBillPending("Chờ thanh toán");
    }

    public List<JPAHoaDonChiTiet> getHoaDonChiTiet(String id) {
        return this.iHoaDonChiTiet.findById(id);
    }

    public SanPhamChiTiet getSanPhamChiTiet(String productId) {
        return this.iSanPhamChiTiet.findByIdSanPhamBienTheFirstItem(productId);
    }

    public Boolean createBill(JPAHoaDon hd) {
        return this.iHoaDon.save(hd) != null;
    }

    public Boolean cancellingBill(String id) {
        try {
            List<JPAHoaDonChiTiet> details = this.iHoaDonChiTiet.findById(id);
            details.forEach(item -> {
                SanPhamChiTiet sp = item.getSanPhamChiTiet();
                sp.setSoLuong(sp.getSoLuong() + item.getSoLuong());
                new SpringJPARemoveItem().removeByIdHoaDon(item.getHoaDon().getId());
                this.iSanPhamChiTiet.save(sp);
            });
            new SpringJPARemoveItem().removeHoaDonById(Integer.valueOf(id));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public Boolean payBill(JPAHoaDon hd) {
        hd.setTrangThai("Đã thanh toán");
        return this.iHoaDon.save(hd) != null;
    }

    public Boolean checkQuantity(String idHoaDon, String idSanPham) {
        return this.iHoaDonChiTiet.checkProductAlreadyExists(idHoaDon, idSanPham) == null;
    }

    public Boolean addToCart(JPAHoaDonChiTiet donChiTiet) {
        if (checkQuantity(String.valueOf(donChiTiet.getHoaDon().getId()), String.valueOf(donChiTiet.getSanPhamChiTiet().getId()))) {
            SanPhamChiTiet sp = donChiTiet.getSanPhamChiTiet();
            sp.setSoLuong(sp.getSoLuong() - donChiTiet.getSoLuong());
            return this.iHoaDonChiTiet.save(donChiTiet) != null && this.iSanPhamChiTiet.save(sp) != null;
        } else {
            JPAHoaDonChiTiet hd = this.iHoaDonChiTiet.checkProductAlreadyExists(String.valueOf(donChiTiet.getHoaDon().getId()), String.valueOf(donChiTiet.getSanPhamChiTiet().getId()));
            hd.setSoLuong(hd.getSoLuong() + donChiTiet.getSoLuong());
            SanPhamChiTiet sp = donChiTiet.getSanPhamChiTiet();
            sp.setSoLuong(sp.getSoLuong() - donChiTiet.getSoLuong());
            return this.iHoaDonChiTiet.save(hd) != null && this.iSanPhamChiTiet.save(sp) != null;
        }
    }

    public Boolean updateCartItem(JPAHoaDonChiTiet donChiTiet) {
        JPAHoaDonChiTiet hd = this.iHoaDonChiTiet.checkProductAlreadyExists(String.valueOf(donChiTiet.getHoaDon().getId()), String.valueOf(donChiTiet.getSanPhamChiTiet().getId()));
        Integer first = donChiTiet.getSoLuong();
        Integer second = hd.getSoLuong();
        Integer total;
        SanPhamChiTiet sp = hd.getSanPhamChiTiet();
        if (first < second) {
            total = sp.getSoLuong() + (second - first);
        } else if (first > second) {
            total = sp.getSoLuong() - (first - second);
        } else {
            total = sp.getSoLuong();
        }
        sp.setSoLuong(total);
        hd.setSoLuong(donChiTiet.getSoLuong());
        return this.iHoaDonChiTiet.save(hd) != null && this.iSanPhamChiTiet.save(sp) != null;
    }

    public Boolean deleteCartItem(JPAHoaDonChiTiet donChiTiet) {
        try {
            JPAHoaDonChiTiet hd = this.iHoaDonChiTiet.checkProductAlreadyExists(String.valueOf(donChiTiet.getHoaDon().getId()), String.valueOf(donChiTiet.getSanPhamChiTiet().getId()));
            Integer quantity = hd.getSoLuong();
            SanPhamChiTiet sp = hd.getSanPhamChiTiet();
            sp.setSoLuong(sp.getSoLuong() + quantity);
            new SpringJPARemoveItem().removeById(hd.getId());
            this.iSanPhamChiTiet.save(sp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public KhachHang searchKhachHang(String phone) {
        return this.iKhachHang.findByPhoneNumber(phone);
    }

    public void insertKhachHangToBill(String id, KhachHang kh) {
        JPAHoaDon hd = this.iHoaDon.findById(id);
        hd.setKhachHang(kh);
        this.iHoaDon.save(hd);
    }
}
