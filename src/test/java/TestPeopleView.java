import org.junit.jupiter.api.Test;

import javax.validation.ValidationException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPeopleView {
    @Test
    void testWelcomeMessage()  throws ValidationException {
        PeopleView peopleView = new PeopleView();

        assertEquals("Welcome to querying people.", peopleView.printWelcomeText());
    }

    @Test
    void printInputFileText()  throws ValidationException {
        PeopleView peopleView = new PeopleView();

        assertEquals("Please input the absolute path of the file(s), " +
                "if you have more than one files, please add ',' in between. eg. fileA, fileB.", peopleView.printInputFileText());
    }

    @Test
    void printOptionsText()  throws ValidationException {
        PeopleView peopleView = new PeopleView();

        assertEquals("""
                Please select from one of the six options below:\s
                OPTION 1: Every person who has “Esq” in their company name.
                OPTION 2: Every person who lives in “Derbyshire”.
                OPTION 3: Every person whose house number is exactly three digits.
                OPTION 4: Every person whose website URL is longer than 35 characters
                (including the protocol and subdomain).
                OPTION 5: Every person who lives in a postcode area with a single-digit value. (Note that in UK postcodes the “area” is the first portion before the space,so anything starting M3 or M7 would be acceptable, while anything startingM10+ would not. The portion after the space is not relevant.)
                OPTION 6: Every person whose first phone number is numerically larger than their second phone number.""", peopleView.printOptionsText());
    }
}
