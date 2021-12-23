package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPage extends AbstractObjectPage {

    @FindBy(linkText = "MP3 Players")
    private WebElement buttonMp3Players;

    @FindBy(partialLinkText = "Show All MP3 Players")
    private WebElement buttonShowAllMp3Players;

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonMp3Players() {
        buttonMp3Players.click();
    }

    public void clickButtonShowAllMp3Players() {
        buttonShowAllMp3Players.click();
    }

}



//

//    public void openCart() {
//        if (! listItemsInCart.isDisplayed()) {
//            buttonCart.click();
//            WaitUtils.waitForJS(driver);
//        }
//    }

//

