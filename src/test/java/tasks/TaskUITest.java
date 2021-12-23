package tasks;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.ProductPage;
import utils.WaitUtils;
import static org.testng.Assert.assertTrue;

public class TaskUITest extends BaseTest {

    private CommonPage commonPage;
    private ProductPage productPage;
    String partOfExpectedWishListMessage = " You must ";

    @Test
       //     (dataProvider = "parameters")
    public void testOpenCart() {
        commonPage = new CommonPage(driver);
        productPage = new ProductPage(driver);


        commonPage.clickButtonMp3Players();
        commonPage.clickButtonShowAllMp3Players();
        productPage.clickShowProductsInList();

        productPage.selectIpodClassic();


       // productPage.selectIpodClassic();
        productPage.clickButtonWishList();


        String wishListMessage = driver.findElement(By.xpath("//*[@class='fa fa-check-circle']")).getText();

        //assertTrue(driver.findElement(wishListMessage.contains(partOfExpectedWishListMessage)), "Error message is not correct";

        driver.navigate().refresh();


        //productPage.clickButtonCart();
    }




//    @DataProvider
//    public Object[][] parameters() {
//        return new Object[][]{
//                {"iPod Classic"},
//                {"iPod Nano"},
//                {"iPod Touch"},
//                {"My Player"},
//        };
//    }
}
