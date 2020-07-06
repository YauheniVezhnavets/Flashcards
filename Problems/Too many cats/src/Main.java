class Cat {

    private String name;
    private int age;
    private static int counter = 0;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;

        if (counter > 5) {
            System.out.println("You have too many cats");
        }
    }

    public static int getNumberOfCats() {
       return counter;
    }
}

//class Main {
//    public static void main(String[] args) {
//        Cat cat1 = new Cat("s1",10);
//        Cat cat2 = new Cat("s2",11);
//        Cat cat3 = new Cat("s3",12);
//        Cat cat4 = new Cat("s4",13);
//        Cat cat5 = new Cat("s5",14);
//        Cat cat6 = new Cat("s6",15);
//        Cat cat7 = new Cat("s7",16);
//        Cat.getNumberOfCats();
//    }
//}