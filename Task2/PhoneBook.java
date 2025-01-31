package Task2;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<Long, String> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(long phone, String name){
        if(phoneBook.containsKey(phone)){
            System.out.println("Справочник уже содержит номер : " + phone);
            return;
        }
        phoneBook.put(phone, name);
        System.out.println(phone + " - " + name + " успешно добавлен");
    }


}
