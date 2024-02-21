package pl.hetman.wiktoria.solvd.app.web.gui.components.header;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop.CreateAccountPage;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop.SignInPage;

public class Header extends HeaderBase {

    @FindBy(xpath = "(//li/a[@href=\"https://magento.softwaretestingboard.com/customer/account/create/\"])[1]")
    private ExtendedWebElement createAccountLink;

    @FindBy(xpath = "(//ul/li[@class=\"authorization-link\"])[1]")
    private ExtendedWebElement signInLink;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public CreateAccountPage openCreateAccountPage() {
        createAccountLink.click();
        return new CreateAccountPage(driver);
    }

    @Override
    public SignInPage openSignInPage() {
        signInLink.click();
        return new SignInPage(driver);
    }
}
