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

    private int compare(char[] substring, int index){
        for(int i = index, j = 0; j < substring.length; j++, i++ ){
             if(myString[i] != substring[j]){
                return -1;
            }
        }
    return index;
    }

    public int findSubstring(MyString substring){
        int subIndex = -1;
        if(substring.size > this.size){
            subIndex  = -1;
        }
        for(int i = 0; i < size; i++){
            if (myString[i] == substring.getMyString()[0] && size - i >= substring.getSize())
                subIndex = compare(substring.getMyString(), i);
                if (subIndex != -1){
                    break;
                }
        }
        return subIndex;
    }
    private void deleteSubString(int firstIndex, int secondIndex){
        char[] newString = new char[size - (secondIndex - firstIndex)];
        System.arraycopy(myString, 0, newString, 0, firstIndex);
        if( secondIndex != size)
           System.arraycopy(myString, secondIndex, newString, firstIndex, size - secondIndex);

        myString = newString;
        size = newString.length;
    }
    public void cutSubstring(MyString subString){
        int substringIndex = findSubstring(subString);
        while( substringIndex != -1){
            deleteSubString(substringIndex, substringIndex +  subString.getSize());

            substringIndex = findSubstring(subString);
        }

    }

    public boolean isEqual(MyString str){
        if( size != str.getSize()){
            return false;
        }
        for(int i = 0; i < size; i++){
            if (myString[i] != str.getMyString()[i]){
                return false;
            }
        }
        return true;
    }

    public void deleteSpace(){
        cutSubstring(new MyString(new char[] {' '}));
    }
}
