package Task004;

import A2016_02_0814.Bandit;
import A2016_02_0814.PoliceOfficer;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.PreparedStatement;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class PoliceOfficerTest {
    private static PoliceOfficer po;
    private String s;
    private String res;

    @BeforeClass
    public static void beforeClass(){
        po = new PoliceOfficer("Джон Смит",5);
    }

    @After
    public void after(){
        Assert.assertEquals(res,s);
    }

    @Test
    public void constructorShouldWorkCorrect(){
        s = po.getName() + " " + po.getRank();
        res = "Джон Смит 5";
    }

    @Test
    public void POShouldArest(){
        Bandit bandit = mock(Bandit.class);
        when(bandit.getName()).thenReturn("Вася");
        when(bandit.getNickname()).thenReturn("Утюг");

        s = po.toArest(bandit);
        res = "Вася`Утюг`, Freeze police!";
    }

    @Test
    public void POShouldRelease(){
        Bandit bandit = mock(Bandit.class);
        when(bandit.getName()).thenReturn("Вася");
        when(bandit.getNickname()).thenReturn("Утюг");

        s = po.toRelease(bandit);
        res = "Иди,Вася`Утюг`, пока я не передумал";
    }

    @Test
    public void POShouldEatDonut(){
        s = po.toEatDonut();
        res = "Ммм,обожаю свою работу!";
    }

    @Test
    public void POShouldWearUniform(){
        s = po.toWearPoliceUniform();
        res = "Ну вы только посмотрите на этого красавчика!";
    }


}
