package MyContactList;

/**
 * Created by boris on 4/18/15.
 */
public class Contact {
    private String phone;
    private String name;
    private int age;

    public Contact(String name, String phone, int age){
        this.name = name;
        this.phone = phone;
        this.age = age;
    }
    public Contact(){

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


public void showContact(){
    System.out.println("name: " + this.getName() +
    ", phote: " + this.getPhone() + ", age: " + this.getAge());
}







}
