package example;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Nik", "Ober", "Alekseevich", "Engineer", 80291342097L, 100_000, 33);
        employees[1] = new Employee("Adam", "Clirk", "Junior", "Software Developer", 7464542597L, 300_000, 30);
        employees[2] = new Employee("Alesha", "Popovich", "Nikitovich", "Housewife", 80291312397L, 0, 25);
        employees[3] = new Employee("John", "Smith", "Brian", "Politican", 19255612856L, 10000_000, 59);
        employees[4] = new Employee("Ivan", "Petrov", "Mihalovich", "Hacker", 0000000000L, 100_000_000, 35);

        for (Employee emp : employees) {
            emp.printInfo();
        }

        Park park = new Park("Парк Челюскинцев");
        park.new Attraction("Ferris wheel", 19.95, "08.00-17.00");
        park.new Attraction("Rope of Death", 24.99, "13.30-19.45");
        park.new Attraction("Slide the Bite", 4.99, "11.00-17.00");
        System.out.println(park);
    }
}
