package haladesign.service;

import haladesign.model.SanPham;
import java.util.ArrayList;
import static haladesign.Application.getBean;
import haladesign.repository.ISanPham;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author NONG HOANG VU
 */
public class SanPhamService {
    private ArrayList<SanPham> list;
    private ISanPham iSp = getBean(ISanPham.class);
    @Autowired
    public SanPhamService() {
        this.list = new ArrayList<>();
    }

    public List<SanPham> getList() {
        return this.iSp.findAll();
    }
    
}
