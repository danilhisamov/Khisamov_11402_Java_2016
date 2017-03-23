package Task003;

import com.sun.org.glassfish.external.statistics.annotations.Reset;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class ComplexMatrix2x2Test {
    private final double EPS = 1e-9;

    @Test
    public void compMatrixShouldConsistOfComplexParams(){
        ComplexNumber cn1 = mock(ComplexNumber.class);
        when(cn1.getRe()).thenReturn(1.0,3.0,5.0,7.0);
        when(cn1.getIm()).thenReturn(2.0,4.0,6.0,8.0);

        ComplexMatrix2x2 cm = new ComplexMatrix2x2(cn1,cn1,cn1,cn1);

        ComplexNumber[][] a = cm.getA();

        String s1 = a[0][0].getRe() + " " + a[0][0].getIm() + "\n" +
                a[0][1].getRe() + " " + a[0][1].getIm() + "\n" +
                a[1][0].getRe() + " " + a[1][0].getIm() + "\n" +
                a[1][1].getRe() + " " + a[1][1].getIm();

        String res = 1.0 + " " + 2.0 + "\n" +
                3.0 + " " + 4.0 + "\n" +
                5.0 + " " + 6.0 + "\n" +
                7.0 + " " + 8.0;

        Assert.assertEquals(res,s1);
    }

    @Test
    public void compMatrixShouldConsistOfComplexParam(){
        ComplexNumber cn1 = mock(ComplexNumber.class);
        when(cn1.getRe()).thenReturn(1.0);
        when(cn1.getIm()).thenReturn(2.0);

        ComplexMatrix2x2 cm = new ComplexMatrix2x2(cn1);

        ComplexNumber[][] a = cm.getA();

        String s1 = a[0][0].getRe() + " " + a[0][0].getIm() + "\n" +
                a[0][1].getRe() + " " + a[0][1].getIm() + "\n" +
                a[1][0].getRe() + " " + a[1][0].getIm() + "\n" +
                a[1][1].getRe() + " " + a[1][1].getIm();

        String res =  1.0 + " " + 2.0 + "\n" +
                1.0 + " " + 2.0 + "\n" +
                1.0 + " " + 2.0 + "\n" +
                1.0 + " " + 2.0;

        Assert.assertEquals(res,s1);
    }

    @Test
    public void defaultCompMatrixShouldConsistOfNullComplNumb(){
        ComplexNumber cn1 = mock(ComplexNumber.class);
        when(cn1.getRe()).thenReturn(0.0);
        when(cn1.getIm()).thenReturn(0.0);

        ComplexMatrix2x2 cm = new ComplexMatrix2x2();

        ComplexNumber[][] a = cm.getA();

        String s1 = a[0][0].getRe() + " " + a[0][0].getIm() + "\n" +
                a[0][1].getRe() + " " + a[0][1].getIm() + "\n" +
                a[1][0].getRe() + " " + a[1][0].getIm() + "\n" +
                a[1][1].getRe() + " " + a[1][1].getIm();

        String res =  0.0 + " " + 0.0 + "\n" +
                0.0 + " " + 0.0  + "\n" +
                0.0 + " " + 0.0  + "\n" +
                0.0 + " " + 0.0 ;

        Assert.assertEquals(res,s1);
    }

    @Test
    public void summOfTwoCompMatrixShouldConsistOfSummOfTheirValues(){
        ComplexNumber cn1 = mock(ComplexNumber.class);
        when(cn1.getRe()).thenReturn(1.0);
        when(cn1.getIm()).thenReturn(2.0);
        when(cn1.add(any(ComplexNumber.class))).thenReturn(cn1);

        ComplexNumber cn2 = mock(ComplexNumber.class);
        when(cn2.getRe()).thenReturn(3.0);
        when(cn2.getIm()).thenReturn(4.0);

        ComplexMatrix2x2 cm1 = new ComplexMatrix2x2(cn1);
        ComplexMatrix2x2 cm2 = new ComplexMatrix2x2(cn2);

        ComplexMatrix2x2 cm3 = cm1.add(cm2);

        ComplexNumber[][] a = cm3.getA();
        String s1 = a[0][0].getRe() + " " + a[0][0].getIm() + "\n" +
                a[0][1].getRe() + " " + a[0][1].getIm() + "\n" +
                a[1][0].getRe() + " " + a[1][0].getIm() + "\n" +
                a[1][1].getRe() + " " + a[1][1].getIm();

        String res =  1.0 + " " + 2.0 + "\n" +
                1.0 + " " + 2.0  + "\n" +
                1.0 + " " + 2.0  + "\n" +
                1.0 + " " + 2.0 ;

        Assert.assertEquals(res,s1);
    }

    @Test
    public void valuesOfNewMatrixShouldBeMultsOfPrevious(){
        ComplexNumber cn1 = mock(ComplexNumber.class);
        when(cn1.getRe()).thenReturn(1.0);
        when(cn1.getIm()).thenReturn(2.0);
        when(cn1.mult(any(ComplexNumber.class))).thenReturn(cn1);
        when(cn1.add(any(ComplexNumber.class))).thenReturn(cn1);

        ComplexNumber cn2 = mock(ComplexNumber.class);
        when(cn2.getRe()).thenReturn(3.0);
        when(cn2.getIm()).thenReturn(4.0);

        ComplexMatrix2x2 cm1 = new ComplexMatrix2x2(cn1);
        ComplexMatrix2x2 cm2 = new ComplexMatrix2x2(cn2);

        ComplexMatrix2x2 cm3 = cm1.mult(cm2);

        ComplexNumber[][] a = cm3.getA();

        String s1 = a[0][0].getRe() + " " + a[0][0].getIm() + "\n" +
                a[0][1].getRe() + " " + a[0][1].getIm() + "\n" +
                a[1][0].getRe() + " " + a[1][0].getIm() + "\n" +
                a[1][1].getRe() + " " + a[1][1].getIm();

        String res =  1.0 + " " + 2.0 + "\n" +
                1.0 + " " + 2.0  + "\n" +
                1.0 + " " + 2.0  + "\n" +
                1.0 + " " + 2.0 ;

         Assume.assumeThat(res,is(s1));
    }

    @Test
    public void detOfMatrixShouldBeTrue(){
        ComplexNumber cn1 = mock(ComplexNumber.class);
        when(cn1.getRe()).thenReturn(1.0);
        when(cn1.getIm()).thenReturn(2.0);
        when(cn1.mult(any (ComplexNumber.class))).thenReturn(cn1);
        when(cn1.sub(any(ComplexNumber.class))).thenReturn(cn1);

        ComplexNumber cn2 = mock(ComplexNumber.class);
        when(cn2.getRe()).thenReturn(3.0);
        when(cn2.getIm()).thenReturn(4.0);
        when(cn2.mult(any (ComplexNumber.class))).thenReturn(cn2);

        ComplexMatrix2x2 cm = new ComplexMatrix2x2(cn1,cn2,cn1,cn2);
        ComplexNumber res = cm.det();

        Assert.assertEquals(1.0,res.getRe(),EPS);
        Assert.assertEquals(2.0,res.getIm(),EPS);
    }
}
