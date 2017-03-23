package Task009;


/**
 * @author Danil Khisamov
 *         11-402
 */
public class ComplexMatrix2x2 {
    private ComplexNumber[][] a = new ComplexNumber[2][2];

    public ComplexMatrix2x2(ComplexNumber a0, ComplexNumber a1, ComplexNumber a2, ComplexNumber a3) {
        this.a[0][0] = a0;
        this.a[0][1] = a1;
        this.a[1][0] = a2;
        this.a[1][1] = a3;
    }

    public ComplexMatrix2x2(ComplexNumber a) {
        this(a, a, a, a);
    }

    public ComplexMatrix2x2() {
        this(new ComplexNumber(), new ComplexNumber(), new ComplexNumber(), new ComplexNumber());
    }

    public ComplexNumber[][] getA() {
        return a;
    }

    public ComplexMatrix2x2 add(ComplexMatrix2x2 mat) {
        int i, j;
        ComplexMatrix2x2 res = new ComplexMatrix2x2();
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                res.a[i][j] = a[i][j].add(mat.a[i][j]);
            }
        }
        return res;
    }

    public ComplexMatrix2x2 mult(ComplexMatrix2x2 mat) {
        int i, j, k;
        ComplexMatrix2x2 res = new ComplexMatrix2x2();
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                for (k = 0; k < 2; k++) {
                    res.a[i][j] = res.a[i][j].add(a[i][k].mult(mat.a[k][j]));
                }
            }
        }
        return res;
    }

    public ComplexNumber det() {
        return (a[0][0].mult(a[1][1])).sub(a[1][0].mult(a[0][1]));
    }
}
