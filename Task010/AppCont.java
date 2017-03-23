package Task010;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class AppCont {
     public static ApplicationContext ac = new ClassPathXmlApplicationContext("Task010/spring-config010.xml");
}
