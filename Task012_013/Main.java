package Task012_013;

import Task012_013.models.Developer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Task012_013/spring-config.xml");
        Developer e = ac.getBean(Developer.class);
        e.setEmail("dan@dsf.asd");
        e.execute(" database");
    }
}
