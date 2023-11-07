package shoppingCart;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends PageBase {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    By shoppingCartTitle = By.xpath("//h1[normalize-space()='Shopping cart']");
    By item = By.xpath("//a[@class='product-name']");
    By agreeConditionCheckboxBtn = By.id("termsofservice");
    By checkoutBtn = By.id("checkout");
    public String getShoppingCartTitle(){
        return driver.findElement(shoppingCartTitle)
                .getText();
    }
    public String getItemName(){
        return driver.findElement(item)
                .getText();
    }
    public void clickConditionCheckboxBtn(){
        click(agreeConditionCheckboxBtn);
    }
    public CheckoutPage clickCheckoutBtn(){
        click(checkoutBtn);
        return new CheckoutPage(driver);

    }

}
