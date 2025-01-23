public class Bowl {
    private int foodCapacity;
    private final int MAX_CAPACITY = 100;

    public Bowl(int foodCapacity) {
        addFood(foodCapacity);

    }

     void addFood(int foodCapacity) {
        if (foodCapacity > MAX_CAPACITY)
            this.foodCapacity = MAX_CAPACITY;
        else {
            // тут вторая проверка так как у нас уже может быть еда в миске после того как покушали коты и нужно сверить
            // что бы не загрузили больше чем 100 корма.
            if(this.foodCapacity + foodCapacity > MAX_CAPACITY){
                this.foodCapacity = MAX_CAPACITY;
            } else{
            this.foodCapacity = foodCapacity;
            }
        }
    }

     int getFoodCapacity() {
        return foodCapacity;
    }

    void servePortion(int amount){
        foodCapacity -= amount;
    }
}
