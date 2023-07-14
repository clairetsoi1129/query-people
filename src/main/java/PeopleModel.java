import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class PeopleModel {
    protected List<Person> personList;

    public List<Person> filterByName(String firstName, String lastName){
        return personList.stream()
                .filter(p->p.getFirstName().equalsIgnoreCase(firstName))
                .filter(p->p.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    public List<Person> filterByCounty(String text){
        return personList.stream()
                .filter(p->p.getCounty().equalsIgnoreCase(text))
                .collect(Collectors.toList());
    }

    public List<Person> filterByCompanyName(String text){
        return personList.stream()
                .filter(p->p.getCompanyName().contains(text))
                .collect(Collectors.toList());
    }

    public List<Person> filterByHouseNum(int numOfDigit){
        return personList.stream()
                .filter(p->(p.getAddress().substring(0, p.getAddress().indexOf(" ")).length()==numOfDigit))
                .collect(Collectors.toList());
    }

    public List<Person> filterByWebGreaterThanLength(int length){
        return personList.stream()
                .filter(p->(p.getWeb().length()>length))
                .collect(Collectors.toList());
    }

    public List<Person> filterByPhone1GreaterThanPhone2(){
        return personList.stream()
                .filter(p->parsePhoneNumber(p.getPhone1())>parsePhoneNumber(p.getPhone2()))
                .collect(Collectors.toList());
    }

    public List<Person> filterByPostCodeDigits(int numOfDigit){
        return personList.stream()
                .filter(p->parseFirstPortionPostalDigit(p.getPostal()).length() == numOfDigit)
                .collect(Collectors.toList());
    }

    protected long parsePhoneNumber(String phoneNumber){
        return Long.parseLong(phoneNumber.replaceAll("\\D", ""));
    }

    protected String parseFirstPortionPostalDigit(String postCode){
        String firstPortion = postCode.substring(0, postCode.indexOf(" "));
        return firstPortion.replaceAll("[a-zA-Z]", "");
    }

}
