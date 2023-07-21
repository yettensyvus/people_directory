package org.example.classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PeopleController {
    private final String file_path;
    private final ArrayList<People> people_list = new ArrayList<>();

    //constructor
    public PeopleController(String file_path) {
        this.file_path = file_path;
    }

    //add all peoples from file to ArrayList
    public ArrayList<People> get_people() {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file_path));
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

    //check if people are in list by id
    public boolean check_by_id(int index) {
        for (People people : people_list) {
            if (index == people.get_id_people()) {
                return true;
            }
        }
        return false;
    }

    //delete people from list
    public void delete_people(int index) {
        for (int i = 0; i < people_list.size(); i++) {
            if (index == people_list.get(i).get_id_people()) {
                people_list.remove(i);
            }
        }
    }

    //print people from list by id
    public String print_people_by_id(int index) {
        for (People people : people_list) {
            if (index == people.get_id_people())
                return people.toString();
        }
        return "there is no such person with that id";
    }


    //max index
    public int max_people_index() {
        int[] arr = new int[people_list.size()];
        for (int i = 0; i < people_list.size(); i++) {
            arr[i] = people_list.get(i).get_id_people();
        }
        return Arrays.stream(arr).max().getAsInt();
    }

    //save to file new data
    public void save_to_file() {
        BufferedWriter br;
        try {
            br = new BufferedWriter(new FileWriter(file_path, false));
            for (People people : people_list) {
                br.write(people.toString());
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
