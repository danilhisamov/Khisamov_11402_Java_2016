package Task010;

import A2016_02_0814.Eagle;
import A2016_02_0814.Seal;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class SealTest {
    private static Seal seal = (Seal) AppCont.ac.getBean("seal");
    private String s;
    private String res;

    @BeforeClass
    public static void beforeClass(){
        Eagle eagle = mock(Eagle.class);
        when(eagle.getName()).thenReturn("Орёл");
        seal.setFried(eagle);
    }

    @After
    public void after(){
        Assert.assertEquals(res,s);
    }

    @Test
    public void sealShouldSwim(){
        s = seal.toSwim();
        res = "Плаваю,но и на суше люблю поваляться";
    }

    @Test
    public void sealShouldWaveFlipper(){
        s = seal.toWaveFlipper();
        res = "Привееет,Орёл";
    }

    @Test
    public void sealShouldBlowFountain(){
        s = seal.toBlowFountain();
        res = "Это не по моей части";
    }

    @Test
    public void sealShouldHoldBreath(){
        s = seal.toHoldABreath(5);
        res = "Может я смогу продержаться больше, чем 5 минут?";
    }

}
