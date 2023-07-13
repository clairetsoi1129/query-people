import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ValidationException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestPeopleController {
    private PeopleModel mockModel;
    private PeopleView view;
    private PeopleController controller;
    @BeforeEach
    public void setUp() {
        mockModel = mock(PeopleModel.class);
        view = new PeopleView();
        controller = new PeopleController(mockModel, view);
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "Aleshia","Tomkiewicz",
                "Alan D Rosenburg Cpa Pc","14 Taylor St","St. Stephens Ward","Derbyshire","CT2 7PP",
                "02035-703597","01944-369967","atomkiewicz@hotmail.com","http://www.alandrosenburgcpapc.co.uk"));
        personList.add(new Person(2, "Aleshia","Tomkiewicz",
                "Alan D Rosenburg Cpa Esq","144 Taylor St","St. Stephens Ward","Kent","CT22 7PP",
                "01835-703597","01944-369967","atomkiewicz@hotmail.com","http://www.alandrosenburgcpap.co.uk"));

        List<Person> filteredPersonList = new ArrayList<>();
        filteredPersonList.add(new Person(2, "Aleshia","Tomkiewicz",
                "Alan D Rosenburg Cpa Esq","144 Taylor St","St. Stephens Ward","Kent","CT22 7PP",
                "01835-703597","01944-369967","atomkiewicz@hotmail.com","http://www.alandrosenburgcpap.co.uk"));

        lenient().when(mockModel.getPersonList()).thenReturn(personList);
        lenient().when(mockModel.filterByCompanyName("Esq")).thenReturn(filteredPersonList);
    }

    @AfterEach
    public void tearDown() {

    }
    @Test
    void processFileInputSuccess()  throws ValidationException, FileNotFoundException {
        String filePath = "testfile/input.csv";
        controller.processFileInput(filePath);
        assertEquals(2, mockModel.getPersonList().size());
    }

    @Test
    void processFileInputFail()  throws ValidationException {
        assertThrows(FileNotFoundException.class, () -> {
            String filePath = "testfile/dummy.csv";
            controller.processFileInput(filePath);
        });
    }

    @Test
    void processOptionSuccess()  throws ValidationException {
        List<Person> result = controller.processOption("1");
        assertEquals(1, result.size());
    }

    @Test
    void processOptionFail()  throws ValidationException {
        List<Person> result = controller.processOption("8");
        assertNull(result);
    }
}
