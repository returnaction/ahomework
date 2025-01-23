public class Cat extends Animal{
    private static int totalCreatedCats;
    public Cat(String name, int age, double weight) {
        super(name, age, weight);
        maxRunDistance = 200;
        totalCreatedCats++;
    }




}
