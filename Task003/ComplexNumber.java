package Task003;


/**
 * @author Danil Khisamov
 *         11-402
 */
public class ComplexNumber {
    private double re;
    private double im;

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public ComplexNumber() {
        this(0, 0);
    }


    public ComplexNumber add(ComplexNumber num) {
        return new ComplexNumber(re + num.getRe(), im + num.getIm());
    }


    public void add2(ComplexNumber num) {
        re += num.getRe();
        im += num.getIm();
    }


    public ComplexNumber sub(ComplexNumber num) {
        return new ComplexNumber(re - num.getRe(), im - num.getIm());
    }


    public void sub2(ComplexNumber num) {
        re -= num.getRe();
        im -= num.getIm();
    }

    public ComplexNumber multNumber(double a) {
        return new ComplexNumber(re * a, im * a);
    }

    public void multNumber2(double a) {
        re *= a;
        im *= a;
    }

    public ComplexNumber mult(ComplexNumber num) {
        return new ComplexNumber((re * num.getRe()) - (im * num.getIm()), (re * num.getIm()) + (im * num.getRe()));
    }

    public void mult2(ComplexNumber num) {
        ComplexNumber res = mult(num);
        this.re = res.re;
        this.im = res.im;
    }

    public ComplexNumber div(ComplexNumber num) {
        double z = num.getRe() * num.getRe() + num.getIm() * num.getIm();
        return new ComplexNumber((re * num.getRe() + im * num.getIm()) / z, (im * num.getRe() - re * num.getIm()) / z);
    }

    public void div2(ComplexNumber num) {
        ComplexNumber res = div(num);
        this.re = num.re;
        this.im = num.im;
    }

    public double length() {
        double z = Math.sqrt(re * re + im * im);
        return z;
    }

    public String toString() {
        String s = "";
        if (im >= 0) {
            s = re + " + " + im + " * i";
        } else if (im < 0) {
            s = re + " - " + im * (-1) + " * i";
        }
        return s;
    }

    public double arg() {
        double a = 0;
        if (re > 0) {
            a = Math.atan(im / re);
        } else if ((re < 0) && (im >= 0)) {
            a = Math.PI + Math.atan(im / re);
        } else if ((re < 0) && (im < 0)) {
            a = -Math.PI + Math.atan(im / re);
        } else if ((re == 0) && (im > 0)) {
            a = Math.PI / 2;
        } else if ((re == 0) && (im < 0)) {
            a = -Math.PI / 2;
        }
        return a;
    }

    public ComplexNumber pow(double n) {
        return new ComplexNumber(Math.pow(length(), n) * Math.cos(n * arg()), Math.pow(length(), n) * Math.sin(n * arg()));
    }

    public boolean equals(ComplexNumber num) {
        boolean b;
        b = (re == num.getRe()) && (im == num.getIm());
        return b;
    }
}
