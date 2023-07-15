public class EnhancedPeopleView extends PeopleView {
    // Q1. What if your program has to load from a different CSV file, or combine multiple CSV files.
    // A1-2. To tell user how to input more than 1 files, only need to update the message here
    protected final String MSG_INPUT_FILES = """
            Please input the path of the file,\s
            If you have more than 1 files, please add separator ',', eg. fileA,fileB ,\s
            You can also use prepared file [testfile/input.csv]:""";

    // Q3. How might you add new queries?
    // A3-2. Update the processOption to include new filter here
    protected final String MSG_OPTIONS = """
                Please select from one of the options below:\s
                1: Every person who has “Esq” in their company name.
                2: Every person who lives in “Derbyshire”.
                3: Every person whose house number is exactly three digits.
                4: Every person whose website URL is longer than 35 characters
                (including the protocol and subdomain).
                5: Every person who lives in a postcode area with a single-digit value.
                (Note that in UK postcodes the “area” is the first portion before the space,
                so anything starting M3 or M7 would be acceptable, while anything startingM10+ would not.
                The portion after the space is not relevant.)
                6: Every person whose first phone number is numerically larger than their second phone number.
                7: Every person whose first name is “France“.""";

    protected final String MSG_DATA_SOURCES = """
            Please select from one of the data sources below:\s
            1: CSV (delimited by Comma)
            2: TSV (delimited by Tab)
            3: JSON""";

    protected final String MSG_REST_API = """
            Please input the RESTful API URI for the system to get the data""";

    public void printInputFileText(){
        System.out.println(MSG_INPUT_FILES);
    }

    public void printDataSourceText(){
        System.out.println(MSG_DATA_SOURCES);
    }

    public void printJsonText(){
        System.out.println(MSG_REST_API);
    }

    public String getDataSource(){
        return scanner.nextLine().trim();
    }

    public String getJsonPath(){
        return scanner.nextLine().trim();
    }

    public void printOptionsText() {
        System.out.println(MSG_OPTIONS);
    }
}
