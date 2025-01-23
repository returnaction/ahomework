public abstract class Animal {
    String name;
    int age;
    double weight;
    int maxRunDistance;

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

     void run(int runDistance){
        if(runDistance > maxRunDistance){
            System.out.println("Я не могу побежать " + runDistance + " столько метров!");
            System.out.println(name + " пробежал(а) " + maxRunDistance + " метров");
            return;
        }
            System.out.println(name + " пробежал(а) " + runDistance + " метров");
     }


}
