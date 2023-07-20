package org.example.classes;

public class People {

    //people private variables
    private int id_people;
    private String name ;
    private String surname;
    private String email;
    private String number;

    //getter of private variables
    public int get_id_people()
    {
        return id_people;
    }

    public String get_name()
    {
        return name;
    }

    public String get_email()
    {
        return email;
    }

    public String get_number()
    {
        return number;
    }

    //setter of private variables
    public int set_id_people(int id_people)
    {
        this.id_people = id_people;
    }

    public String set_name(String name)
    {
        this.name = name;
    }

    public String set_surname(String surname)
    {
        this.surname = name;
    }

    public String set_email(String email)
    {
        this.email = email;
    }

    public String set_number(String number)
    {
        this.number = number;
    }

    public People()
    {
        name = surname = email = number =  null;
    }

    public People(int id_people, String name, String surname, String email, String number)
    {
        this.id_people = id_people;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.number = number;
    }

}
