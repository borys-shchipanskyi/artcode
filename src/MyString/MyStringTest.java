package MyString;

/**
 * Created by boris on 4/20/15.
 */

public class MyStringTest {
    public static void main(String[] args) {

        MyString str = new MyString(new char[] {'A','B','C', 'Z'});
        MyString str2 = new MyString(new char[] {'A','B','C', 'Z'});
        str.printMyString();
        str.lower();
        str.printMyString();
        str.uper();
        str.printMyString();

        str2.concat(str);
        str2.printMyString();
    }
}
