package pl.hetman.wiktoria.solvd.app.api.author;

import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.hetman.wiktoria.solvd.app.web.api.author.GetAuthorById;

public class GetAuthorByIdTest implements IAbstractTest {

    @DataProvider(name = "GetAuthorByIdValidData")
    public Object[][] createAuthorIdValidData() {
        return new Object[][]{
                {1},
                {2},
                {99}
        };
    }

    @DataProvider(name = "GetAuthorByIdInvalidData")
    public Object[][] createAuthorIdInvalidData() {
        return new Object[][]{
                {-10},
                {-99},
                {-3}
        };
    }

    @Test(testName = "GET1", description = "Validate GetAuthorById with valid id", dataProvider = "GetAuthorByIdValidData")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P0)
    public void verifyGetAuthorByIdWithValidDataTest(Integer id) {
        //given
        GetAuthorById getAuthorById = new GetAuthorById(id);

        //when

        //then
        getAuthorById.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAuthorById.callAPI();
        getAuthorById.validateResponse();

    }

    @Test(testName = "GET2", description = "Validate GetAuthorById with invalid id", dataProvider = "GetAuthorByIdInvalidData")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P0)
    public void verifyGetAuthorByIdWithInvalidDataTest(Integer id) {
        //given
        GetAuthorById getAuthorById = new GetAuthorById(id);

        //when

        //then
        getAuthorById.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
    }

}