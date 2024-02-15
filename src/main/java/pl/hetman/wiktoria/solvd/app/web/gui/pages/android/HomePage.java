package pl.hetman.wiktoria.solvd.app.web.gui.pages.android;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.hetman.wiktoria.solvd.app.utils.MobileContextUtils;
import pl.hetman.wiktoria.solvd.app.web.gui.components.web.header.Header;
import pl.hetman.wiktoria.solvd.app.web.gui.components.web.header.HeaderBase;
import pl.hetman.wiktoria.solvd.app.web.gui.components.web.menu.MenuWidgetAndroid;
import pl.hetman.wiktoria.solvd.app.web.gui.components.web.search.SearchFieldAndroid;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.HomePageBase;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    //@FindBy(className = "action nav-toggle")
    @FindBy(xpath = "/html/body/div[2]/header/div[2]/span")
    private ExtendedWebElement widgetMenuButton;

    @FindBy(id = "store.menu")
    private MenuWidgetAndroid menuWidget;

    @FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[1]/label")
    private ExtendedWebElement searchFieldButton;
    //*[@id="search"]
    @FindBy(xpath = "//*[@id=\"search\"]")
    private SearchFieldAndroid searchField;

    //@FindBy(xpath = "/html/body/div[2]/header")
    //@FindBy(css = "page-header")
    private Header header;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL("https://magento.softwaretestingboard.com/");
        MobileContextUtils contextUtils = new MobileContextUtils();
        contextUtils.switchMobileContext(MobileContextUtils.View.CHROMIUM);
    }

    public void clickWidgetButton(){
        widgetMenuButton.click();
    }

    public void clickSearchButton(){
        searchFieldButton.click();
    }

    @Override
    public MenuWidgetAndroid getWidgetMenu() {
        return menuWidget;
    }

    @Override
    public SearchFieldAndroid getSearchField() {
        clickSearchButton();
        return searchField;
    }

    @Override
    public HeaderBase getHeader() {
        return null;
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }
}
