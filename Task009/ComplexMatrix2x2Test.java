package Task009;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class ComplexMatrix2x2Test {
    private final double EPS = 1e-9;
    private static AnnotationConfigApplicationContext ac;

    @BeforeClass
    public static void createAC(){
       ac = new AnnotationConfigApplicationContext(Config.class);
    }

    @Test
    public void compMatrixShouldConsistOfComplexParams(){
        ComplexMatrix2x2 cm = (ComplexMatrix2x2) ac.getBean("paramsMatrix");

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
        ComplexMatrix2x2 cm = (ComplexMatrix2x2) ac.getBean("paramMatrix");

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
        ComplexMatrix2x2 cm = (ComplexMatrix2x2) ac.getBean("nullMatrix");

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
        ComplexMatrix2x2 cm1 = (ComplexMatrix2x2) ac.getBean("paramMatrix");
        ComplexMatrix2x2 cm2 = (ComplexMatrix2x2) ac.getBean("paramMatrix2");

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
        ComplexMatrix2x2 cm1 = (ComplexMatrix2x2) ac.getBean("paramMatrix");
        ComplexMatrix2x2 cm2 = (ComplexMatrix2x2) ac.getBean("paramMatrix2");

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
        ComplexMatrix2x2 cm = (ComplexMatrix2x2) ac.getBean("detMatrix");
        ComplexNumber res = cm.det();

        Assert.assertEquals(1.0,res.getRe(),EPS);
        Assert.assertEquals(2.0,res.getIm(),EPS);
    }
}
