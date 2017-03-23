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
public class EmailCheck {
    @Around("execution (* *..*.setEmail(String))")
    public Object emailCheck(ProceedingJoinPoint jp) throws Throwable {
        String email = (String) jp.getArgs()[0];
        Pattern p = Pattern.compile("([\\w]+)@([a-z]+)\\.([a-z]+)");
        Matcher m = p.matcher(email);
        if (m.matches()){
            System.out.println("nice email");
            return jp.proceed();
        }else{
            System.out.println("this is not email");
            return null;
        }
    }
}
