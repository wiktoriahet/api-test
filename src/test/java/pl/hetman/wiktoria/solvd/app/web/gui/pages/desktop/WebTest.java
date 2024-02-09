package pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.hetman.wiktoria.solvd.app.web.gui.components.Product;
import pl.hetman.wiktoria.solvd.app.web.gui.components.search.SearchFieldBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.HomePageBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.MyAccountPageBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WhatsNewPageBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WomenPageBase;

import java.util.List;

public class WebTest implements IAbstractTest {

    @DataProvider(name = "accountData")
    public Object[][] createAccountData() {
        return new Object[][]{
                {"Jan", "Kowalski", "jan@kowalski11.com", "alfabet1@", "alfabet1@"},
        };
    }

    @DataProvider(name = "accountDataSignIn")
    public Object[][] signInData() {
        return new Object[][]{
                {"jan@kowalski.com", "alfabet1@"},
        };
    }

    @Test(testName = "WhatsNewPageTest", description = "Verify if WhatsNewPage is opening correctly")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifyOpenWhatsNewPageTest() {

        WebDriver webDriver = new ChromeDriver();
        HomePageBase homePageBase = new HomePage(webDriver);

        homePageBase.open();
        Assert.assertTrue(homePageBase.isPageOpened(), "Home page is not opened!");

        WhatsNewPageBase whatsNewPageBase = homePageBase.getWidgetMenu().openWhatsNewPage();
        Assert.assertTrue(whatsNewPageBase.isPageOpened(), "whatsNewPageBase is not opened");
    }

    @Test(testName = "WomenPageTest", description = "Verify if WomanPage is opening correctly")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifyOpenWomanPageTest() {

        WebDriver webDriver = new ChromeDriver();
        HomePageBase homePageBase = new HomePage(webDriver);

        homePageBase.open();
        Assert.assertTrue(homePageBase.isPageOpened(), "Home page is not opened!");

        WomenPageBase womenPageBase = homePageBase.getWidgetMenu().openWomenPage();
        Assert.assertTrue(womenPageBase.isPageOpened(), "whatsNewPageBase is not opened");
    }

    @Test(testName = "SearchFieldTest", description = "Verify if SearchFieldTest is working correctly")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifySearchFieldTest() {

        WebDriver webDriver = new ChromeDriver();
        HomePage homePage = new HomePage(webDriver);

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        String input = "bra";
        String partialUrl = "catalogsearch";

        SearchFieldBase searchField = homePage.getSearchField();
        searchField.typeSearchInputValue(input);
        SearchPage searchPage = searchField.clickSearchButton();

        Assert.assertTrue(webDriver.getCurrentUrl().contains(partialUrl), "The url doesn't contain the partialUrl");

        SoftAssert sa = new SoftAssert();

        List<Product> products = searchPage.getProducts();

        for (Product product : products) {
            sa.assertTrue(product.getTitleText().toLowerCase().contains(input));
        }
        sa.assertAll();
    }

    @Test(testName = "CreateAccountTest", description = "Verify if CreateAccount is working correctly", dataProvider = "accountData")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifyCreateAccountTest(String firstName, String lastName, String email, String password, String confirmPassword) {

        WebDriver webDriver = new ChromeDriver();
        HomePage homePage = new HomePage(webDriver);

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        CreateAccountPage createAccountPage = homePage.getHeader().openCreateAccountPage();
        Assert.assertTrue(createAccountPage.isPageOpened(), "createAccountPage is not opened");

        MyAccountPageBase accountPage = createAccountPage.createAccount(firstName, lastName, email, password, confirmPassword);
        Assert.assertTrue(accountPage.isPageOpened(), "accountPage is not open. Account not created.");
    }

    @Test(testName = "SignInTest", description = "Verify if SignInTest is working correctly", dataProvider = "accountDataSignIn")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifySignInTest(String email, String password) {

        WebDriver webDriver = new ChromeDriver();
        HomePage homePage = new HomePage(webDriver);

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        SignInPage signInPage = homePage.getHeader().openSignInPage();
        Assert.assertTrue(signInPage.isPageOpened(), "signInPage is not opened");

        HomePage homePageAfterSiginingIn = signInPage.signIn(email, password);
        Assert.assertTrue(homePageAfterSiginingIn.isPageOpened(), "homePageAfterSiginingIn is not open");
    }
}
