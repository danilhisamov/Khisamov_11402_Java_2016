package Task002;

import ClassWork.Vector2D;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Matrix2x2Test {
    private final double EPS = 1e-9;

    @Test
    public void matrixShouldConsistOfParams(){
        Matrix2x2 m1 = new Matrix2x2(1,2,3,4);
        double[][] a = m1.getA();

        Assert.assertEquals(1,a[0][0],EPS);
        Assert.assertEquals(2,a[0][1],EPS);
        Assert.assertEquals(3,a[1][0],EPS);
        Assert.assertEquals(4,a[1][1],EPS);
    }

    @Test
    public void similarMatrixShouldBeEquals(){
        Matrix2x2 m1 = new Matrix2x2(1,2,3,4);
        Matrix2x2 m2 = new Matrix2x2(1,2,3,4);

        Assert.assertEquals(true,m1.equals(m2));
    }

    @Test
    public void defaultConstructorShouldBeForMatrixOfNull(){
        Matrix2x2 m = new Matrix2x2();
        Matrix2x2 m2 = new Matrix2x2(0);

        Assert.assertEquals(true,m.equals(m2));
    }

    @Test
    public void matrixShouldConsistOfParam(){
        Matrix2x2 m = new Matrix2x2(2);
        Matrix2x2 m2 = new Matrix2x2(2,2,2,2);

        Assert.assertEquals(true,m.equals(m2));
    }

    @Test
    public void matrixShouldBeEqualsToArray(){
        double[][] b = {{1,2},{3,4}};
        Matrix2x2 m1 = new Matrix2x2(b);
        double[][] a = m1.getA();

        double[] b2 = {1,2,3,4};
        double[] a2 = new double[4];
        int k = 0;

        for (int i = 0;i < 2;i++){
            for (int j = 0;j < 2;j++){
                a2[k] = a[i][j];
                k++;
            }
        }
        Assert.assertArrayEquals(b2,a2,EPS);
    }

    @Test
    public void differentMatrixShouldBeUnequals(){
        Matrix2x2 m1 = new Matrix2x2(1,2,3,4);
        Matrix2x2 m2 = new Matrix2x2(3,4,5,6);

        Assert.assertEquals(false,m1.equals(m2));
    }

    @Test
    public void valuesOfNewMatrixShouldBeSummOfPreviuos(){
        Matrix2x2 m1 = new Matrix2x2(1,2,3,4);
        Matrix2x2 m2 = new Matrix2x2(2,3,4,5);

        Matrix2x2 m3 = m1.add(m2);
        Matrix2x2 res = new Matrix2x2(3,5,7,9);

        Assert.assertEquals(true,m3.equals(res));
    }

    @Test
    public void valuesOfOldMatrixShouldSummWithValuesOfParamMatrix(){
        Matrix2x2 m1 = new Matrix2x2(1,2,3,4);
        m1.add2(new Matrix2x2(2,3,4,5));

        Matrix2x2 res = new Matrix2x2(3,5,7,9);

        Assert.assertEquals(true,res.equals(m1));
    }

    @Test
    public void valuesOfNewMatrixShouldBeSubOfParamsMatrix(){
        Matrix2x2 m1 = new Matrix2x2(1,2,3,4);
        Matrix2x2 m2 = new Matrix2x2(1,2,3,4);

        Matrix2x2 res = new Matrix2x2(0);
        Matrix2x2 m3 = m1.sub(m2);

        Assert.assertEquals(true,res.equals(m3));
    }

    @Test
    public void valuesOfOldMatrixShouldBeSubOfItAndParamMatrix(){
        Matrix2x2 m1 = new Matrix2x2(1,2,3,4);
        Matrix2x2 m2 = new Matrix2x2(1,2,3,4);

        m1.sub2(m2);

        Matrix2x2 res = new Matrix2x2(0);

        Assert.assertEquals(true,res.equals(m1));
    }

    @Test
    public void valuesOfNewMatrixShouldBeMultsOfOldMatrixAndParam(){
        Matrix2x2 m1 = new Matrix2x2(1,2,3,4);
        Matrix2x2 m3 = m1.multNumber(2);

        Matrix2x2 res = new Matrix2x2(2,4,6,8);

        Assert.assertEquals(true,res.equals(m3));
    }

    @Test
    public void valuesOfOldMatrixShouldBeMultsOfOldMatrixAndParam(){
        Matrix2x2 m1 = new Matrix2x2(1,2,3,4);
        m1.multNumber2(2);
        Matrix2x2 res = new Matrix2x2(2,4,6,8);

        Assert.assertEquals(true,m1.equals(res));
    }

    @Test
    public void valuesOfNewMatrixShouldBeMultsOfTheseMatrix(){
        Matrix2x2 m1 = new Matrix2x2(1,2,3,4);
        Matrix2x2 m2 = new Matrix2x2(2,3,4,5);
        Matrix2x2 m3 = m1.mult(m2);

        Matrix2x2 res = new Matrix2x2(10,13,22,29);

        Assert.assertEquals(true,m3.equals(res));
    }

    @Test
    public void valuesOfOldMatrixShouldBeMultsOfTheseMatrix(){
        Matrix2x2 m1 = new Matrix2x2(1,2,3,4);
        Matrix2x2 m2 = new Matrix2x2(2,3,4,5);

        m1.mult2(m2);
        Matrix2x2 res = new Matrix2x2(10,13,22,29);

        Assert.assertEquals(true,res.equals(m1));
    }

    @Test
    public void detOfMatrixShouldBeTrue(){
        Matrix2x2 m1 = new Matrix2x2(1,2,3,4);

        double det = m1.det();

        Assert.assertEquals(-2,det,EPS);
    }

    @Test
    public void transponOfMatrixShouldBeTrue(){
        Matrix2x2 m1 = new Matrix2x2(1,2,3,4);

        m1.trasnpon();
        Matrix2x2 res = new Matrix2x2(1,3,2,4);

        Assert.assertEquals(true,res.equals(m1));
    }

    @Test
    public void inverseMatrixShouldBeCorrect(){
        Matrix2x2 m1 = new Matrix2x2(1,2,3,4);

        Matrix2x2 m2 = m1.inverseMatrix();
        Matrix2x2 res = new Matrix2x2(-2,1,1.5,-0.5);

        Assert.assertEquals(true,m2.equals(res));
    }


    @Test
    public void printOfMatrixShouldBeTrue(){
        Matrix2x2 m1 = new Matrix2x2(1,2,3,4);
        m1.printMatrix();

        Assert.assertEquals(1,1,EPS);
    }

    @Test
    public void equivalDiagonalMatrixShouldBeCorrect(){
        Matrix2x2 m1 = new Matrix2x2(1,2,3,4);

        Matrix2x2 m2 = m1.equivalentDiagonal();
        Matrix2x2 res = new Matrix2x2(-6,0,0,-12);

        Assert.assertEquals(true,m2.equals(res));
    }

    @Test
    public void coordinatesOfNewVectorShouldBeMultsOfMatrixAndMatrixVector(){
        Matrix2x2 m1 = new Matrix2x2(1,2,3,4);
        Vector2D vec = new Vector2D(1,2);

        Vector2D vec2 = m1.multVector(vec);

        Assert.assertEquals(5,vec2.getX(),EPS);
        Assert.assertEquals(11,vec2.getY(),EPS);
    }
}
