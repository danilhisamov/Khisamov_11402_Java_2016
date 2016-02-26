package Task004;

import A2016_02_0814.Boss;
import A2016_02_0814.Police;
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
public class BossTest {
    private static Boss boss;

    @BeforeClass
    public static void beforeClass(){
        boss = new Boss();
    }

    @Test
    public void bossShouldDoABadThing(){
        String s = boss.toDoABadThing();
        String res = "Надо сделать что-то крупное!";

        Assert.assertEquals(res,s);
    }

    @Test
    public void bossShouldRunFromPolice(){
        PoliceOfficer pof = mock(PoliceOfficer.class);
        when(pof.getName()).thenReturn("Джон Смит");

        String s = boss.toTryRunFromPolice(pof);
        String res = "Джон Смит, Я слишком стар для этого";

        Assert.assertEquals(res,s);
    }

    @Test
    public void bossShouldLaunderMoney(){
        String s = boss.toLaunderMoney(5);
        String res = "Чтобы отмыть 5 рублей их надо сначала заработать";

        Assert.assertEquals(res,s);
    }

    @Test
    public void bossShouldBribePolice(){
        PoliceOfficer pof = mock(PoliceOfficer.class);
        when(pof.getName()).thenReturn("Джон Смит");

        String s = boss.toBribePolice(pof,5);
        String res = "Джон Смит,ты приходишь и просишь что-то у меня, но ты просишь без уважения, ты не предлагаешь мне дружбу, ты даже не называешь меня 'Крестным'";

        Assert.assertEquals(res,s);
    }
}
