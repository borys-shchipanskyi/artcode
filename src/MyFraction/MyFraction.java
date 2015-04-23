package MyFraction;

/**
 * Created by boris on 4/22/15.
 */
public class MyFraction {
    private int numerator;
    private int denominator;

    public MyFraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;

    }

    public String toString(){
        String res = "";
        res += numerator;
        res += "/";
        res += denominator;
        return res;
    }
    public int gcd(int a, int b){
        while( b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public void simplify(){
        int gcd = gcd(numerator, denominator);
        if(gcd != 1){
            numerator = numerator / gcd;
            denominator = denominator / gcd;
        }
        if (numerator > 0 && denominator < 0){
            numerator *= -1;
            denominator *= -1;
        }
    }

    private MyFraction setEqualDenominator(MyFraction fraction){
        MyFraction res = new MyFraction(fraction.getNumerator(), fraction.getDenominator());
        if(denominator != res.getDenominator()){
            int den = denominator;
            denominator *= res.getDenominator();
            numerator *= res.getDenominator();

            res.setDenominator(res.getDenominator()* den);
            res.setNumerator(res.getNumerator() * den);

        }
        return res;
    }

    public void plus(MyFraction fraction){
        MyFraction fract = setEqualDenominator(fraction);
        numerator += fract.getNumerator();
        simplify();
    }
    public void minus(MyFraction fraction){
        MyFraction fract = setEqualDenominator(fraction);
        numerator -= fract.getNumerator();


        simplify();
    }
    public void multiplication(MyFraction fraction){
        numerator *= fraction.getNumerator();
        denominator *= fraction.getDenominator();
        simplify();
    }
    public void division(MyFraction fraction){
        numerator *= fraction.getDenominator();
        denominator *= fraction.getNumerator();
        simplify();
    }
    public void printFraction(){
        System.out.println(toString());
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public boolean isEqual(MyFraction fraction){
        if(numerator == fraction.getNumerator() && denominator == fraction.getDenominator()){
            return true;
        }
        return false;
    }

}
