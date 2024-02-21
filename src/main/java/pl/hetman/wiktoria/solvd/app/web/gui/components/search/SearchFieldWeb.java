package pl.hetman.wiktoria.solvd.app.web.gui.components.search;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop.SearchPage;

public class SearchFieldWeb extends SearchFieldBase {

    @FindBy(xpath = "//form[@id='search_mini_form']//button[@type='submit']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//input[@id=\"search\"]")
    private ExtendedWebElement searchInput;

    public SearchFieldWeb(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public void typeSearchInputValue(String value) {
        searchInput.type(value);
    }

    public SearchPage clickSearchButton(){
        searchButton.click();
        return new SearchPage(getDriver());
    }
}
