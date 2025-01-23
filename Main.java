public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Тузик", 1, 5);
        Dog dog2 = new Dog("Шашлык", 1, 6);
        System.out.println("Общее количество созданных собак " + Dog.getTotalCreatedDogs());
        System.out.println("\n\tЗдесь собаки плавают");
        dog1.swim(5);
        dog2.swim(15);


        System.out.println("\n\tЗдесь собаки бегают");
        dog1.run(300);
        dog2.run(600);


        Cat[] cats = new Cat[9];
        Cat cat1 = new Cat("Борис", 2, 6);
        Cat cat2 = new Cat("Барсик", 5, 7);
        Cat cat3 = new Cat("Машка", 3, 2);
        Cat cat4 = new Cat("Зося", 2, 12);
        Cat cat5 = new Cat("Васька", 1, 8);
        Cat cat6 = new Cat("Рыжик", 1, 8);
        Cat cat7 = new Cat("Пушистик", 12, 8);
        Cat cat8 = new Cat("Взятка", 13, 8);
        Cat cat9 = new Cat("Незнайка", 5, 8);

        cats[0] = cat1;
        cats[1] = cat2;
        cats[2] = cat3;
        cats[3] = cat4;
        cats[4] = cat5;
        cats[5] = cat6;
        cats[6] = cat7;
        cats[7] = cat8;
        cats[8] = cat9;
        System.out.println("\nОбщее количество созданных кошек " + Cat.getTotalCreatedCats());

        System.out.println("\n\tЗдесь кошки бегают");
        cat1.run(150);
        cat2.run(201);

        System.out.println("\n\t Здесь создаём миску");
        Bowl bowl = new Bowl(120);
        System.out.println("Емкость миски = " + bowl.getFoodCapacity());

        // Метод сделан так что у каждой кошки нужно разное количество корма.
        // Даже если одна не сможет поесть, так как не хватает корма, то другая кошка все равно сможет полакомиться.
        System.out.println("\n\tЗдесь кошки кушают");
        for (Cat cat : cats) {
            cat.eat(bowl);
        }


        System.out.println("\n\tЗдесь добавим в миску корма и покорим кошек еще раз. Так как не все покушали");
        bowl.addFood(100);
        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        // Здесь сделаем всех кошек голодными
        for (Cat cat : cats) {
            cat.setHungry();
        }


    }
}
