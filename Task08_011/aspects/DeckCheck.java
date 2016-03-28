package aspects;

import classes.Card;
import classes.Connection;
import classes.Server;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Aspect
public class DeckCheck {
    @Before("execution(* *..*.getCard())")//данные о колоде на данный момент
    public void deckCheck(JoinPoint jp) throws NoSuchFieldException, IllegalAccessException {
        int i =  ((Server)jp.getThis()).getDeck().size();
        if (i < 1){
            System.out.println("В колоде " + i + " карт. Требуется: " + 1);
        }else{
            System.out.println("В колоде достаточное кол-во карт");
        }
    }

    @Around("execution(* *..*.getCard())")//контроль за наличием карт в колоде
    public Object deckControl(ProceedingJoinPoint jp) throws Throwable {
        int i =  ((Server)jp.getThis()).getDeck().size();
        if (i == 0){
            return null;
        }else{
            return jp.proceed();
        }
    }
}
