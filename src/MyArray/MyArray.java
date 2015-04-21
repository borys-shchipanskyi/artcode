package MyArray;

/**
 * Created by boris on 4/20/15.
 */
public class MyArray {
    private int size;
    private int[] myArray;

    public MyArray(int size){
        this.size = size;
        myArray = new int[this.size];
    }

    public void generateArray(int first, int second){
        for(int i = 0; i < size; i++){
            myArray[i] = (int) ((Math.random() * (second - first)) + first);
        }
    }
    public void generateArray(){
        generateArray(0, 10);
    }
    public int getSize(){
        return size;
    }
    public int getElByIndex(int index){
        if(index >= 0 && index < size){
            return myArray[index];
        }
        System.err.print("incorrect index");
        return -1;
    }
    public void printArray(char firstSymbol, char lastSymbol, char divider){
        char fSymbol = firstSymbol;
        char lSymbol = lastSymbol;
        char divid = divider;

        if (firstSymbol == ' '){
            fSymbol = '{';
        }
        if (lastSymbol == ' '){
            lSymbol = '}';
        }
        if(divider == ' '){
            divid = ' ';
        }
        System.out.print("My array :\n" +  fSymbol);
        for(int i = 0; i < size-1; i++){
            System.out.print(myArray[i]);
            System.out.print(divid);
        }
        System.out.print(myArray[size-1]);
        System.out.println(lSymbol);
    }

    public void printArray(){
        printArray(' ', ' ', ' ');
    }

    public void resizeArray(int len){
        int[] newMyArray = new int[size+len];
        System.arraycopy(myArray, 0, newMyArray, 0, size);
        size += len;
        myArray = newMyArray;
    }

    public void resizeArray(){
        resizeArray(1);
    }
    private void changeInArray(int firstIndex, int secondIndex){
        int tmp = myArray[firstIndex];
        myArray[firstIndex] = myArray[secondIndex];
        myArray[secondIndex] = tmp;
    }

    public void sortArray(){
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size-1; j++){
                if (myArray[j] > myArray[j+1]){
                    changeInArray(j, j+1);
                }
            }
        }
    }
    public int aarayMin(){
        int min = myArray[0];
        for(int i = 0; i < size; i++){
            if(min > myArray[i]){
                min = myArray[i];
            }
        }
        return min;
    }
    public int aarayMax(){
        int max = myArray[0];
        for(int i = 0; i < size; i++){
            if(max < myArray[i]){
                max = myArray[i];
            }
        }
        return max;
    }

    public boolean compereWithArray(MyArray array){
        if(array.getSize() != size){
            return false;
        }
        for(int i = 0; i < size; i++){
            if(myArray[i] != array.getElByIndex(i)){
                return false;
            }
        }
        return true;
    }
}
