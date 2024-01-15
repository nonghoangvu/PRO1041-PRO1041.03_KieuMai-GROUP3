package haladesign.service;

import haladesign.model.SanPham;
import static haladesign.Application.getBean;
import haladesign.repository.ISanPham;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author NONG HOANG VU
 */
public class SanPhamService {

    private final ISanPham iSP = getBean(ISanPham.class);

    @Autowired
    public SanPhamService() {
    }

    public List<SanPham> getList() {
        return this.iSP.findAll();
    }

}
