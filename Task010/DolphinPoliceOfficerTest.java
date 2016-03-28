package Task010;

import A2016_02_0814.Bandit;
import A2016_02_0814.DolphinPoliceOfficer;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class DolphinPoliceOfficerTest {
    private static DolphinPoliceOfficer dpo = (DolphinPoliceOfficer) AppCont.ac.getBean("dpof");

    @Test
    public void DPOShouldArestTheBandit(){
        Bandit bandit = mock(Bandit.class);
        when(bandit.getName()).thenReturn("Вася");
        when(bandit.getNickname()).thenReturn("Утюг");

        String s = dpo.toArest(bandit);
        String res = "Вася`Утюг`, Полиция Майами!";

        Assert.assertEquals(res,s);
    }

    @Test
    public void DPOShouldReleaseTheBandit(){
        Bandit bandit = mock(Bandit.class);
        when(bandit.getName()).thenReturn("Вася");
        when(bandit.getNickname()).thenReturn("Утюг");

        String s = dpo.toRelease(bandit);
        String res = "Вася`Утюг`, Всего доброго!";

        Assert.assertEquals(res,s);
    }

    @Test
    public void DPOShouldEatDonut(){
        String s = dpo.toEatDonut();
        String res = "Я предпочел бы рыбу";

        Assert.assertEquals(res,s);
    }

    @Test
    public void DPOShouldWearPoliceUniform(){
        String s = dpo.toWearPoliceUniform();
        String res = "Довольно-таки удобно";

        Assert.assertEquals(res,s);
    }

    @Test
    public void DPOShouldSwim(){
        String s = dpo.toSwim();
        String res = "Я волна";

        Assert.assertEquals(res,s);
    }

    @Test
    public void DPOShouldWaveFlipper(){
        String s = dpo.toWaveFlipper();
        String res = "Хей приятель";

        Assert.assertEquals(res,s);
    }

    @Test
    public void DPOShouldBlowFountain(){
        String s = dpo.toBlowFountain();
        String res = "Пыщщщ";

        Assert.assertEquals(res,s);
    }

    @Test
    public void DPOShouldHoldABreath(){
        String s = dpo.toHoldABreath(5);
        String res = "Я могу задержать дыхание на 5 минут";

        Assert.assertEquals(res,s);
    }
}
