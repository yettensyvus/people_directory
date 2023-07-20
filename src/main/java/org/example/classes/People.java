package org.example.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class People {

    //people private variables
    private int id_people;
    private String name ;
    private String surname;
    private LocalDate date_of_birth;
    private String number;
    private String email;

    //getter of private variables
    public int get_id_people()
    {
        return id_people;
    }

    public String get_name()
    {
        return name;
    }
    public String get_surname()
    {
        return surname;
    }

    private LocalDate get_date_of_birth()
    {
        return date_of_birth;
    }

    public String get_number()
    {
        return number;
    }
    public String get_email()
    {
        return email;
    }


    //setter of private variables
    public int set_id_people(int id_people)
    {
        return this.id_people = id_people;
    }

    public String set_name(String name)
    {
        return this.name = name;
    }

    public String set_surname(String surname)
    {
        return this.surname = name;
    }
    public LocalDate set_date_of_birth(LocalDate date_of_birth)
    {
        return this.date_of_birth = date_of_birth;
    }



    public String set_number(String number)
    {
        return this.number = number;
    }

    public String set_email(String email)
    {
        return this.email = email;
    }
    //emplty implicit constructor
    public People()
    {
        name = surname = number = email =  null;
    }

    //constructor with parameters
    public People(int id_people, String name, String surname, LocalDate date_of_birth, String number, String email)
    {
        this.id_people = id_people;
        this.name = name;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
        this.number = number;
        this.email = email;
    }

    public People(String file_line)
    {
        String[] file_data = file_line.split(" ");
        id_people = Integer.parseInt(file_data[0]);
        name = file_data[1];
        surname = file_data[2];
        date_of_birth = LocalDate.parse(file_data[3]);
        number = file_data[4];
        email = file_data[5];
    }

    public String toString()
    {
        return get_id_people() + " " + get_name() + " " + get_surname() + " " + get_date_of_birth().toString() + " " + get_number() + " " + get_email();
    }
}
