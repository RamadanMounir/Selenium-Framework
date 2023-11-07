package itemsDetails;

import base.PageBase;
import extraPagesForHelpUs.EmailFriendPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import shoppingCart.ShoppingCartPage;

public class ItemPage extends PageBase {
    public ItemPage(WebDriver driver) {
        super(driver);
    }

    By addToCartBtn = By.xpath("//button[@id='add-to-cart-button-4']");
    By emailFriendBtn =By.xpath("//button[@class='button-2 email-a-friend-button']");
    By currencyValue = By.id("price-value-4");
    By addYourReviewLink = By.linkText("Add your review");
    By addToWishListBtn = By.id("add-to-wishlist-button-4");
    By wishListPageLink = By.xpath("//a[normalize-space()='wishlist']");
    By shoppingCartPageLink = By.xpath("//a[normalize-space()='shopping cart']");
    public void addToCart(){
        click(addToCartBtn);
    }
    public ShoppingCartPage openCartPage(){
        waitAndClick(shoppingCartPageLink);
        return new ShoppingCartPage(driver);
    }
    public EmailFriendPage emailFriend(){
        click(emailFriendBtn);
        return new EmailFriendPage(driver);
    }
    public void addToWishList(){
        click(addToWishListBtn);
    }
    public WishListPage openWishListPage(){
        waitAndClick(wishListPageLink);
        return new WishListPage(driver);
    }
    public ProductReviewsPage addProductToReview(){
        click(addYourReviewLink);
        return new ProductReviewsPage(driver);
    }


    public String checkCurrency(){
        return driver.findElement(currencyValue).getText();
    }
}
