package lab10;

public class Program {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Tiger tiger = new Tiger();
        Turtle turtle = new Turtle();

        Animal[] animals = new Animal[3];
        animals[0] = dog;
        animals[1] = tiger;
        animals[2] = turtle;

        Person person = new Person() {
            private int hp = 100;

            public void control(Animal animal) {
                if (animal instanceof Tiger) {
                    hp = hp - 80;
                    System.out.println("You have overpowered the " + animal.getName());
                } else if (animal instanceof Dog) {
                    hp = hp - 10;
                    System.out.println("You have overpowered the " + animal.getName());
                } else if (animal instanceof Turtle) {
                    System.out.println("You have overpowered the " + animal.getName());
                }
            }

            public void showInfo() {
                System.out.println("Person HP:" + hp);
            }
        };

        showResult(animals, person);
    }

    private static void showResult(Animal[] animals, Person P) {
        for (int i = 0; i < animals.length; i++) {
            P.control(animals[i]);
            System.out.printf("Animal%d: %s\n", i + 1, animals[i].getName());
            if (animals[i] instanceof Barkable) {
                System.out.printf("Animal%d barked %s\n", i + 1, ((Barkable) animals[i]).Bark());
            }
            P.showInfo();
        }
    }
}
