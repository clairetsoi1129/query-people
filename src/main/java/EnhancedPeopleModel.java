import java.util.List;
import java.util.stream.Collectors;

public class EnhancedPeopleModel extends PeopleModel {
    // Q3. How might you add new queries?
    // A3-1. Add a filterByXXX method here
    public List<Person> filterByFirstName(String firstName){
        return personList.stream()
                .filter(p->p.getFirstName().equalsIgnoreCase(firstName))
                .collect(Collectors.toList());
    }

}
