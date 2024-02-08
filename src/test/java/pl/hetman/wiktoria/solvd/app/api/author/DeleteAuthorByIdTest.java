package pl.hetman.wiktoria.solvd.app.api.author;

import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeleteAuthorByIdTest implements IAbstractTest {

    @DataProvider(name = "DeleteAuthorByIdWithValidData")
    public Object[][] createAuthorValidData() {
        return new Object[][]{
                {1},
                {4},
                {98}

        };
    }

    @DataProvider(name = "DeleteAuthorByIdInvalidData")
    public Object[][] createAuthorInvalidData() {
        return new Object[][]{
                {-10},
                {-99},
                {-199}
        };
    }

    @Test(testName = "DELETE1", description = "Validate DeleteAuthorById with valid data", dataProvider = "DeleteAuthorByIdWithValidData")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P0)
    public void verifyDeleteAuthorByIdWithValidDataTest(Integer id) {

        DeleteAuthorById deleteAuthorById = new DeleteAuthorById(id);

        deleteAuthorById.setProperties("author.properties");
        deleteAuthorById.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteAuthorById.callAPI();

    }

    @Test(testName = "DELETE2", description = "Validate DeleteAuthorById with invalid data", dataProvider = "DeleteAuthorByIdInvalidData")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P0)
    public void verifyDeleteAuthorByIdWithInvalidDataTest(Integer id) {

        DeleteAuthorById deleteAuthorById = new DeleteAuthorById(id);

        deleteAuthorById.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
    }


}