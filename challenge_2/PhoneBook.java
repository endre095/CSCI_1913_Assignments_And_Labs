/*
Andrew Endres

5/1/26
*/


import java.util.HashMap;

public class PhoneBook  {
    HashMap<String, Long> book;

    public PhoneBook() {
        book = new HashMap<>();
    }
    public void add(String name, Long phoneNumber) {
        if (String.valueOf(phoneNumber).length() != 10) {
            System.out.println("Invalid phone number.");
        }
        else {
            book.put(name, phoneNumber);
        }
    }

    public Long get(String input) {
        if (book.get(input) != null) {
            return book.get(input);
        }
        else {
            return null;
        }
    }

    public int length() {
        return book.size();
    }

    
    public static void main(String[] args) {
    PhoneBook contacts = new PhoneBook();
    
    // each of these add calls should be constant time
    contacts.add("Wali", 5553428631L);
    contacts.add("Emilia", 573147373L); // Invalid phone number
    contacts.add("Seo-yun", 5552574665L);
    contacts.add("Flor", 5559083456L);
    System.out.println(contacts.length()); // 3
    
    // each of these get calls should be constant time
    System.out.println(contacts.get("Flor")); // 5559083456
    System.out.println(contacts.get("Emilia")); // Contact not in PhoneBook
        }
    }






