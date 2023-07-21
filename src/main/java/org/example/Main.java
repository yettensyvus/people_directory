package org.example;

import org.example.classes.People;
import org.example.classes.PeopleController;
import org.example.classes.cls;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static PeopleController pc = new PeopleController("src/main/java/org/example/data/people.txt");
    static ArrayList<People> people_list;

    public static void main(String[] args) {
        people_list = pc.get_people();

        boolean showMenu = true;
        while (showMenu) {
            showMenu = menu();
        }
    }

    public static boolean menu() {
        int index;
        String name;
        String surname;
        LocalDate date_of_birth;
        String number;
        String email;

        People p;

        new cls();

        System.out.println("Choose an item from the menu:\n");
        System.out.println("1)  Show all people.\n");
        System.out.println("2)  Add people.\n");
        System.out.println("3)  Edit people.\n");
        System.out.println("4)  Delete people.\n");
        System.out.print("\r\nSelect an option: ");

        switch (scan.nextInt()) {

            case 1:
                new cls();

                scan.nextLine();
                for (People people : people_list) {
                    System.out.println(people.toString());
                }

                System.out.println(" ");
                System.out.print("\r\n<< Enter key to return to the main menu >>");
                scan.nextLine();
                return true;
            case 2:
                new cls();

                scan.nextLine();

                System.out.print("\n Name: ");
                name = scan.nextLine();
                System.out.print("\n Surname: ");
                surname = scan.nextLine();
                System.out.print("\n Date of birth: ");
                date_of_birth = LocalDate.parse(scan.nextLine());
                System.out.print("\n Telephone number: ");
                number = scan.nextLine();
                System.out.print("\n Email: ");
                email = scan.nextLine();

                p = new People(pc.max_people_index() + 1, name, surname, date_of_birth, number, email);

                pc.add_people(p);
                pc.save_to_file();

                System.out.println(" ");
                System.out.print("\r\n<< Enter key to return to the main menu >>");
                scan.nextLine();
                return true;
            case 3:
                new cls();

                scan.nextLine();
                System.out.print("\n ID: ");
                index = scan.nextInt();
                System.out.println("Person with ID[" + index + "]: " + pc.print_people_by_id(index));
                scan.nextLine();

                if (pc.check_by_id(index)) {
                    System.out.print("\n NEW Name: ");
                    name = scan.nextLine();
                    System.out.print("\n NEW Surname: ");
                    surname = scan.nextLine();
                    System.out.print("\n NEW Date of birth: ");
                    date_of_birth = LocalDate.parse(scan.nextLine());
                    System.out.print("\n NEW Telephone number: ");
                    number = scan.nextLine();
                    System.out.print("\n NEW Email: ");
                    email = scan.nextLine();

                    p = new People(index, name, surname, date_of_birth, number, email);
                    pc.edit_people(index, p);
                    pc.save_to_file();
                }

                System.out.println(" ");
                System.out.print("\r\n<< Enter key to return to the main menu >>");
                scan.nextLine();
                return true;
            case 4:
                new cls();

                scan.nextLine();
                System.out.print("\n ID: ");
                index = scan.nextInt();
                System.out.println("Person with ID[" + index + "]: " + pc.print_people_by_id(index));
                String key;

                System.out.print("U want to delete this people from list [y/n]: ");
                key = scan.next();
                scan.nextLine();

                if (pc.check_by_id(index) && key.equals("y")) {
                    pc.delete_people(index);
                    pc.save_to_file();
                }

                System.out.println(" ");
                System.out.print("\r\n<< Enter key to return to the main menu >>");
                scan.nextLine();
                return true;
            default:
                return true;

        }

    }

}