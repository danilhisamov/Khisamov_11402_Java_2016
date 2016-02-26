package Task004;

import A2016_02_0814.PoliceDoctor;
import A2016_02_0814.PoliceOfficer;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class PoliceDoctorTest {
    private static PoliceDoctor pd;
    private String s;
    private String res;

    @BeforeClass
    public static void beforeClass(){
        pd = new PoliceDoctor();
    }

    @Test
    public void PDShouldDiagnose(){
        PoliceOfficer po = mock(PoliceOfficer.class);
        when(po.getName()).thenReturn("Джон Смит");
        s = pd.toDiagnose(po);
        res = "Давайте посмотрим что тут у вас, Джон Смит";
    }

    @Test
    public void PDShouldMakeInjection(){
        s = pd.toMakeInjection();
        res = "Как комарик укусит";
    }

    @Test
    public void PDShouldAskToUndress(){
        PoliceOfficer po = mock(PoliceOfficer.class);
        when(po.getName()).thenReturn("Джон Смит");

        s = pd.toAskToUndress(po);
        res = "Джон Смит, Раздевайтесь";
    }

    @Test
    public void PDShouldWriteIlldegibly(){
        s = pd.toWriteIllegibly();
        res = "Фыфвфывамооа 2р/д";
    }


}
