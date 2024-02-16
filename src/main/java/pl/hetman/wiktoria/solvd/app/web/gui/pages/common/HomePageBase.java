package pl.hetman.wiktoria.solvd.app.web.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import pl.hetman.wiktoria.solvd.app.web.gui.components.header.HeaderBase;
import pl.hetman.wiktoria.solvd.app.web.gui.components.menu.MenuWidgetBase;
import pl.hetman.wiktoria.solvd.app.web.gui.components.search.SearchFieldBase;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract MenuWidgetBase getWidgetMenu();

    public abstract SearchFieldBase getSearchField();

    public abstract HeaderBase getHeader();

    @Override
    public void open(){
        super.open();
    }
}
