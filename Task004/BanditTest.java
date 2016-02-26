package Task004;

import A2016_02_0814.Ak47;
import A2016_02_0814.Bandit;

import A2016_02_0814.PoliceOfficer;
import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class BanditTest {
    private static Bandit bandit;

    @BeforeClass
    public static void beforeClass() {
        bandit = new Bandit("Вася", "Утюг");
    }

    @Test
    public void constructorShouldCreateACorrectBandit() {
        Bandit bandit = new Bandit("Вася", "Утюг");
        Assert.assertEquals("Вася", bandit.getName());
        Assert.assertEquals("Утюг", bandit.getNickname());
    }

    @Test
    public void banditShouldDoABadThingCorrectly() {
        Ak47 ak47 = mock(Ak47.class);
        when(ak47.toShoot(2)).thenReturn(" weapon shooted 2 times");

        bandit.setWeapon(ak47);
        String s = bandit.toDoABadThing();
        String res = "Haha!I am a bad guy weapon shooted 2 times";
        Assert.assertEquals(res, s);
    }

    @Test
    public void banditShouldRunFromPolice() {
        PoliceOfficer po = mock(PoliceOfficer.class);
        when(po.getName()).thenReturn("Джон Смит");
        String s = bandit.toTryRunFromPolice(po);

        String res = "Беги Джон Смит, лес которым управляют";
        Assert.assertEquals(res, s);
    }

    @Test
    public void banditShouldLaunderMoney() {
        String s = bandit.toLaunderMoney(5);

        String res = "От куда эти 5 рублей такие чистые? Я просто использую 'Ласка Магия Зеленого'";
        Assert.assertEquals(res, s);
    }

    @Test
    public void banditShouldBribePolice() {
        PoliceOfficer po = mock(PoliceOfficer.class);
        when(po.getName()).thenReturn("Джон Смит");
        when(po.getRank()).thenReturn(5);

        String s = bandit.toBribePolice(po, 5000);

        String res = "Начальник(ранга 5) Джон Смит,может договоримся?(Протянуть 5000 рублей)";
        Assert.assertEquals(res, s);
    }
}
