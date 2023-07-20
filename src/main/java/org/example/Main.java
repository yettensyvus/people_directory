package org.example;

import org.example.classes.People;
import org.example.classes.PeopleController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PeopleController pc = new PeopleController("src/main/java/org/example/data/people.txt");

        ArrayList<People> people_list;

        people_list = pc.get_people();

        for(int i = 0; i < people_list.size(); i++)
        {
            System.out.println(people_list.get(i).toString());
        }
    }
}