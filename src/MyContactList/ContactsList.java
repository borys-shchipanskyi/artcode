package MyContactList;

/**
 * Created by boris on 4/18/15.
 */
public class ContactsList {
    private int counter;
    private Contact[] contactsList;
    private final int RECREATE_STEP = 10;
    private final String NAME = "name";
    private final String AGE = "age";
    private final String KIEVSTAR = "+38098";
    private final String LIFE = "+38063";

    public ContactsList(){
        counter = 0;
        contactsList = new Contact[10];
    }

    public int getCounter(){
        return this.counter;
    }
    public Contact getContact(int index){
        return contactsList[index];
    }

    //1 add contact
    public void addContact(Contact contact){
        if(counter == contactsList.length){
            recreateList();
        }
        contactsList[counter] = contact;
        counter += 1;
    }
    private void recreateList(){
        Contact[] newContList = new Contact[contactsList.length + RECREATE_STEP];

        for(int i = 0; i < contactsList.length; i++) {
            newContList[i] = contactsList[i];
        }
        contactsList = newContList;

    }

    //2 remove last
    public void removeLast(){
        removeContact(counter);
    }

    private void removeContact(int index){
        for(int i = index; i < counter; i++){
            contactsList[i] = contactsList[i+1];
        }
        contactsList[counter] = null;
        counter--;

    }

    //3 Find contact by name
    public Contact findByName(String name){
        Contact contact = new Contact();
        for(int i = 0; i < counter; i++ ){
            if(contactsList[i].getName().equals(name)){
                contact = contactsList[i];
                break;
            }
        }
        if(contact.getAge() != 0)
            return contact;
        return null;
    }

    //4 remove contact by name
    private int getContactIndexByName(String name){
        for(int i = 0; i < counter; i++){
            if(contactsList[i].getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public void removeContactByName(String name){
        int contactIndex = getContactIndexByName(name);
        if(contactIndex != -1){
            removeContact(contactIndex);
        }
    }

    //5 replace Contact number by name

    public void replaceContactNumberByName(String name, String number){
        int contacnIndex = getContactIndexByName(name);
        if(contacnIndex != -1){
            contactsList[contacnIndex].setPhone(number);
        }
    }
    //6 ????

    //7 show all contacts

    public void showContacts(int first, int last){
        for(int i = 0; i < last && i < counter; i++){
            contactsList[i].showContact();
        }
    }

    public void showAllContacts(){
        showContacts(0, counter);
    }

    //8 showFirstFiveContacts
    public void showFirstFiveContacts(){
        showContacts(0,5);
    }

    //9 showLastFiveContacts
    public void showLarstFiveContacts(){
        showContacts(counter -5, counter);
    }

    public void showAllContact(Contact[] contactsList){
        for(Contact contact: contactsList){
            if (contact != null)
                contact.showContact();
        }
    }
    //10 showContactsByAlphobet


    private void changeElement(Contact[] contacts, int firstIndex, int secondIndex ){
        Contact buffContact = contacts[firstIndex];
        contacts[firstIndex] = contacts[secondIndex];
        contacts[secondIndex] = buffContact;
    }
    private void filterBy(String filter){
        System.out.println("Sort by " + filter +": ");

        Contact[] sortList = new Contact[contactsList.length+10];
        for(int i = 0; i< contactsList.length; i++){
            sortList[i] = contactsList[i];
        }
        if(filter.equals("age")) {
            for (int i = 0; i < counter - 1; i++) {
                for (int j = 0; j < counter - 1; j++) {
                    if (sortList[j].getAge() > sortList[j + 1].getAge()) {
                        changeElement(sortList, j, j+1);
                    }
                }

            }

        }
        if(filter.equals("name")){
            for (int i = 0; i < counter - 1; i++) {
                for (int j = 0; j < counter - 1; j++) {
                    if (sortList[j].getName().compareTo( sortList[j + 1].getName()) > 0) {
                        changeElement(sortList, j, j+1);
                    }
                }

            }

        }
        showAllContact(sortList);
    }

    public void showContactsByAlphobet(){
        filterBy(NAME);
    }

    //11 show Contacts By Age
    public void showContactsByAge(){
        filterBy(AGE);
    }

    //12 show Life Contacts
    private boolean checOperator(Contact contact, String operator){
        if(contact.getPhone().substring(0,5).equals(operator))
            return true;
        return false;
    }

    public void showLifeContacts(){
        for(int i = 0; i < counter; i++){
            if(checOperator(contactsList[i], LIFE))
                contactsList[i].showContact();
        }
    }

    //13 show Kievstar Contact
    public void showKievstarContacts(){
        for(int i = 0; i < counter; i++){
            if(checOperator(contactsList[i], KIEVSTAR))
                contactsList[i].showContact();
        }
    }


    //not use
    public void findByAge(int age){
        System.out.println("Contacts with age: " + age +" are :" );
        for(int i = 0; i < counter; i++ ){
            if(contactsList[i].getAge() == age){
                contactsList[i].showContact();
            }
        }
    }
    public void findByPhone(String phone){
        System.out.println("Contact with phone: " + phone +" are :" );
        for(int i = 0; i < counter; i++ ){
            if(contactsList[i].getPhone().equals(phone)){
                contactsList[i].showContact();
            }
        }
    }

}
