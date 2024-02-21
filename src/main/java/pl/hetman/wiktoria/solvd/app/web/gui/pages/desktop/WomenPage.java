package pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WomenPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = WomenPageBase.class)
public class WomenPage extends WomenPageBase {

    public WomenPage(WebDriver driver) {
        super(driver);
        setPageURL("women.html");
    }
}
