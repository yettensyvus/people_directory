package org.example.classes;

import java.io.*;
import java.util.ArrayList;

public class PeopleController {
    private String file_name = null;
    private ArrayList<People> people_list = new ArrayList<>();

    //constructor
    public PeopleController(String file_name) {
        this.file_name = file_name;
    }

    //add all peoples from file to ArrayList
    public ArrayList<People> get_people() {
        BufferedReader br = null;

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
    public ArrayList<People> add_people(People p) {
        People people = new People(p);
        people_list.add(people);
        return people_list;
    }

    //edit people data
    public ArrayList<People> edit_people(int index, People p) {
        for (int i = 0; i < people_list.size(); i++) {
            if (index == people_list.get(i).get_id_people()) {
                people_list.set(i, new People(p));
            }
        }
        return people_list;
    }

    public boolean check_by_id(int index) {
        for (int i = 0; i < people_list.size(); i++) {
            if (index == people_list.get(i).get_id_people()) {
                return true;
            }
        }
        return false;
    }

    public String print_people_by_id(int index) {
        for (int i = 0; i < people_list.size(); i++) {
            if (index == people_list.get(i).get_id_people())
                return people_list.get(i).toString();

        }
        return "there is no such person with that id";
    }

    //save to file new data
    public void save_to_file(ArrayList<People> list) {
        BufferedWriter br = null;

        try {
            br = new BufferedWriter(new FileWriter(file_name, false));

            for (int i = 0; i < people_list.size(); i++) {
                br.write(people_list.get(i).toString());
            }
            br.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
