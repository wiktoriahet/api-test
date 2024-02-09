package pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pl.hetman.wiktoria.solvd.app.web.gui.components.Product;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.SearchPageBase;

import java.util.List;

public class SearchPage extends SearchPageBase {

    @FindBy(css = ".product-items li")
    private List<Product> products;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<Product> getProducts() {
        return products;
    }
}
