package pl.hetman.wiktoria.solvd.app.api.author;

import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.hetman.wiktoria.solvd.app.domain.Author;

public class PostAuthorTest implements IAbstractTest {

    @DataProvider(name = "PostAuthorWithValidData")
    public Object[][] createAuthorValidData() {
        return new Object[][]{
                {1, 2, "Anna", "Nowak"},
                {4, 54, "Jan", "Kowalski"},
                {98, 1, "Robert", "Jankowski"}

        };
    }

    @DataProvider(name = "PostAuthorWithInvalidData")
    public Object[][] createAuthorInvalidData() {
        return new Object[][]{
                {-10, -99, "firstName", "lastName"},
                {-99, -0, "firstName", "lastName"},
                {-3, -432, "firstName", "lastName"}
        };
    }

    @Test(testName = "POST1", description = "Validate PostAuthor with valid data", dataProvider = "PostAuthorWithValidData")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P0)
    public void verifyPostAuthorWithValidDataTest(Integer id, Integer bookId, String firstName, String lastName) {
        //given
        PostAuthor postAuthor = new PostAuthor();
        Author author = new Author();
        author.setId(id);
        author.setIdBook(bookId);
        author.setFirstName(firstName);
        author.setLastName(lastName);

        //when

        //then
        postAuthor.setProperties("author.properties");
        postAuthor.expectResponseStatus(HttpResponseStatusType.OK_200);
        postAuthor.addProperty("Author", author);
        postAuthor.callAPI();
        postAuthor.validateResponse();

    }

    @Test(testName = "POST2", description = "Validate PostAuthor with invalid data", dataProvider = "PostAuthorWithInvalidData")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P0)
    public void verifyPostAuthorWithInvalidDataTest(Integer id, Integer bookId, String firstName, String lastName) {
        //given
        PostAuthor postAuthor = new PostAuthor();
        Author author = new Author();
        author.setId(id);
        author.setIdBook(bookId);
        author.setFirstName(firstName);
        author.setLastName(lastName);

        //when

        //then
        postAuthor.addProperty("Author", author);
        postAuthor.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
    }

}