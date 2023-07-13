import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class Person {
    @CsvBindByName
    private String first_name;
    @CsvBindByName
    private String last_name;
    @CsvBindByName
    private String company_name;
    @CsvBindByName
    private String address;
    @CsvBindByName
    private String city;
    @CsvBindByName
    private String country;
    @CsvBindByName
    private String postal;
    @CsvBindByName
    private String phone1;
    @CsvBindByName
    private String phone2;
    @CsvBindByName
    private String email;
    @CsvBindByName
    private String web;
}
