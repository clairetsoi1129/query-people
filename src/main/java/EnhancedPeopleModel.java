import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EnhancedPeopleModel extends PeopleModel{
    // Q1. What if your program has to load from a different CSV file, or combine multiple CSV files.
    // A1-1. To process more than 1 files, need to update the personList to empty and allow controller to add the personList
    public EnhancedPeopleModel(){
        personList = new ArrayList<>();
    }

    public void addPersonList(List<Person> pList){
        personList.addAll(pList);
    }

    // Q3. How might you add new queries?
    // A3-1. Add a filterByXXX method here
    public List<Person> filterByFirstName(String firstName){
        return personList.stream()
                .filter(p->p.getFirstName().equalsIgnoreCase(firstName))
                .collect(Collectors.toList());
    }

}
