package pl.hetman.wiktoria.solvd.app.web.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import pl.hetman.wiktoria.solvd.app.web.gui.components.menu.MenuWidgetBase;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract MenuWidgetBase getHeaderMenu();

    @Override
    public void open(){
        super.open();
    }
}
