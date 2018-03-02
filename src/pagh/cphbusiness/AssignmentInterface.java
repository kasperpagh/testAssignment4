package pagh.cphbusiness;

import pagh.cphbusiness.entities.Person;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface AssignmentInterface
{
    //Reads a text file and return the content as a string
    public String readFile() throws IOException;

    //transform a person, of the given name, into a Person object.
    public Person parsePerson(String name);

    //Find all people in the text file, and return them as an array list.
    public ArrayList<Person> getAllPeople() throws IOException;

    //find the person  represented with the longest string of character
    public Person getPersonWithLongestName(ArrayList<Person> pplList);

    //find the person  represented with the shortest string of character
    public Person getPersonWithShortestName(ArrayList<Person> pplList);

    //Take two people and fuse them together (by their powers combined) into captain planet.
    public Person byOurPowersCombinedWeAreCaptainPlanet(Person a, Person b);

    //Sorts the list of people alphabetically
    public ArrayList<Person> sortPeopleByName(ArrayList<Person> pplList);

    //takes an arrayList of ppl and saves it to the text file.
    public boolean savePersonListToFile(boolean append, ArrayList<Person> pplList) throws FileNotFoundException;

    //returns a JSON representation of the people list.
    public String makeJsonList(ArrayList<Person> pplList);

    //Returns a JSON representation of a single Person object.
    public String makeJsonPerson(Person person);
}
