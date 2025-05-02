import model.Gender;
import model.Person;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Person[] people = new Person[0];

    private static void createPerson(Integer id, String name, Gender gender) {
        Person newPerson = new Person(id, name, gender);
        people = Arrays.copyOf(people, people.length + 1);
        people[people.length - 1] = newPerson;
        System.out.println(STR."You successfully to create new user => \{newPerson.getId()}-\{newPerson.getName()}-\{newPerson.getGender()}");
    }

    private static void deletePerson(Integer id, String name) {
        boolean found = false;
        for (int i = 0; i < people.length; i++) {
            if (people[i].getId().equals(id) && people[i].getName().equals(name)) {
                for (int j = i; j < people.length - 1; j++) {
                    people[j] = people[j + 1];
                }
                people = Arrays.copyOf(people, people.length - 1);
                System.out.println(STR."Delete User: \{id} - \{name}");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No such person exists in database");
        }
    }

    private static void updatePerson(Integer id, String name, Gender gender) {
        boolean found = false;
        for (int i = 0; i < people.length; i++) {
            if (people[i].getId().equals(id) && people[i].getName().equals(name) && people[i].getGender().equals(gender)) {
                System.out.print("[+] Insert name : ");
                String newName = new Scanner(System.in).nextLine();
                System.out.print("[+] Insert gender : ");
                String newGender = new Scanner(System.in).nextLine().toUpperCase();
                people[i] = new Person(id, newName, Gender.valueOf(newGender));
                System.out.println(STR."User ID \{id} have been update successfully");
                found = true;
            } else {
                System.out.println(STR."[!] User not founded [!]");
            }
            break;
        }
    }

    private static void findById(int id){
        boolean found = false;
        for (int i = 0; i < people.length; i++) {
            if (people[i].getId().equals(id)) {
                System.out.println(STR."User \{id} - \{people[i].getName()} - \{people[i].getGender()}");
                found = true;
            }
        }
    }

    private static void displayAllPerson() {
        if (people.length == 0) {
            System.out.println("No users Please add user first");
            return;
        }
        System.out.println(Arrays.toString(people));
    }

    private static void option() {
        System.out.println("""
                1. View all User
                2. Create a new User
                3. Delete a User
                4. Update a User
                5. Find by ID
                6. Exits
                """);
    }
    public static void main(String[] args) {

        while (true) {
            option();
            Scanner sc = new Scanner(System.in);
            System.out.print("[+] Insert number of option : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    displayAllPerson();
                }
                case 2 -> {
                    System.out.print("[+] Insert user ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("[+] Insert user name : ");
                    String name = sc.nextLine();
                    System.out.print("[+] Insert user gender (Male or Female): ");
                    String gender = sc.nextLine().toUpperCase();
                    createPerson(id, name, Gender.valueOf(gender));
                }
                case 3 -> {
                    System.out.print("[+] Insert user ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("[+] Insert user name : ");
                    String name = sc.nextLine();
                    deletePerson(id, name);
                }
                case 4 -> {
                    System.out.print("[+] Insert user ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("[+] Insert user name : ");
                    String name = sc.nextLine();
                    System.out.print("[+] Insert user gender : ");
                    String gender = sc.nextLine().toUpperCase();
                    updatePerson(id, name, Gender.valueOf(gender));
                }
                case 5 -> {
                    System.out.print("[+] Insert User ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    findById(id);
                }
                case 6 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Invalid choice...");
                }
            }
            System.out.println("Press any key to continue...");
            sc.nextLine();
        }
    }
}

