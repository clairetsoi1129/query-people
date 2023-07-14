import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class PeopleController {
    protected final PeopleModel peopleModel;
    protected final PeopleView peopleView;

    public PeopleController(PeopleModel peopleModel, PeopleView peopleView) {
        this.peopleModel = peopleModel;
        this.peopleView = peopleView;
    }

    public void start(){
        peopleView.printWelcomeText();
        peopleView.printInputFileText();
        String filePath = peopleView.getFilePaths();
        try {
            processFileInput(filePath);
        }catch (FileNotFoundException e){
            System.err.println("File "+filePath+ " not found!");
            System.exit(1);
        }
        peopleView.printOptionsText();
        String option = peopleView.getOption();
        List<Person> result = processOption(option);
        peopleView.printResult(result);
        peopleView.close();
    }

    public void processFileInput(String filepath) throws FileNotFoundException {
        List<Person> personList = new CsvToBeanBuilder(new FileReader(filepath))
                .withType(Person.class).build().parse();

        for (int i=0; i<personList.size(); i++){
            personList.get(i).setPosition(i+1);
        }
        peopleModel.setPersonList(personList);
    }

    public List<Person> processOption(String option) {
        return switch (option) {
            case "1" -> peopleModel.filterByCompanyName("Esq");
            case "2" -> peopleModel.filterByCounty("Derbyshire");
            case "3" -> peopleModel.filterByHouseNum(3);
            case "4" -> peopleModel.filterByWebGreaterThanLength(35);
            case "5" -> peopleModel.filterByPostCodeDigits(1);
            case "6" -> peopleModel.filterByPhone1GreaterThanPhone2();
            default -> null;
        };
    }
}
