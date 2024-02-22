package haladesign;

import haladesign.repository.IHoaDon;
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
        r.findByIdAndName("HD").forEach(s -> {
            System.out.println(s.getTen_san_pham());
        });
    }
}
