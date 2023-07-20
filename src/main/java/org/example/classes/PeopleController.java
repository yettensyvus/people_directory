package org.example.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PeopleController
{
    private String file_name = null;

    public PeopleController(String file_name)
    {
        this.file_name = file_name;
    }

    public ArrayList<People> get_people()
    {
        ArrayList<People> people_list = new ArrayList<>();

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
}
