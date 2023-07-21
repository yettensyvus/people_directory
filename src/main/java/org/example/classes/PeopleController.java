package org.example.classes;

import java.io.*;
import java.util.ArrayList;

public class PeopleController {
    private final String file_name;
    private final ArrayList<People> people_list = new ArrayList<>();

    //constructor
    public PeopleController(String file_name) {
        this.file_name = file_name;
    }

    //add all peoples from file to ArrayList
    public ArrayList<People> get_people() {
        BufferedReader br;

        try {

            br = new BufferedReader(new FileReader(file_name));

            String line;

            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    People people = new People(line);
                    people_list.add(people);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return people_list;
    }

    //add people in ArrayList
    public void add_people(People p) {
        People people = new People(p);
        people_list.add(people);
    }

    //edit people data
    public void edit_people(int index, People p) {
        for (int i = 0; i < people_list.size(); i++) {
            if (index == people_list.get(i).get_id_people()) {
                people_list.set(i, new People(p));
            }
        }
    }

    public boolean check_by_id(int index) {
        for (People people : people_list) {
            if (index == people.get_id_people()) {
                return true;
            }
        }
        return false;
    }

    public String print_people_by_id(int index) {
        for (People people : people_list) {
            if (index == people.get_id_people())
                return people.toString();

        }
        return "there is no such person with that id";
    }

    //save to file new data
    public void save_to_file() {
        BufferedWriter br;

        try {
            br = new BufferedWriter(new FileWriter(file_name, false));

            for (People people : people_list) {
                br.write(people.toString());
            }
            br.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
