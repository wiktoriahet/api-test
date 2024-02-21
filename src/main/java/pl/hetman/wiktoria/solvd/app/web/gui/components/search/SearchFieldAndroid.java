package pl.hetman.wiktoria.solvd.app.web.gui.components.search;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pl.hetman.wiktoria.solvd.app.utils.MobileContextUtils;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.android.SearchPage;

public class SearchFieldAndroid extends SearchFieldBase implements IMobileUtils {

    @FindBy(xpath = "//div/input[@id=\"search\"]")
    private ExtendedWebElement searchInput;

    public SearchFieldAndroid(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeSearchInputValue(String value) {
        searchInput.type(value);
    }

    public SearchPage clickSearchButton() {
        MobileContextUtils contextUtils = new MobileContextUtils();
        contextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        tap(1000, 2000);
        contextUtils.switchMobileContext(MobileContextUtils.View.CHROMIUM);
        return new SearchPage(getDriver());
    }

    public ExtendedWebElement getSearchButton() {
        return null;
    }
}
