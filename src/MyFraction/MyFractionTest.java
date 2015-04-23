package MyFraction;

/**
 * Created by boris on 4/22/15.
 */
public class MyFractionTest {
    public static void main(String[] args) {
        MyFraction fraction1 = new MyFraction(9, 18);
        MyFraction fraction2 = new MyFraction(-4, 18);

        fraction1.printFraction();
        fraction2.printFraction();


        fraction1.plus(fraction2);
        fraction1.printFraction();
        fraction1.multiplication(fraction2);
        fraction1.printFraction();
    }
}

