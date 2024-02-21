package haladesign.service;

import haladesign.model.KhachHang;
import haladesign.repository.IKhachHang;
import java.util.List;
import static haladesign.Application.getBean;
import haladesign.model.JPAHoaDon;
import haladesign.repository.IHoaDon;
import java.util.stream.Collectors;

/**
 *
 * @author Phương Thảo
 */
public class KhachHangService {

    private final IKhachHang IKH = getBean(IKhachHang.class);
    private final IHoaDon IHoaDon = getBean(IHoaDon.class);

    public KhachHangService() {

    }

    public List<KhachHang> getKH() {
        return IKH.findAll().stream()
                .filter((nv) -> nv.getXoa_mem() == 0)
                .collect(Collectors.toList());
    }

    public KhachHang getKhachHangById(Integer id){
        return this.IKH.getKhachHangById(id);
    }
    public Boolean insert(KhachHang kh) {
        return this.IKH.save(kh) != null;
    }
    
    public List<JPAHoaDon> getListProduct(Integer idKH){
        return this.IHoaDon.findByKhachHangId(idKH);
    }
    
    public List<KhachHang> searchKhachHang(String value){
        return this.IKH.searchByNameOrPhoneNumber(value).stream()
                .filter((nv) -> nv.getXoa_mem() == 0)
                .collect(Collectors.toList());
    }
}
