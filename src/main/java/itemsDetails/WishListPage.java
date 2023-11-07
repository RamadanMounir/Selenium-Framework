package itemsDetails;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage extends PageBase {
    public WishListPage(WebDriver driver) {
        super(driver);
    }
    By wishListProductName = By.xpath("//a[@class='product-name']");
    By selectItem = By.xpath("//input[@name='addtocart']");
    By removeItemBtn = By.xpath("//button[@class='remove-btn']");
    By wishListMessage = By.xpath("//div[@class='no-data']");
    public String getWishListProductItemName(){
        return driver.findElement(wishListProductName)
                .getText();
    }
    public void removeItemFromWishList(){
        click(selectItem);
        click(removeItemBtn);
    }
    public String wishListIsEmptyMessage(){
        return driver.findElement(wishListMessage)
                .getText();
    }

}
