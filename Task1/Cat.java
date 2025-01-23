package Task1;

public class Cat extends Animal{
    private static int totalCreatedCats;
    private boolean isHungry;
    private final int foodConsumption;
    public Cat(String name, int age, double weight) {
        super(name, age, weight);
        maxRunDistance = 200;
        totalCreatedCats++;
        isHungry = true;
        foodConsumption = (int)(Math.random() * 30 + 1);
    }


    public static int getTotalCreatedCats() {
        return totalCreatedCats;
    }

    public void setHungry() {
        isHungry = true;
    }

    private void setNotHungry(){
        isHungry = false;
    }

    public void eat(Bowl bowl){
        if(!isHungry){
            System.out.println(name + " не голоден!");
            return;
        }
        if(bowl.getFoodCapacity() < foodConsumption){
            System.out.println("Не достаточно в миске для такой киски как " + name + "!");
        } else {
            bowl.servePortion(foodConsumption);
            System.out.println(name + " покушал " + foodConsumption + " корма");
            setNotHungry();
        }
    }

    @Override
    public String toString() {
        return "Task1.Cat{" +
                "isHungry=" + isHungry +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", maxRunDistance=" + maxRunDistance +
                '}';
    }
}
