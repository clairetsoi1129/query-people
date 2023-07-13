import java.text.MessageFormat;
import java.util.List;
import java.util.Scanner;

public class PeopleView {
    private final String MSG_WELCOME = "Welcome to querying people.";
    private final String MSG_INPUT_FILE = "Please input the path of the file(s), \n" +
            "if you have more than one files, please add ',' in between. eg. fileA, fileB.\n" +
            "You can also use prepared file [testfile/input.csv]:";

    private final String MSG_OPTIONS = """
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
                OPTION 6: Every person whose first phone number is numerically larger than their second phone number.""";

    private final Scanner scanner;

    public PeopleView(){
        this.scanner = new Scanner(System.in);
    }

    PeopleView(Scanner scanner){
        this.scanner = scanner;
    }
    public void printWelcomeText(){
        System.out.println(MSG_WELCOME);
    }

    public void printInputFileText(){
        System.out.println(MSG_INPUT_FILE);
    }

    public void printOptionsText() {
        System.out.println(MSG_OPTIONS);
    }

    public String getFilePaths(){
        return scanner.nextLine().trim();
    }

    public String getOption(){
        return scanner.nextLine().trim();
    }

    public void printResult(List<Person> personList){
        if (personList == null)
            printUnknownOption();
        else {
            System.out.println("Count: " + personList.size());

            for (Person person : personList) {
                System.out.println(MessageFormat.format("{0} - {1} {2} - {3}",
                        person.getPosition(), person.getFirstName(), person.getLastName(), person.getCompanyName()));
            }
        }
    }

    public void printUnknownOption(){
        System.out.println("Unknown Option");
    }

    public void close(){
        scanner.close();
    }
}
