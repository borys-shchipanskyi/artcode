package MyString;

/**
 * Created by boris on 4/20/15.
 */
public class MyString {
    private int size;
    private char[] myString;


    public MyString(char[] string){
        size = string.length;
        myString = new char[size];

        System.arraycopy(string, 0, myString, 0, size);
    }

    public int getSize(){
        return size;
    }
    public char[] getMyString(){
        return myString;
    }

    public void printMyString(){
        for(int i = 0; i < size; i++){
            System.out.print(myString[i]);
        }
        System.out.println();
    }
    public void concat(MyString string){
        char[] newMyString = new char[size+ string.getSize()];

        System.arraycopy(myString, 0, newMyString, 0, size);
        System.arraycopy(string.getMyString(), 0, newMyString, size, string.getSize());

        size += string.getSize();
        myString = newMyString;
    }
    public void lower(){
        for(int i = 0; i < size; i++){
            if(myString[i] >= 65 && myString[i] <= 90 ){
                myString[i] = (char)(myString[i] + 32);
            }
        }
    }
    public void uper(){
        for(int i = 0; i < size; i++){
            if(myString[i] >= 97 && myString[i] <= 122 ){
                myString[i] = (char)(myString[i] - 32);
            }
        }
    }
}
