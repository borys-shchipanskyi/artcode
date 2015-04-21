package MyArray;

/**
 * Created by boris on 4/20/15.
 */
public class MyArrayTest {
    public static void main(String[] args) {
        MyArray mArr = new MyArray(10);
        mArr.generateArray();
        mArr.printArray('*', '$', ',');
        mArr.printArray();
        mArr.resizeArray(10);
        mArr.printArray();
        mArr.sortArray();
        mArr.printArray();
        MyArray mArr2 = mArr;

    }
}
