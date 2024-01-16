package haladesign.service;

import haladesign.model.SanPham;
import static haladesign.Application.getBean;
import haladesign.model.Color;
import haladesign.model.Size;
import haladesign.repository.IColor;
import haladesign.repository.ISanPham;
import haladesign.repository.ISize;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author NONG HOANG VU
 */
public class SanPhamService {

    private final ISanPham iSP = getBean(ISanPham.class);
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

    public List<Size> getSize() {
        return this.iSize.findAll();
    }

    public List<Color> getCOlor() {
        return this.iColor.findAll();
    }
}
