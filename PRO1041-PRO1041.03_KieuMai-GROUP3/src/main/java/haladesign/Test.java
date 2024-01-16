package haladesign;

import haladesign.model.HinhAnh;
import haladesign.model.SanPham;
import haladesign.model.SanPhamBienThe;
import haladesign.model.SanPhamHinhAnh;
import haladesign.repository.ISanPham;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @author NONG HOANG VU
 */
@SpringBootApplication
public class Test {

    private static ApplicationContext context = null;

    public static ApplicationContext getContext() {
        return context;
    }

    public static <T extends Object> T getBean(Class<T> requiredType) {
        return context.getBean(requiredType);
    }

    private static ConfigurableApplicationContext createApplicationContext(String[] args) {
        return new SpringApplicationBuilder(Test.class)
                .headless(false)
                .run(args);
    }

    public static void main(String[] args) {
        context = createApplicationContext(args);
        ISanPham r = getBean(ISanPham.class);
        Integer quantity = 0;
        int count1 = 0;
        int count2 = 0;
        for (SanPham sp : r.findAll()) {
            System.out.println(++count1);
//            if (sp.getId().startsWith("HLD-0")) {
            for (SanPhamBienThe spbt : sp.getBienTheList()) {
                for (SanPhamHinhAnh sphah : spbt.getSanPhamHinhAnhList()) {
                    System.out.println(++count2);
                    HinhAnh hinhAnh = sphah.getHinhAnh();
                    if (hinhAnh != null) {
                        System.out.println(sp.getId() + " - " + spbt.getTenBienThe() + " - " + spbt.getColor().getLoaiMau() + " - " + spbt.getSize().getLoaiSize() + " - " + hinhAnh.getUrl());
                    } else {
                    }
                }
                quantity += spbt.getSoLuong();
            }
//            }
        }
        System.out.println("Total quantity: " + quantity);
    }
}
