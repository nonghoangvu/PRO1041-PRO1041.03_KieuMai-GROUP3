package haladesign;

import haladesign.formMain.Main;
import haladesign.model.SanPham;
import haladesign.service.SanPhamService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
//import udpm.fpt.form.Login;

/**
 *
 * @author NONG HOANG VU
 */
@SpringBootApplication
public class Application {

    private static ApplicationContext context = null;

    public static ApplicationContext getContext() {
        return context;
    }

    public static <T extends Object> T getBean(Class<T> requiredType) {
        return context.getBean(requiredType);
    }

    private static ConfigurableApplicationContext createApplicationContext(String[] args) {
        return new SpringApplicationBuilder(Application.class)
                .headless(false)
                .run(args);
    }

    public static void main(String[] args) {
        context = createApplicationContext(args);
//        SanPhamService prd = new SanPhamService();
//        for (SanPham sp : prd.getList()) {
//            System.out.println(sp.getId());
//        }
        new Main().setVisible(true);
//        new Login().setVisible(true);
    }
}
