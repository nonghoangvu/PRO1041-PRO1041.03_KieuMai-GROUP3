package haladesign;

import haladesign.loginFeature.LoginForm;
import haladesign.mainMenu.Main;
import haladesign.model.Account;

import java.util.Date;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author NONG HOANG VU
 */
@SpringBootApplication
public class Application {

    private static ApplicationContext context = null;

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
         new LoginForm().setVisible(true);
    }
}