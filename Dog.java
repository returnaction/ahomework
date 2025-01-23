public class Dog extends Animal{
    private static int totalCreatedDogs;
    int maxSwimDistance;
    public Dog(String name, int age, double weight) {
        super(name, age, weight);
        maxRunDistance = 500;
        maxSwimDistance = 10;
        totalCreatedDogs++;
    }



    void swim(int swimDistance){
        if(swimDistance > maxSwimDistance){
            System.out.println("Я собака, не Фэлпс! Я не могу проплыть " + swimDistance + " метров");
            System.out.println(name + " проплыл(а) " + maxSwimDistance + " метров");
            return;
        }
        System.out.println(name + " проплыл(а) " + swimDistance + " метров");
    }
}
