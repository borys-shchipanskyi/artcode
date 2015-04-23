package MyContactList;

/**
 * Created by boris on 4/18/15.
 */
public class MyContactListTest {
    public static void main(String[] args) {
        ContactsList contactsList = new ContactsList();
//        for(int i = 0; i < 15; i++){
//            Contact contact = new Contact("Vasya" + i, "098594601" + i, 20 - i);
//            contactsList.addToContactsList(contact);
//        }
        Contact contact = new Contact("aqc", "098594601", 23);
        contactsList.addToContactsList(contact);
        Contact contact1 = new Contact("aw", "098594601", 22);
        contactsList.addToContactsList(contact1);
        Contact contact2 = new Contact("aza", "098594601", 21);
        contactsList.addToContactsList(contact2);
        Contact contact3 = new Contact("aab", "098594601", 20 );
        contactsList.addToContactsList(contact3);
        contactsList.addToContactsList(contact3);
        contactsList.addToContactsList(contact3);
        contactsList.showAllContact();
        contactsList.filterBy("age");
        contactsList.filterBy("name");

        contactsList.findByAge(20);
        contactsList.findByName("aab");

    }
}
