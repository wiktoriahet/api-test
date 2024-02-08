package pl.hetman.wiktoria.solvd.app.api.author;

import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.hetman.wiktoria.solvd.app.domain.Author;
import pl.hetman.wiktoria.solvd.app.web.api.author.PutAuthorById;

public class PutAuthorByIdTest implements IAbstractTest {

    @DataProvider(name = "PutAuthorWithValidData")
    public Object[][] createAuthorValidData() {
        return new Object[][]{
                {1, 2, "Anna", "Nowak"},
                {4, 54, "Jan", "Kowalski"},
                {98, 1, "Robert", "Jankowski"}

        };
    }

    @DataProvider(name = "PutAuthorWithInvalidData")
    public Object[][] createAuthorInvalidData() {
        return new Object[][]{
                {-10, -99, "firstName", "lastName"},
                {-99, -0, "firstName", "lastName"},
                {1, -432, "firstName", "lastName"}
        };
    }


    @Test(testName = "PUT1", description = "Validate PutAuthor with valid data", dataProvider = "PutAuthorWithValidData")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P0)
    public void verifyPutAuthorByIdWithValidDataTest(Integer id, Integer bookId, String firstName, String lastName) {
        //given
        PutAuthorById putAuthorById = new PutAuthorById(id);
        Author author = new Author();
        author.setId(id);
        author.setIdBook(bookId);
        author.setFirstName(firstName);
        author.setLastName(lastName);

        //when

        //then
        putAuthorById.setProperties("author.properties");
        putAuthorById.addProperty("Author", author);
        putAuthorById.expectResponseStatus(HttpResponseStatusType.OK_200);
        putAuthorById.callAPI();
        putAuthorById.validateResponse();
    }

    @Test(testName = "PUT2", description = "Validate PutAuthor with invalid data", dataProvider = "PutAuthorWithInvalidData")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P0)
    public void verifyPutAuthorByIdWithInvalidDataTest(Integer id, Integer bookId, String firstName, String lastName) {
        //given
        PutAuthorById putAuthorById = new PutAuthorById(id);
        Author author = new Author();
        author.setId(id);
        author.setIdBook(bookId);
        author.setFirstName(firstName);
        author.setLastName(lastName);

        //when

        //then
        putAuthorById.addProperty("Author", author);
        putAuthorById.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
    }
}