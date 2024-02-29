package haladesign.service;

import haladesign.model.SanPham;
import static haladesign.Application.getBean;
import haladesign.model.ChatLieu;
import haladesign.model.Color;
import haladesign.model.SanPhamChiTiet;
import haladesign.model.Size;
import haladesign.repository.IChatLieu;
import haladesign.repository.IColor;
import haladesign.repository.ISanPham;
import haladesign.repository.ISize;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import haladesign.repository.ISanPhamChiTiet;

/**
 *
 * @author NONG HOANG VU
 */
public class SanPhamService {

    private final ISanPham iSP = getBean(ISanPham.class);
    private final ISanPhamChiTiet iSPBT = getBean(ISanPhamChiTiet.class);
    private final ISize iSize = getBean(ISize.class);
    private final IColor iColor = getBean(IColor.class);
    private final IChatLieu iChatLieu = getBean(IChatLieu.class);

    @Autowired
    public SanPhamService() {
    }

    public List<SanPham> getList() {
        return this.iSP.findAll();
    }

    public List<SanPham> getAllList() {
        return this.iSP.findAllStatus();
    }

    public List<SanPham> getListStoped() {
        return this.iSP.findAllStatusIsOff();
    }

    public List<SanPham> getListSearch(String search, Boolean status) {
        return this.iSP.findByIdAndName(search, status);
    }
    
    public List<SanPham> getListSearchMaster(String name, String size, String color, String chatLieu) {
        return this.iSP.findMasterProduct(name, size, color, chatLieu);
    }

    public List<SanPham> getByIdSanPham(String id) {
        return this.iSP.findByIdSanPham(id);
    }

    public SanPham getSanPhamInfo(String id) {
        return this.iSP.findSanPham(id);
    }

    public List<SanPhamChiTiet> getByIdSanPhamBienThe(String id) {
        return this.iSPBT.findByIdSanPhamBienThe(id);
    }

    public List<SanPhamChiTiet> getByColorAndSizeAndChatLieu(String id, Color color, Size size, ChatLieu chatLieu) {
        return iSPBT.findBySizeAndColorAndChatLieu(id, size.getLoaiSize(), color.getLoaiMau(), chatLieu.getLoaiChatLieu());
    }

    public SanPhamChiTiet getSanPhamChiTiet(String id, String targetSize, String targetColor, String targetChatLieu) {
        return iSPBT.findByThuocTinh(id, targetSize, targetColor, targetChatLieu);
    }

    public List<Size> getSize() {
        return this.iSize.findAll();
    }

    public Size findBySize(String loaiSize) {
        return this.iSize.findByLoaiSize(loaiSize);
    }

    public List<Color> getCOlor() {
        return this.iColor.findAll();
    }

    public Color findByColor(String loaiMau) {
        return this.iColor.findByLoaiMau(loaiMau);
    }

    public List<ChatLieu> getChatLieu() {
        return this.iChatLieu.findAll();
    }

    public ChatLieu findByChatLieu(String chatLieu) {
        return this.iChatLieu.findByLoaiChatLieu(chatLieu);
    }

    @Transactional
    public Boolean insert(SanPham sanPham, List<SanPhamChiTiet> bienTheList) {
        sanPham.setBienTheList(bienTheList);
        bienTheList.forEach(s -> s.setId_san_pham(sanPham));
        return this.iSP.saveAndFlush(sanPham) != null;
    }

    @Transactional
    public Boolean insertSanPham(SanPham sp) {
        return this.iSP.saveAndFlush(sp) != null;
    }

    @Transactional
    public Boolean insertBienThe(SanPhamChiTiet sp) {
        return this.iSPBT.saveAndFlush(sp) != null;
    }

    @Transactional
    public Boolean insertColor(Color color) {
        return this.iColor.save(color) != null;
    }

    @Transactional
    public Boolean insertSize(Size size) {
        return this.iSize.save(size) != null;
    }

    @Transactional
    public Boolean insertChatLieu(ChatLieu chatLieu) {
        return this.iChatLieu.save(chatLieu) != null;
    }
}
