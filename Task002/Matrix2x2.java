package Task002;

import ClassWork.Vector2D;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Matrix2x2 {
    private double[][] a = new double[2][2];

    public Matrix2x2(double[][] a) {
        this.a = a;
    }

    public Matrix2x2(double a0, double a1, double a2, double a3) {
        this.a[0][0] = a0;
        this.a[0][1] = a1;
        this.a[1][0] = a2;
        this.a[1][1] = a3;
    }

    public Matrix2x2(){
        this(0,0,0,0);
    }

    public Matrix2x2(double k) {
        this(k,k,k,k);
    }

    public boolean equals(Matrix2x2 m){
        for (int i = 0;i < 2;i++){
            for (int j = 0;j < 2;j++){
                if (a[i][j] != m.a[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public double[][] getA() {
        return a;
    }

    public Matrix2x2 add(Matrix2x2 mat) {
        return new Matrix2x2(a[0][0] + mat.a[0][0], a[0][1] + mat.a[0][1], a[1][0] + mat.a[1][0], a[1][1] + mat.a[1][1]);
    }

    public void add2(Matrix2x2 mat) {
        int i, j;
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                a[i][j] += mat.a[i][j];
            }
        }
    }

    public Matrix2x2 sub(Matrix2x2 mat) {
        return new Matrix2x2(a[0][0] - mat.a[0][0], a[0][1] - mat.a[0][1], a[1][0] - mat.a[1][0], a[1][1] - mat.a[1][1]);
    }

    public void sub2(Matrix2x2 mat) {
        int i, j;
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                a[i][j] -= mat.a[i][j];
            }
        }
    }

    public Matrix2x2 multNumber(double n) {
        return new Matrix2x2(a[0][0] * n, a[0][1] * n, a[1][0] * n, a[1][1] * n);
    }

    public void multNumber2(double n) {
        int i, j;
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                a[i][j] *= n;
            }
        }
    }

    public Matrix2x2 mult(Matrix2x2 mat) {
        int i, j;
        Matrix2x2 arr = new Matrix2x2();
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    arr.a[i][j] += a[i][k] * mat.a[k][j];
                }
            }
        }
        return arr;
    }

    public void mult2(Matrix2x2 mat) {
        Matrix2x2 res = mult(mat);
        int i, j;
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                this.a[i][j] = res.a[i][j];
            }
        }
    }

    public double det() {
        double det = (a[0][0] * a[1][1]) - (a[1][0] * a[0][1]);
        return det;
    }


    public void trasnpon() {
        double c;
        c = a[0][1];
        a[0][1] = a[1][0];
        a[1][0] = c;
    }

    public Matrix2x2 inverseMatrix() {
        Matrix2x2 arr = new Matrix2x2();
        double k = det();
        if (k != 0) {
            trasnpon();
            arr.a[0][0] = a[1][1];
            arr.a[0][1] = -a[1][0];
            arr.a[1][0] = -a[0][1];
            arr.a[1][1] = a[0][0];
            arr.multNumber2(1.0 / k);
            trasnpon();
        }
        return arr;
    }

    public void printMatrix() {
        int i, j;
        String x = "";
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                x = x + " " + a[i][j];
                if (j == 1) {
                    System.out.println(x);
                    x = "";
                }
            }
        }
    }

    public Matrix2x2 equivalentDiagonal() {
        Matrix2x2 arr = new Matrix2x2();
        arr.a[0][0] = a[0][0] * a[1][0];
        arr.a[0][1] = a[0][1] * a[1][0];
        arr.a[1][0] = a[1][0] * a[0][0];
        arr.a[1][1] = a[1][1] * a[0][0];
        arr.a[1][0] -= arr.a[0][0];
        arr.a[1][1] -= arr.a[0][1];
        double x = arr.a[0][1];
        arr.a[0][0] *= arr.a[1][1];
        arr.a[0][1] *= arr.a[1][1];
        arr.a[1][1] *= x;
        arr.a[0][1] -= arr.a[1][1];
        return arr;
    }

    public Vector2D multVector(Vector2D vec) {
        Matrix2x2 vector = new Matrix2x2(vec.getX(), 0, vec.getY(), 0);
        Matrix2x2 res = mult(vector);
        return new Vector2D(res.a[0][0], res.a[1][0]);
    }

}
