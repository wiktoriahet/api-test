package pl.hetman.wiktoria.solvd.app.web.gui.components.web.header;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop.CreateAccountPage;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop.SignInPage;

public class Header extends HeaderBase {

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a")
    private ExtendedWebElement createAccountLink;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]")
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
