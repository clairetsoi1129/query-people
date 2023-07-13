import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class PeopleController {
    public List<Person> processFileInput() throws FileNotFoundException {
        List<Person> personList = new CsvToBeanBuilder(new FileReader("testfile/input.csv"))
                .withType(Person.class).build().parse();
        return personList;
    }
}
