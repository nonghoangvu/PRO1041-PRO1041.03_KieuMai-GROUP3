package haladesign.service;

import haladesign.model.SanPham;
import static haladesign.Application.getBean;
import haladesign.model.Color;
import haladesign.model.SanPhamBienThe;
import haladesign.model.Size;
import haladesign.repository.IColor;
import haladesign.repository.ISanPham;
import haladesign.repository.ISanPhamBienThe;
import haladesign.repository.ISize;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author NONG HOANG VU
 */
public class SanPhamService {

    private final ISanPham iSP = getBean(ISanPham.class);
    private final ISanPhamBienThe iSPBT = getBean(ISanPhamBienThe.class);
    private final ISize iSize = getBean(ISize.class);
    private final IColor iColor = getBean(IColor.class);

    @Autowired
    public SanPhamService() {
    }

    public List<SanPham> getList() {
        return this.iSP.findAll();
    }

    public List<SanPham> getByIdSanPham(String id) {
        return this.iSP.findByIdSanPham(id);
    }

    public List<SanPhamBienThe> getByIdSanPhamBienThe(String id) {
        return this.iSPBT.findByIdSanPhamBienThe(id);
    }

    public List<SanPhamBienThe> getByColorAndSize(String id, Color color, Size size) {
        return iSPBT.findBySizeAndColor(id, size.getLoaiSize(), color.getLoaiMau());
    }

    public List<Size> getSize() {
        return this.iSize.findAll();
    }

    public List<Color> getCOlor() {
        return this.iColor.findAll();
    }

    @Transactional
    public Boolean insert(SanPham sanPham, List<SanPhamBienThe> bienTheList) {
        sanPham.setBienTheList(bienTheList);
        bienTheList.forEach(s -> s.setId_san_pham(sanPham));
        return this.iSP.saveAndFlush(sanPham) != null;
    }

    @Transactional
    public Boolean insertSanPham(SanPham sp) {
        return this.iSP.saveAndFlush(sp) != null;
    }

    @Transactional
    public Boolean insertBienThe(SanPhamBienThe sp) {
        return this.iSPBT.saveAndFlush(sp) != null;
    }
}
