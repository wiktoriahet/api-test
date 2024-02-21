package pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WhatsNewPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = WhatsNewPageBase.class)
public class WhatsNewPage extends WhatsNewPageBase {

    public WhatsNewPage(WebDriver driver) {
        super(driver);
        setPageURL("what-is-new.html");
    }

}
