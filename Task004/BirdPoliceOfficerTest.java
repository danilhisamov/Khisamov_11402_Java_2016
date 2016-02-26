package Task004;

import A2016_02_0814.Bandit;
import A2016_02_0814.BirdPoliceOfficer;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class BirdPoliceOfficerTest {
    private static BirdPoliceOfficer bpof;

    @BeforeClass
    public static void beforeClass(){
        bpof = new BirdPoliceOfficer();
    }

    @Test
    public void BirdPolOfficerShouldFlyCorrectly(){
        String s = bpof.toFly();

        String res = "Производится проверка территории";

        Assert.assertEquals(res,s);
    }

    @Test
    public void BirdPolOfficerShouldRemoveFeathersCorrectly(){
        String s = bpof.toRemoveFeathers();
        String res = "Привести крылья в порядок";

        Assert.assertEquals(res,s);
    }

    @Test
    public void BPOFShouldIncubateEggs(){
        String s = bpof.toIncubateEggs();
        String res = "У меня будет целая армия";

        Assert.assertEquals(res,s);
    }

    @Test
    public void BPOFShouldSing(){
        String s = bpof.toSing();
        String res = "УиУ Трыт Трыт";

        Assert.assertEquals(res,s);
    }

    @Test
    public void BPOFShouldDoABarrelRoll(){
        String s = bpof.toDoABarrelRoll();
        String res = "Смотри как я умею";

        Assert.assertEquals(res,s);
    }

    @Test
    public void BPOFShouldArestTheBandit(){
        Bandit bandit = mock(Bandit.class);
        when(bandit.getName()).thenReturn("Вася");
        when(bandit.getNickname()).thenReturn("Утюг");

        String s = bpof.toArest(bandit);
        String res = "Вася `Утюг` ,Воздушная полиция,остановитесь!";

        Assert.assertEquals(res,s);
    }

    @Test
    public void BPOFShouldReleaseTheBandit(){
        Bandit bandit = mock(Bandit.class);
        when(bandit.getName()).thenReturn("Вася");
        when(bandit.getNickname()).thenReturn("Утюг");

        String s = bpof.toRelease(bandit);
        String res = "Лети,Вася, на все 4 стороны";
        Assert.assertEquals(res,s);
    }

    @Test
    public void BPOFShouldEatDonut(){
        String s = bpof.toEatDonut();
        String res = "А птицы едят пончики?";

        Assert.assertEquals(res,s);
    }

    @Test
    public void BPOFShouldWearPoliceUniform(){
        String s = bpof.toWearPoliceUniform();
        String res = "Не мой размер,отдам колибри";

        Assert.assertEquals(res,s);
    }
}
