package pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.hetman.wiktoria.solvd.app.web.gui.components.Product;
import pl.hetman.wiktoria.solvd.app.web.gui.components.search.SearchFieldWeb;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.HomePageBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.MyAccountPageBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WhatsNewPageBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WomenPageBase;

import java.util.List;

public class WebTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(WebTest.class);


    @DataProvider(name = "accountData")
    public Object[][] createAccountData() {
        return new Object[][]{
                {"Jan", "Kowalski", "jan@kowalski11.com", "alfabet1@", "alfabet1@"},
        };
    }

    @DataProvider(name = "accountDataIncorrectPassword")
    public Object[][] createAccountDataIncorrectPassword() {
        return new Object[][]{
                {"Jan", "Kowalski", "jan@kowalski20.com", "alfabet1@", "alfabet1"},
        };
    }

    @DataProvider(name = "accountDataSignIn")
    public Object[][] signInData() {
        return new Object[][]{
                {"jan@kowalski.com", "alfabet1@"},
        };
    }

    @DataProvider(name = "accountInvalidDataSignIn")
    public Object[][] signInInvalidData() {
        return new Object[][]{
                {"a@a.uk", "aaa"},
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

        SearchFieldWeb searchField = homePage.getSearchField();
        searchField.typeSearchInputValue(input);
        SearchPage searchPage = searchField.clickSearchButton();

        Assert.assertTrue(webDriver.getCurrentUrl().contains(partialUrl), "The url doesn't contain the partialUrl");

        SoftAssert sa = new SoftAssert();

        List<Product> products = searchPage.getProducts();
        sa.assertFalse(products.size()==0, "is not 0");

        LOGGER.info("Product size: " + products.size());

        for (Product product : products) {
            LOGGER.info("product.getTitleText(): " + product.getTitleText());
            sa.assertTrue(product.getTitleText().toLowerCase().contains(input));
        }

        String currentUrl = searchPage.getCurrentUrl();
        LOGGER.info("curent URL " + currentUrl);
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

    @Test(testName = "CreateAccountTestIncorrectPassword", description = "Verify if CreateAccount is working correctly", dataProvider = "accountDataIncorrectPassword")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifyCreateAccountWithIncorrectPasswordTest(String firstName, String lastName, String email, String password, String confirmPassword) {

        WebDriver webDriver = new ChromeDriver();
        HomePage homePage = new HomePage(webDriver);

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        CreateAccountPage createAccountPage = homePage.getHeader().openCreateAccountPage();
        Assert.assertTrue(createAccountPage.isPageOpened(), "createAccountPage is not opened");

        MyAccountPageBase accountPage = createAccountPage.createAccount(firstName, lastName, email, password, confirmPassword);
        Assert.assertFalse(accountPage.isPageOpened(), "accountPage is open. Account created.");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(createAccountPage.getErrorField().isDisplayed(), "errorField is not displayed");
        sa.assertAll();
    }

    @Test(testName = "SignInTest", description = "Verify if SignIn is working correctly", dataProvider = "accountDataSignIn")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifySignInTest(String email, String password) {

        WebDriver webDriver = new ChromeDriver();
        HomePage homePage = new HomePage(webDriver);

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        SignInPage signInPage = homePage.getHeader().openSignInPage();
        Assert.assertTrue(signInPage.isPageOpened(), "signInPage is not opened");

        HomePage homePageAfterSigningIn = signInPage.signIn(email, password);
        Assert.assertTrue(homePageAfterSigningIn.isPageOpened(), "homePageAfterSiginingIn is not open");
    }

    @Test(testName = "SignInTestInvalidData", description = "Verify if SignIn is working correctly when the data is invalid", dataProvider = "accountInvalidDataSignIn")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifySignInWithInvalidDataTest(String email, String password) {

        WebDriver webDriver = new ChromeDriver();
        HomePage homePage = new HomePage(webDriver);

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        SignInPage signInPage = homePage.getHeader().openSignInPage();
        Assert.assertTrue(signInPage.isPageOpened(), "signInPage is not opened");

        HomePage homePageAfterSigningIn = signInPage.signIn(email, password);
        Assert.assertFalse(homePageAfterSigningIn.isPageOpened(), "homePageAfterSigningIn is open");
    }

    @Test(testName = "HomePageTest", description = "Verify if HomePage is containing search field")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifyHomePageTest() {

        WebDriver webDriver = new ChromeDriver();
        HomePage homePage = new HomePage(webDriver);

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        SoftAssert sa = new SoftAssert();
        String attribute = homePage.getSearchField().getSearchButton().getAttribute("type");
        sa.assertEquals(attribute, "submit", "attribute not present");
        sa.assertAll();
    }

    @Test(testName = "CreateAccountPageAttributeTest", description = "Verify if CreateAccountPage is containing attribute")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifyCreateAccountPageAttributeTest() {

        WebDriver webDriver = new ChromeDriver();
        HomePage homePage = new HomePage(webDriver);

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        CreateAccountPage createAccountPage = homePage.getHeader().openCreateAccountPage();
        Assert.assertTrue(createAccountPage.isPageOpened(), "createAccountPage is not opened");

        String attribute = createAccountPage.getCreateAccountButton().getAttribute("type");
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(attribute, "submit", "attribute is not present");
    }
}
