package Task2;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add(80296064176L, "Obergan");
        phoneBook.add(15612909391L, "Obergan" );
        phoneBook.add(80291342097L, "Mama");
        phoneBook.add(80296209391L, "Papa");

        // Выводим всех номера у кого фамилия obergan
        phoneBook.get("obergan");

        // Выводим всех номера у кого фамилия mama
        phoneBook.get("mama");

        // поиск несуществующей фамилии
        phoneBook.get("Dedushka");

        // вывести все номера отсортированные по номеру телефона
        phoneBook.printAllPhonesInNumberOrder();

        // Вывести все номера отсортированные по имени
        phoneBook.printAllPhonesInNameOrder();

        // так же сделал перегрузку метода get по телефону.
        phoneBook.get(80296209391L);

    }
}
