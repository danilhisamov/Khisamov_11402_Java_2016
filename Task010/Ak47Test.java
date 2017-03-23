package Task010;

import A2016_02_0814.Ak47;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Ak47Test {
    private static Ak47 ak47 = (Ak47) AppCont.ac.getBean("ak47");

    @Test
    public void ak47SHouldShootCorrectly(){
        String s = ak47.toShoot(2);
        String res = "Трататата (x2)";

        Assert.assertEquals(res,s);
    }

    @Test
    public void ak47ShouldReloadCorrectly(){
        String s = ak47.toReload();
        String res = "Прикройте,перезарежаюсь";

        Assert.assertEquals(res,s);
    }

    @Test
    public void ak47ShouldAimCorrectly(){
        String s = ak47.toAim();
        String res = "Сейчас будет выстрел в голову!";

        Assert.assertEquals(res,s);
    }

    @Test
    public void ak47ShouldCleanCorrectly(){
        String s = ak47.toCleanGun();
        String res = "Приведем тебя в порядок";

        Assert.assertEquals(res,s);
    }
}
