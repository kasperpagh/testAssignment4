package pagh.cphbusiness;

import com.google.gson.Gson;
import pagh.cphbusiness.entities.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Controller implements AssignmentInterface
{
    /*
    * No border values since no input
    *
    *
    */
    @Override
    public String readFile() throws IOException
    {

        File file = new File("nameFile");
        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        try
        {
            scanner.useDelimiter(",");
            while (scanner.hasNext())
            {
                sb.append(scanner.next());
                sb.append(", ");
            }
            scanner.close();
        }
        finally
        {
            scanner.close();
        }

        return sb.toString();
    }

    /*
    *
    *
    *
    */
    @Override
    public Person parsePerson(String name)
    {
        return new Person(name);
    }

    /*
    *
    *
    *
    */
    @Override
    public ArrayList<Person> getAllPeople() throws IOException
    {

        File file = new File("nameFile");
        Scanner scanner = new Scanner(file);
        ArrayList<Person> pplList = new ArrayList<>();
        try
        {
            scanner.useDelimiter(",");
            while (scanner.hasNext())
            {
                pplList.add(new Person(scanner.next()));
            }
            scanner.close();
        }
        finally
        {
            scanner.close();
        }
        return pplList;
    }

    /*
    *
    *
    *
    */
    @Override
    public Person getPersonWithLongestName(ArrayList<Person> pplList)
    {
        Person currentLongestName = null;

        for (Person p : pplList)
        {
            if (currentLongestName == null || p.getName().length() > currentLongestName.getName().length())
            {
                currentLongestName = p;
            }
        }

        return currentLongestName;
    }

    /*
    *
    *
    *
    */
    @Override
    public Person getPersonWithShortestName(ArrayList<Person> pplList)
    {
        Person currentShortestName = null;

        for (Person p : pplList)
        {
            if (currentShortestName == null || p.getName().length() < currentShortestName.getName().length())
            {
                currentShortestName = p;
            }
        }

        return currentShortestName;
    }

    /*
    *
    *
     */
    @Override
    public Person byOurPowersCombinedWeAreCaptainPlanet(Person a, Person b)
    {
        String first = a.getName();
        String second = b.getName();
        return new Person("By " + first + "s and " + second + "s powers combined, this is Captain Planet!");
    }

    /*
    *
    *
    *
    */
    @Override
    public ArrayList<Person> sortPeopleByName(ArrayList<Person> pplList)
    {
        ArrayList<String> tempList = new ArrayList<>();

        for (Person p : pplList)
        {
            tempList.add(p.getName());
        }

        Collections.sort(tempList, String.CASE_INSENSITIVE_ORDER);
        ArrayList<Person> pList = new ArrayList<>();
        for (String s : tempList)
        {
            pList.add(new Person(s));
        }
        return pList;
    }

    /*
    *
    *
    *
    */
    @Override
    public boolean savePersonListToFile(boolean append, ArrayList<Person> pplList) throws FileNotFoundException
    {

        try (PrintWriter pw = new PrintWriter(new FileWriter("nameFile", true)))
        {
            if (append)
            {
                System.out.println("appending...");
                for (Person p : pplList)
                {
                    pw.append(p.getName() + ",");
                }
            }
            else
            {
                PrintWriter pwNonAppend = new PrintWriter(new FileWriter("nameFile"));
                System.out.println("not appending");
                StringBuilder sb = new StringBuilder();
                for (Person p : pplList)
                {
                    sb.append(p.getName());
                }
                pwNonAppend.println(sb.toString());
                pwNonAppend.close();
            }
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    /*
    *
    *
    *
    */
    @Override
    public String makeJsonList(ArrayList<Person> pplList)
    {
        Gson gson = new Gson();
        return gson.toJson(pplList);
    }

    /*
    *
    *
    *
    */
    @Override
    public String makeJsonPerson(Person person)
    {
        Gson gson = new Gson();
        return gson.toJson(person);
    }
}
