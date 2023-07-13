import org.junit.jupiter.api.Test;

import javax.validation.ValidationException;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPeopleController {
    @Test
    void processFileInput()  throws ValidationException, FileNotFoundException {
        PeopleController controller = new PeopleController();
        assertEquals(500, controller.processFileInput().size());
    }
}
