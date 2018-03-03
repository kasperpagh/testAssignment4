package pagh.cphbusiness.entities;

import pagh.cphbusiness.exceptions.IllegalNameException;

public class Person
{
    private String name;

    public Person(String name) throws IllegalNameException
    {
        if(name == null || name.equalsIgnoreCase("") || name.length() >= 50 || name.length() < 3)
        {
            throw new IllegalNameException();
        }
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
