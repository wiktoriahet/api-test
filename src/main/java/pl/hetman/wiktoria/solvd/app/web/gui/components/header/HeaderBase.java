package pl.hetman.wiktoria.solvd.app.web.gui.components.header;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop.CreateAccountPage;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop.SignInPage;

public abstract class HeaderBase extends AbstractUIObject {

    public HeaderBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract CreateAccountPage openCreateAccountPage();

    public abstract SignInPage openSignInPage();
}
