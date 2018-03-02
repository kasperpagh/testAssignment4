package pagh.cphbusiness;

import pagh.cphbusiness.entities.Person;

import java.io.IOException;
import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        Controller ctrl = new Controller();

        try
        {
            System.out.println(ctrl.makeJsonList(ctrl.getAllPeople()));
            Person p = new Person("bobby");

            System.out.println(ctrl.makeJsonPerson(p));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
