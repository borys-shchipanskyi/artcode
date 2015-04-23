package MyContactList;

/**
 * Created by boris on 4/23/15.
 */
public class ContactListController {
    private ContactsList contactsList = new ContactsList();

    private final char PLUS = '+';
    private final short NUMBER_LEN = 13;
    public ContactListController(){

    }

    //add parth
    private boolean isNumber(char c){
        if(c >=48 && c <=57 )
            return true;
        return false;
    }
    private boolean isLeter(char c){
        if((c >=65 && c <=90) || (c >=97 && c <= 122) )
            return true;
        return false;
    }

    private boolean isValidName(String name){
        for(int i = 0; i < name.length(); i++){
            char sumbol = name.charAt(i);
            if(!isLeter(sumbol) || !isNumber(sumbol))
                return false;
        }
        return true;
    }
    private boolean isValidPhone(String phone){
        if(phone.charAt(0) == PLUS && phone.length() == NUMBER_LEN){
            for(int i = 1; i < NUMBER_LEN; i++){
                if(!isNumber(phone.charAt(i)))
                    return false;
            }
            return true;
        }
        return false;
    }
    private boolean isUniqueName(String name){
        for(int i = 0; i < contactsList.getCounter(); i++){
            if(contactsList.getContact(i).getName().equals(name))
                return false;
        }
        return true;
    }

    public void addContact(String name, String phone, int age){
        if(isValidName(name) && isValidPhone(phone) && isUniqueName(name)){
            Contact contact = new Contact(name, phone, age);
        } else{
            System.out.println("Problem with data. Please chec input data");
        }
    }

}
