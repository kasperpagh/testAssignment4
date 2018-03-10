package pagh.cphbusiness.test;
import com.google.gson.Gson;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import pagh.cphbusiness.Controller;
import pagh.cphbusiness.entities.Person;
import pagh.cphbusiness.exceptions.IllegalNameException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class UnitTests
{
    private static Controller ctrl;

    @BeforeAll
    public static void setUpClass()
    {
        ctrl = new Controller();
    }


    //Nonsense filename given, therefore exception should be thrown
    @Test
    public void testCase_ReadFileFailure()
    {
        assertThrows(FileNotFoundException.class, () ->
        {
            ctrl.readFile("testing123");
        });
    }

    //a sensible fileName (exsisting) is given, therefore a String representation is returned
    @Test
    public void testCase_ReadFileSucces()
    {
        try
        {
            assertTrue(ctrl.readFile("nameFile").equalsIgnoreCase("Kasper Roland Pagh, Bubbers Babekar, John Hitler, Sussi, Leo, MC Marry Poppinzz, Heinrich Von Knùgelbreachen, Gnomis Minimalis Totalishow, "));
        }
        catch (IOException e)
        {
            assertTrue(false);
        }
    }

    //Boundary test
    @Test
    public void testCase3_ParsePerson()
    {
        assertThrows(IllegalNameException.class, () ->
        {
            ctrl.parsePerson("");
        });
    }

    //Boundary test
    @Test
    public void testCase4_ParsePerson()
    {
        assertThrows(IllegalNameException.class, () ->
        {
            ctrl.parsePerson("a");
        });
    }

    //Boundary test
    @Test
    public void testCase5_ParsePerson()
    {
        assertThrows(IllegalNameException.class, () ->
        {
            ctrl.parsePerson("aa");
        });
    }

    @Test
    public void testCase6_ParsePerson()
    {
        Person p = null;

        try
        {
            p = ctrl.parsePerson("test");
            if (p != null)
            {
                assertTrue(p.getName().equalsIgnoreCase("test"));
            }
            else
            {
                assertTrue(false);
            }
        }
        catch (IllegalNameException e)
        {
            assertTrue(false);
        }
    }

    @Test //name of length 49.
    public void testCase7_ParsePerson()
    {
        Person p = null;

        try
        {
            p = ctrl.parsePerson("FSp2Omo5OfhfsKfch64bqxFfrNyAZzdDAjPXQRAT3p7atUn5U");

            if (p != null)
            {
                assertTrue(p.getName().equalsIgnoreCase("FSp2Omo5OfhfsKfch64bqxFfrNyAZzdDAjPXQRAT3p7atUn5U"));
            }
            else
            {
                assertTrue(false);
            }
        }
        catch (IllegalNameException e)
        {
            assertTrue(false);
        }

    }

    @Test //length 50
    public void testCase8_ParsePerson()
    {
        assertThrows(IllegalNameException.class, () ->
        {
            ctrl.parsePerson("9QQVh6cWVBBup3iihFQKBg4mFwm8uyrzp5LvSYOiea4HosemaF");
        });
    }

    @Test //length 51
    public void testCase9_ParsePerson()
    {
        assertThrows(IllegalNameException.class, () ->
        {
            ctrl.parsePerson("9QQVh6cWVBBup3iihFQKBg4mFwm8uyrzp5LvSYOiea4HosemaF1");
        });
    }


    @Test
    public void testCase10_GetAllPeople()
    {
        assertThrows(FileNotFoundException.class, () ->
        {
            ctrl.getAllPeople("testing123");
        });
    }

    @Test
    public void testCase11_GetAllPeople()
    {
        try
        {
            assertTrue(ctrl.getAllPeople("nameFile").size() == 8);
        }
        catch (IOException e)
        {
            assertTrue(false);
        }
    }

    @Test //first long name is chosen
    public void testCase12_getPersonWithLongestName()
    {
        ArrayList<Person> people = new ArrayList<>();
        try
        {
            people.add(new Person("Kasper Roland Pagh"));
            people.add(new Person("Bubbers Babekar"));
            people.add(new Person("John Hitler"));
            people.add(new Person("Sussi"));

            people.add(new Person("Leo"));
            people.add(new Person("MC Marry Poppinzz"));
            people.add(new Person("Heinrich Von Knùgelbreachen"));
            people.add(new Person("Gnomis Minimalis Totalishow"));

            assertTrue(ctrl.getPersonWithLongestName(people).getName().equalsIgnoreCase("Heinrich Von Knùgelbreachen"));
        }
        catch (IllegalNameException e)
        {
            assertTrue(false);
        }

    }

    @Test
    public void testCase13_getPersonWithShortestName()
    {
        ArrayList<Person> people = new ArrayList<>();
        try
        {
            people.add(new Person("Kasper Roland Pagh"));
            people.add(new Person("Bubbers Babekar"));
            people.add(new Person("John Hitler"));
            people.add(new Person("Sussi"));

            people.add(new Person("Leo"));
            people.add(new Person("MC Marry Poppinzz"));
            people.add(new Person("Heinrich Von Knùgelbreachen"));
            people.add(new Person("Gnomis Minimalis Totalishow"));

            assertTrue(ctrl.getPersonWithShortestName(people).getName().equalsIgnoreCase("Leo"));
        }
        catch (IllegalNameException e)
        {
            assertTrue(false);
        }
    }

    @Test
    public void testCase14_byOurPowersCombinedWeAreCaptainPlanet()
    {
        try
        {
            Person a = new Person("bobby");
            Person b = new Person("jimmy");
            assertTrue(ctrl.byOurPowersCombinedWeAreCaptainPlanet(a, b).getName().equalsIgnoreCase("by our powers combined, we are Captain planet"));
        }
        catch (IOException e)
        {
            assertTrue(false);
        }
    }

    @Test
    public void testCase15_sortPeopleByName()
    {
        ArrayList<Person> people = new ArrayList<>();
        ArrayList<Person> peopleToCompareWith = new ArrayList<>();
        try
        {
            people.add(new Person("Kasper Roland Pagh"));
            people.add(new Person("Bubbers Babekar"));
            people.add(new Person("John Hitler"));
            people.add(new Person("Sussi"));
            people.add(new Person("Leo"));
            people.add(new Person("MC Marry Poppinzz"));
            people.add(new Person("Heinrich Von Knùgelbreachen"));
            people.add(new Person("Gnomis Minimalis Totalishow"));


            peopleToCompareWith.add(new Person("Bubbers Babekar"));
            peopleToCompareWith.add(new Person("Gnomis Minimalis Totalishow"));
            peopleToCompareWith.add(new Person("Heinrich Von Knùgelbreachen"));
            peopleToCompareWith.add(new Person("John Hitler"));
            peopleToCompareWith.add(new Person("Kasper Roland Pagh"));
            peopleToCompareWith.add(new Person("Leo"));
            peopleToCompareWith.add(new Person("MC Marry Poppinzz"));
            peopleToCompareWith.add(new Person("Sussi"));

            people = ctrl.sortPeopleByName(people);

            for (int i = 0; i < people.size(); i++)
            {
                assertTrue(people.get(i).getName().equalsIgnoreCase(peopleToCompareWith.get(i).getName()));
            }
        }
        catch (IllegalNameException e)
        {
            assertTrue(false);
        }
    }

    @Test
    public void testCase16_savePersonListToFile()
    {
        ArrayList<Person> people = new ArrayList<>();
        try
        {
            people.add(new Person("Kasper Roland Pagh"));
            people.add(new Person("Bubbers Babekar"));
            people.add(new Person("John Hitler"));
            people.add(new Person("Sussi"));
            people.add(new Person("Leo"));
            people.add(new Person("MC Marry Poppinzz"));
            people.add(new Person("Heinrich Von Knùgelbreachen"));
            people.add(new Person("Gnomis Minimalis Totalishow"));
            ctrl.savePersonListToFile(false, people, "nameFile");
        }
        catch (IOException e)
        {
            assertTrue(false);
        }
    }

    @Test
    public void testCase17_savePersonListToFile()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            ctrl.savePersonListToFile(false, null, "aa");
        });
    }

    @Test
    public void testCase18_makeJsonList()
    {
        ArrayList<Person> people = new ArrayList<>();
        try
        {
            people.add(new Person("Kasper Roland Pagh"));
            people.add(new Person("Bubbers Babekar"));
            people.add(new Person("John Hitler"));
            people.add(new Person("Sussi"));
            people.add(new Person("Leo"));
            people.add(new Person("MC Marry Poppinzz"));
            people.add(new Person("Heinrich Von Knùgelbreachen"));
            people.add(new Person("Gnomis Minimalis Totalishow"));
            String jsonString = ctrl.makeJsonList(people);

            try
            {
                Gson gson = new Gson();
                gson.toJson(jsonString);
            }
            catch (Exception e)
            {
                assertTrue(false);
            }

        }
        catch (IOException e)
        {
            assertTrue(false);
        }
    }

    @Test
    public void testCase19_JsonParsePerson()
    {
        try
        {
            Gson gson = new Gson();
            gson.toJson(new Person("tester"));
        }
        catch (Exception e)
        {
            assertTrue(false);
        }

        assertTrue(true);
    }
}

