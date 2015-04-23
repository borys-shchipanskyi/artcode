package MyString;

/**
 * Created by boris on 4/20/15.
 */

public class MyStringTest {
    public static void main(String[] args) {

        MyString str = new MyString(new char[] {'A','B','C', 'Z', 'a', 'b', 'a', 'a', 'b', ' ', ' ', ' ', 'c'});
        MyString str2 = new MyString(new char[] {'a'});
        str.printMyString();
        str2.printMyString();

        System.out.println(str.findSubstring(str2));
        str.printMyString();

        str.cutSubstring(str2);
        str.printMyString();

        str.deleteSpace();
        str.printMyString();
    }
}
