import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ValidationException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPeopleModel {
    private PeopleModel peopleModel;
    @BeforeEach
    public void setUp() {
        peopleModel = new PeopleModel();
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "Aleshia","Tomkiewicz",
                "Alan D Rosenburg Cpa Pc","14 Taylor St","St. Stephens Ward","Derbyshire","CT2 7PP",
                "02035-703597","01944-369967","atomkiewicz@hotmail.com","http://www.alandrosenburgcpapc.co.uk"));
        personList.add(new Person(2, "Aleshia","Tomkiewicz",
                "Alan D Rosenburg Cpa Esq","144 Taylor St","St. Stephens Ward","Kent","CT22 7PP",
                "01835-703597","01944-369967","atomkiewicz@hotmail.com","http://www.alandrosenburgcpap.co.uk"));

        peopleModel.setPersonList(personList);
    }
    @Test
    void testFilterByCompanyNameWithOneRecord()  throws ValidationException {
        List<Person> personList = peopleModel.filterByCompanyName("Esq");

        assertEquals(1,
                personList.size());
    }
    @Test
    void testFilterByCompanyNameWithNoRecord()  throws ValidationException {
        List<Person> personList = peopleModel.filterByCompanyName("Abc");

        assertEquals(0,
                personList.size());
    }
    @Test
    void testFilterByCountyWithOneRecord()  throws ValidationException {
        List<Person> personList = peopleModel.filterByCounty("Derbyshire");

        assertEquals(1,
                personList.size());
    }
    @Test
    void testFilterByCountyWithNoRecord()  throws ValidationException {
        List<Person> personList = peopleModel.filterByCounty("Cheshire");

        assertEquals(0,
                personList.size());
    }
    @Test
    void testFilterByHouseNumber3DigitsWithOneRecord()  throws ValidationException {
        List<Person> personList = peopleModel.filterByHouseNum(3);

        assertEquals(1,
                personList.size());
    }
    @Test
    void testFilterByHouseNumber1DigitsWithNoRecord()  throws ValidationException {
        List<Person> personList = peopleModel.filterByHouseNum(1);

        assertEquals(0,
                personList.size());
    }
    @Test
    void testFilterByWebLength35WithOneRecord()  throws ValidationException {
        List<Person> personList = peopleModel.filterByWebGreaterThanLength(35);

        assertEquals(1,
                personList.size());
    }
    @Test
    void testFilterByWebLength35WithNoRecord()  throws ValidationException {
        List<Person> personList = peopleModel.filterByWebGreaterThanLength(36);

        assertEquals(0,
                personList.size());
    }
    @Test
    void testFilterByPhone1GreaterThanPhone2WithOneRecord()  throws ValidationException {
        List<Person> personList = peopleModel.filterByPhone1GreaterThanPhone2();

        assertEquals(1,
                personList.size());
    }
    @Test
    void testFilterByPostCode1DigitsWithOneRecord()  throws ValidationException {
        List<Person> personList = peopleModel.filterByPostCodeDigits(1);

        assertEquals(1,
                personList.size());
    }
    @Test
    void testFilterByPostCode1DigitsWithNoRecord()  throws ValidationException {
        List<Person> personList = peopleModel.filterByPostCodeDigits(3);

        assertEquals(0,
                personList.size());
    }

}
