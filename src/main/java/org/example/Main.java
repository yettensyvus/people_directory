package org.example;

import org.example.classes.People;
import org.example.classes.PeopleController;
import org.example.classes.cls;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Scanner pause = new Scanner(System.in);

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
        System.out.print("\r\nSelectati o optiune: ");

        switch (input.nextInt()) {

            case 1:
                new cls();

                for(int i = 0; i < people_list.size(); i++)
                {
                    System.out.println(people_list.get(i).toString());
                }

                System.out.println(" ");
                System.out.print("\r\n<< Tastati Enter pentru a reveni la meniul principal >>");
                pause.nextLine();
                return true;

            default:
                return true;

        }

    }

}