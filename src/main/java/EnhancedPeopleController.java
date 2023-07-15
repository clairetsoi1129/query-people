import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class EnhancedPeopleController extends PeopleController {
    public EnhancedPeopleController(PeopleModel peopleModel, PeopleView peopleView) {
        super(peopleModel, peopleView);
    }

    // Q1. What if your program has to load from a different CSV file, or combine multiple CSV files.
    // A1-3. To process more than 1 files, only need to update the processFileInput method here
    // Q2. What if the CSV format changes but you have to load the same data?
    // A2. To process more different CSV format, eg. different separator, only need to add the separator in the builder below
    public void start(){
        peopleView.printWelcomeText();
        ((EnhancedPeopleView)peopleView).printDataSourceText();
        String dataSource = ((EnhancedPeopleView)peopleView).getDataSource();
        processDataSource(dataSource);
        peopleView.printOptionsText();
        String option = peopleView.getOption();
        List<Person> result = processOption(option);
        peopleView.printResult(result);
        peopleView.close();
    }

    public void processDataSource(String option) {
        switch (option) {
            case "1" -> {
                peopleView.printInputFileText();
                String filePath = peopleView.getFilePaths();
                processCsvInput(filePath);
            }
            case "2" -> {
                peopleView.printInputFileText();
                String filePath = peopleView.getFilePaths();
                processTsvInput(filePath);
            }
            case "3" -> {
                ((EnhancedPeopleView)peopleView).printJsonText();
                String path = ((EnhancedPeopleView)peopleView).getJsonPath();
                processJsonInput(path);
            }
            default -> {

            }
        }

    }

    public void processFileInput(String filepath, char separator) {
        String[] filepathArr = filepath.split(",");

        try {
            int count = 1;
            for (String s : filepathArr) {
                List<Person> personList = new CsvToBeanBuilder(new FileReader(s.trim()))
                        .withType(Person.class)
                        .withSeparator(separator) // to handle different separator, you can update this
                        .build().parse();

                for (Person person : personList) {
                    person.setPosition(count++);
                }
                peopleModel.addPersonList(personList);
            }
        }catch (FileNotFoundException e){
            System.err.println("File "+filepath+ " not found!");
            System.exit(1);
        }
    }

    public void processCsvInput(String filepath) {
        processFileInput(filepath, ',');
    }

    public void processTsvInput(String filepath) {
        processFileInput(filepath, '\t');
    }

    public void processJsonInput(String path) {
        JsonReader jsonReader = new JsonReader();
        List<Person> personList = jsonReader.readJson(path);
        peopleModel.addPersonList(personList);
    }

    // Q3. How might you add new queries?
    // A3-3. Update the processOption to include new filter here
    public List<Person> processOption(String option) {
        List<Person> pList = super.processOption(option);
        if (pList == null)
            return switch (option) {
                case "7" -> ((EnhancedPeopleModel)peopleModel).filterByFirstName("France");
                default -> null;
            };
        else
            return pList;
    }
}
