public class EnhancedPeopleView extends PeopleView{
    // Q1. What if your program has to load from a different CSV file, or combine multiple CSV files.
    // A1-2. To tell user how to input more than 1 files, only need to update the message here
    protected final String MSG_INPUT_FILE = """
            Please input the path of the file,\s
            If you have more than 1 files, please add separator ',', eg. fileA,fileB ,\s
            You can also use prepared file [testfile/input.csv]:""";

    // Q3. How might you add new queries?
    // A3-2. Update the processOption to include new filter here
    protected final String MSG_OPTIONS = """
                Please select from one of the options below:\s
                OPTION 1: Every person who has “Esq” in their company name.
                OPTION 2: Every person who lives in “Derbyshire”.
                OPTION 3: Every person whose house number is exactly three digits.
                OPTION 4: Every person whose website URL is longer than 35 characters
                (including the protocol and subdomain).
                OPTION 5: Every person who lives in a postcode area with a single-digit value.
                (Note that in UK postcodes the “area” is the first portion before the space,
                so anything starting M3 or M7 would be acceptable, while anything startingM10+ would not.
                The portion after the space is not relevant.)
                OPTION 6: Every person whose first phone number is numerically larger than their second phone number.
                OPTION 7: Every person whose first name is “France“.""";

    public void printInputFileText(){
        System.out.println(MSG_INPUT_FILE);
    }

    public void printOptionsText() {
        System.out.println(MSG_OPTIONS);
    }

}
