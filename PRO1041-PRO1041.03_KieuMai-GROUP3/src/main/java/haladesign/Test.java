package haladesign;

import haladesign.Utitlity.BcryptHash;
import haladesign.model.SanPham;
import haladesign.repository.ISanPham;
import haladesign.repository.ISize;
import haladesign.service.SanPhamService;
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
//        context = createApplicationContext(args);
//        ISize s = getBean(ISize.class);
//        s.findAll().forEach(sp -> {
//            System.out.println(sp);
//        });
        BcryptHash b = new BcryptHash();
        System.out.println(b.encodeBase64("Tài khoản của tôi"));
    }
}
