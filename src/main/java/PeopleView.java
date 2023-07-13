public class PeopleView {
    private final String MSG_WELCOME = "Welcome to querying people.";
    private final String MSG_INPUT_FILE = "Please input the absolute path of the file(s), " +
            "if you have more than one files, please add ',' in between. eg. fileA, fileB.";

    private final String MSG_OPTIONS = """
            Please select from one of the six options below:\s
            OPTION 1: Every person who has “Esq” in their company name.
            OPTION 2: Every person who lives in “Derbyshire”.
            OPTION 3: Every person whose house number is exactly three digits.
            OPTION 4: Every person whose website URL is longer than 35 characters
            (including the protocol and subdomain).
            OPTION 5: Every person who lives in a postcode area with a single-digit value. (Note that in UK postcodes the “area” is the first portion before the space,so anything starting M3 or M7 would be acceptable, while anything startingM10+ would not. The portion after the space is not relevant.)
            OPTION 6: Every person whose first phone number is numerically larger than their second phone number.""";

    public String printWelcomeText(){
        return printMessage(MSG_WELCOME);
    }

    public String printInputFileText(){
        return printMessage(MSG_INPUT_FILE);
    }

    public String printOptionsText() {
        return printMessage(MSG_OPTIONS);
    }

    private String printMessage(String text){
        System.out.println(text);
        return text;
    }
}
