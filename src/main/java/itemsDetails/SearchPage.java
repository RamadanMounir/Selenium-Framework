package itemsDetails;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends PageBase {
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    By productTitle = By.cssSelector("h2[class='product-title'] a");
    By addToCartBtn = By.xpath("//button[normalize-space()='Add to cart']");
    public String getSearchPageTitle(){
        return driver.findElement(productTitle).getText();
    }
    public ItemPage addToCart(){
        click(addToCartBtn);
        return new ItemPage(driver);
    }


}
