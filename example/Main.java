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

        Park park = new Park();

        Park.FerrisWheel ferrisWheel = park.new FerrisWheel("Farry-theScary", "08.00-17.00", 19.95);
        Park.DeathRope deathRope = park.new DeathRope("Rope of Death", "13.30-19.45", 24.99);
        Park.Slides slides = park.new Slides("Slide the Bite", "11.00-17.00", 4.99);
        System.out.println("\nNew park\n");
        System.out.println(ferrisWheel + "\n");
        System.out.println(deathRope + "\n");
        System.out.println(slides + "\n");

        System.out.println("Price for the " + deathRope.getName() + " is " + deathRope.getPrice());

    }
}
