package Task010;

import A2016_02_0814.CriminalDoctor;
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
public class CriminalDoctorTest {
    private static CriminalDoctor cd = (CriminalDoctor) AppCont.ac.getBean("cd");

    @Test
    public void CDShouldDiagnose(){
        PoliceOfficer pof = mock(PoliceOfficer.class);
        when(pof.getName()).thenReturn("Джон Смит");
        String s = cd.toDiagnose(pof);
        String res = "Болит горло,Джон Смит? Будем резать";

        Assert.assertEquals(res,s);
    }

    @Test
    public void CDShouldMakeInjection(){
        String s = cd.toMakeInjection();
        String res = "Жить будешь";

        Assert.assertEquals(res,s);
    }

    @Test
    public void CDShouldAskToUndress(){
        PoliceOfficer pof = mock(PoliceOfficer.class);
        when(pof.getName()).thenReturn("Джон Смит");

        String s = cd.toAskToUndress(pof);
        String res = "Не надо,Джон Смит, я через одежду рану зашью";
    }

    @Test
    public void CDShouldWriteIllegibly(){
        String s = cd.toWriteIllegibly();
        String res = "Зачем тебе эта бумажка? Купи активированный уголь";

        Assert.assertEquals(res,s);
    }
}
