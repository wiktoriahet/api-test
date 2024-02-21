package pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.hetman.wiktoria.solvd.app.web.gui.components.header.Header;
import pl.hetman.wiktoria.solvd.app.web.gui.components.menu.MenuWidgetBase;
import pl.hetman.wiktoria.solvd.app.web.gui.components.menu.MenuWidgetWeb;
import pl.hetman.wiktoria.solvd.app.web.gui.components.search.SearchFieldWeb;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.HomePageBase;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@id=\"store.menu\"]")
    private MenuWidgetWeb widgetMenu;

    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[2]")
    private SearchFieldWeb searchFieldWeb;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div")
    private Header header;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MenuWidgetBase getWidgetMenu() {
        return widgetMenu;
    }

    @Override
    public SearchFieldWeb getSearchField() {
        return searchFieldWeb;
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }
}
