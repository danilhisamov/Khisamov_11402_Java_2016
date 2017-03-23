package Task010;

import A2016_02_0814.M4A4;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class M4A4Test {
    private static M4A4 m4A4 = (M4A4) AppCont.ac.getBean("m4a4");
    private String s;
    private String res;

    @After
    public void after(){
        Assert.assertEquals(res,s);
    }

    @Test
    public void m4a4ShouldShoot(){
        s = m4A4.toShoot(2);
        res = "Tratatata";
    }

    @Test
    public void m4a4ShouldReload(){
        s = m4A4.toReload();
        res = "Cover me,I am reloading!";
    }

    @Test
    public void m4a4ShouldAim(){
        s = m4A4.toAim();
        res = "It will be a headshot";
    }

    @Test
    public void m4a4ShouldClean(){
        s = m4A4.toCleanGun();
        res = "Let's make you clean";
    }
}
