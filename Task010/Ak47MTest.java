package Task010;

import A2016_02_0814.Ak47M;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Ak47MTest {

    @Test
    public void ak47MShouldShootCorrectly(){
        Ak47M ak47M = (Ak47M) AppCont.ac.getBean("ak47m");

        String s = ak47M.toShoot(2);
        String res = "Ak47M shoots 2 times";

        Assert.assertEquals(res,s);
    }
}
