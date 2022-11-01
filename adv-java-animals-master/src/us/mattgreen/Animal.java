package us.mattgreen;

import java.util.Scanner;

public class Animal implements Talkable {
    Scanner scanner = new Scanner(System.in);
    Cat cat;
    Dog dog;
    Teacher teacher;
    String input;

    public Object createObj() {
        System.out.println("What type of animal would you like to create?");
        System.out.println("Create cat: 1");
        System.out.println("Create dog: 2");
        System.out.println("Create teacher: 3");
        System.out.println("Please enter the animal number:");
        input = scanner.nextLine();
        do {
            switch (input) {
                case "1" -> {
                    System.out.println("Please enter a name: ");
                    String catName = scanner.nextLine();
                    System.out.println("Enter number of mouses killed: ");
                    int mouses = Integer.parseInt(scanner.nextLine());
                    cat = new Cat(mouses, catName);
                    return cat;
                }
                case "2" -> {
                    System.out.println("Please enter a name: ");
                    String dogName = scanner.nextLine();
                    System.out.println("Is the dog friendly? Enter true or false");
                    boolean friendly = Boolean.parseBoolean(scanner.nextLine());
                    dog = new Dog(friendly, dogName);
                    return dog;
                }
                case "3" -> {
                    System.out.println("Please enter a name: ");
                    String teacherName = scanner.nextLine();
                    System.out.println("Enter age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    teacher = new Teacher(age, teacherName);
                    return teacher;
                }
            }
        } while (input == "1" || input == "2" || input == "3");
        return null;
    }

    @Override
    public String talk() {
        return switch (input) {
            case "cat" -> cat.talk();
            case "dog" -> dog.talk();
            case "teacher" -> teacher.talk();
            default -> null;
        };
    }

    @Override
    public String getName() {
        return switch (input) {
            case "dog" -> dog.getName();
            case "cat" -> cat.getName();
            case "teacher" -> teacher.getName();
            default -> null;
        };
    }
}
