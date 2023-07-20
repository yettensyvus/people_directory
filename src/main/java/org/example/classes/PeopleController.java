package org.example.classes;

import java.io.*;
import java.util.ArrayList;

public class PeopleController
{
    private String file_name = null;

    private ArrayList<People> people_list = new ArrayList<>();

    public PeopleController(String file_name)
    {
        this.file_name = file_name;
    }

    public ArrayList<People> get_people()
    {

        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(file_name));

            String line;

            while ((line = br.readLine()) != null)
            {
                People people = new People(line);
                people_list.add(people);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return people_list;
    }

    public ArrayList<People> add_people(People p)
    {
        People people = new People(p);
        people_list.add(people);
        return people_list;
    }

    public void save_to_file(People p)
    {
        BufferedWriter br = null;

        try {
            br = new BufferedWriter(new FileWriter(file_name, true));
            br.write(p.toString());
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
