package pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pl.hetman.wiktoria.solvd.app.web.gui.components.Product;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.SearchPageBase;

import java.util.List;

public class SearchPage extends SearchPageBase {
//.product.name.product-item-name
    //.product-item-link
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/div[2]/ol")
    private List<Product> products;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<Product> getProducts() {
        return products;
    }
}
