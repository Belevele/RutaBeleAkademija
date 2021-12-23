package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;

public class ProductPage extends CommonPage {


    // buttons
    @FindBy(id = "list-view")
    private WebElement buttonListView;

    @FindBy(xpath = "//*[@class='fa fa-heart']")
    private WebElement buttonWishList;

    @FindBy(id = "button-cart")
    private WebElement buttonCart;

    // others
    @FindBy(xpath = "//img[@title='iPod Classic']")
    private WebElement ipodClassic;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickShowProductsInList() {
        buttonListView.click();
    }

    public void selectIpodClassic() {
        ipodClassic.click();
    }

    public void clickButtonWishList() {
        buttonWishList.click();
        //WaitUtils.waitForJS(driver);
    }

    public void clickButtonCart() {
        buttonCart.click();
    }

}
