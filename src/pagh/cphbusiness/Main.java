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

            System.out.println(ctrl.readFile("nameFile"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
