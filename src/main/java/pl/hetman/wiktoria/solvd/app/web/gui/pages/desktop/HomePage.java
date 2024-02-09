package pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop;

import com.zebrunner.carina.utils.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.hetman.wiktoria.solvd.app.web.gui.components.menu.MenuWidget;
import pl.hetman.wiktoria.solvd.app.web.gui.components.menu.MenuWidgetBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.HomePageBase;

import java.lang.invoke.MethodHandles;

public class HomePage extends HomePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@id=\"store.menu\"]")
    private MenuWidget headerMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MenuWidgetBase getHeaderMenu() {
        return headerMenu;
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }
}
