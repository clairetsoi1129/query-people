import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ValidationException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestPeopleView {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private PeopleView peopleView;
    private Scanner mockScanner;

    @BeforeEach
    public void setUp() {
        mockScanner = mock(Scanner.class);
        peopleView = new PeopleView(mockScanner);

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(System.in);
    }

    @Test
    void testWelcomeMessage()  throws ValidationException {
        peopleView.printWelcomeText();

        assertEquals("Welcome to querying people.",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void printInputFileText()  throws ValidationException {
        peopleView.printInputFileText();

        assertEquals("Please input the path of the file(s), \n" +
                        "if you have more than one files, please add ',' in between. eg. fileA, fileB.\n" +
                        "You can also use prepared file [testfile/input.csv]:",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void printOptionsText()  throws ValidationException {
        peopleView.printOptionsText();

        assertEquals("""
                Please select from one of the six options below:\s
                OPTION 1: Every person who has “Esq” in their company name.
                OPTION 2: Every person who lives in “Derbyshire”.
                OPTION 3: Every person whose house number is exactly three digits.
                OPTION 4: Every person whose website URL is longer than 35 characters
                (including the protocol and subdomain).
                OPTION 5: Every person who lives in a postcode area with a single-digit value.
                (Note that in UK postcodes the “area” is the first portion before the space,
                so anything starting M3 or M7 would be acceptable, while anything startingM10+ would not.
                The portion after the space is not relevant.)
                OPTION 6: Every person whose first phone number is numerically larger than their second phone number.""",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void testGetFilePaths() throws ValidationException {
        //set up the scanner
        when(mockScanner.nextLine()).thenReturn("testfile/input.csv");
        assertEquals("testfile/input.csv", peopleView.getFilePaths());
        
    }

    @Test
    void testGetOptionSuccess() throws ValidationException {
        //set up the scanner
        when(mockScanner.nextLine()).thenReturn("1");
        assertEquals("1", peopleView.getOption());
    }
}
