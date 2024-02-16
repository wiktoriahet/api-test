package pl.hetman.wiktoria.solvd.app.web.gui.components.search;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.SearchPageBase;

public abstract class SearchFieldBase extends AbstractUIObject {

    public SearchFieldBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract ExtendedWebElement getSearchButton();
    public abstract void typeSearchInputValue(String value);
    public abstract SearchPageBase clickSearchButton();
}
