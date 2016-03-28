package Task012_013.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Aspect
public class SqlInjCheck {
    @Around("execution (* *..Developer.execute(String))")
    public Object sqlCheck(ProceedingJoinPoint jp) throws Throwable {
        String s = (String) jp.getArgs()[0];
        Pattern p = Pattern.compile("DROP|DELETE|UPDATE");
        Matcher m = p.matcher(s);
        if (m.find()){
            System.out.println("Aй-яй-яй");
            return null;
        }else{
            System.out.println("Выполняю запрос");
            return jp.proceed();
        }
    }
}
