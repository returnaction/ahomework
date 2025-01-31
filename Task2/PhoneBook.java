package Task2;

import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    private Map<Long, String> phoneBook;

    public PhoneBook() {
        phoneBook = new TreeMap<>();
    }

    public void add(long phone, String name){
        if(name.trim().isEmpty()){
            System.out.println("Имя не может быть пустым!");
            return;
        }
        if(phoneBook.containsKey(phone)){
            System.out.println("Справочник уже содержит номер : " + phone);
            return;
        }
        phoneBook.put(phone, name.trim());
        System.out.println("Добавлен: " + phone + " - " + name);
    }

    public void get(String name){
        boolean flag = false;
        for(Map.Entry<Long, String> entry : phoneBook.entrySet()){
            if(entry.getValue().equalsIgnoreCase(name.trim())){
                System.out.println(entry.getKey() + " - " + entry.getValue());
                flag = true;
            }
        }
        if(!flag){
            System.out.println("В справочнике нету записи с именем " + name);
        }
    }

    public void get(long phone){
        String name = phoneBook.get(phone);
        if(name != null){
            System.out.println(phone + " - " + name);
        } else {
            System.out.println("Справочник не содержит номера " + phone);
        }
    }

    public void printAllPhonesInNumberOrder(){
        System.out.println("Все записи записной книжки отсортированной по номеру телефона:");
        for(Map.Entry<Long, String> entry : phoneBook.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void printAllPhonesInNameOrder(){
        System.out.println("Все записи отсортированные по фамилии:");
        phoneBook.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(String.CASE_INSENSITIVE_ORDER))
                .forEach(phone -> System.out.println(phone.getValue() + " - " + phone.getKey()));
    }


}
