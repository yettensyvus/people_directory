package org.example;

import org.example.classes.People;
import org.example.classes.PeopleController;
import org.example.classes.cls;

import javax.swing.text.html.parser.Parser;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
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

    public static boolean menu()
    {

        new cls();
        System.out.println("Choose an item from the menu:\n");
        System.out.println("1)  Show all people.\n");
        System.out.println("2)  Add people.\n");
        System.out.print("\r\nSelect an option: ");

        switch (input.nextInt()) {

            case 1:
                new cls();

                for(int i = 0; i < people_list.size(); i++)
                {
                    System.out.println(people_list.get(i).toString());
                }

                System.out.println(" ");
                System.out.print("\r\n<< Enter key to return to the main menu >>");
                scan.nextLine();
                return true;
            case 2:
                new cls();

                System.out.print("\n Name: ");
                String name = scan.nextLine();
                System.out.print("\n Surname: ");
                String surname = scan.nextLine();
                System.out.print("\n Date of birth: ");
                LocalDate date_of_birth = LocalDate.parse(scan.nextLine());
                System.out.print("\n Telephone number: ");
                String number = scan.nextLine();
                System.out.print("\n Email: ");
                String email = scan.nextLine();

                People p = new People(people_list.size() + 1, name, surname, date_of_birth, number, email);

                pc.add_people(p);
                pc.save_to_file(p);

                System.out.println(" ");
                System.out.print("\r\n<< Enter key to return to the main menu >>");
                scan.nextLine();
                return true;

            default:
                return true;

        }

    }

}