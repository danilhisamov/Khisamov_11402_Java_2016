package Task010;

import A2016_02_0814.Eagle;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class EagleTest {
    private static Eagle eagle = (Eagle) AppCont.ac.getBean("eagle");
    private String s;
    private String res;

    @After
    public void after(){
        Assert.assertEquals(res,s);
    }

    @Test
    public void eagleShouldFly(){
        s = eagle.toFly();
        res = "Просто летающий орёл,ничего удивительного";
    }

    @Test
    public void eagleShouldRemoveFeathers(){
        s = eagle.toRemoveFeathers();
        res = "Старею,надо брать средство от седины";
    }

    @Test
    public void eagleShouldIncubateEggs(){
        s = eagle.toIncubateEggs();
        res = "Будет кем покомандовать";
    }

    @Test
    public void eagleShouldSing(){
        s = eagle.toSing();
        res = "(Устрашающий крик)";
    }

    @Test
    public void eagleShouldDoABarrelRoll(){
        s = eagle.toDoABarrelRoll();
        res = "Бочка??Серьезно?";
    }
}
