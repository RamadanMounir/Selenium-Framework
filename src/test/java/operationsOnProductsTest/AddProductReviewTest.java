package operationsOnProductsTest;

import itemsDetails.ItemPage;
import itemsDetails.ProductReviewsPage;
import itemsDetails.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import registration.LoginPage;
import registration.RegistrationResultsPage;
import registration.UserRegistrationPage;
import setUp.TestBase;

public class AddProductReviewTest extends TestBase {

    UserRegistrationPage userRegistrationPageObj;
    RegistrationResultsPage registrationResultsPageObj;
    LoginPage loginPageObj;
    SearchPage searchPageObj;
    ItemPage itemPageObj;
    ProductReviewsPage productReviewsPageObj;
    String firstName = "Ramadan",lastName = "Mazaly",
            email = "r1kl12@gmcdfdkail.com",password = "Ramadan123";
    String itemName = "Apple MacBook Pro 13-inch";
    @Test(priority = 0)
    public void testAddProductReviewSuccessful(){
        //1- user registration
        userRegistrationPageObj = homePageObj.openRegistrationPage();
        registrationResultsPageObj= userRegistrationPageObj.userRegistration(firstName,lastName,email,password);
        Assert.assertTrue(registrationResultsPageObj
                .getMessageResult()
                .contains("Your registration completed"),"not correct message");
        homePageObj=registrationResultsPageObj.clickContinue();
        //2- user login
        loginPageObj = homePageObj.openLoginPage();
        homePageObj=loginPageObj.login(email,password);
        //3- user search about item
        searchPageObj = homePageObj.searchFor(itemName);
        // will redirect me to item page not will add to cart
        itemPageObj = searchPageObj.addToCart();
        //4-open review page
        productReviewsPageObj = itemPageObj.addProductToReview();
        //5- add your review
        productReviewsPageObj.addReview("battery life","good time for battery life");
        String reviewResult = productReviewsPageObj.getReviewResult();
        //6- check if yor review was added successfully
        Assert.assertTrue(reviewResult.contains("Product review is successfully added."),"review not added");
    }
    @Test(priority = 1)
    public void userLogoutSuccessfully(){
        homePageObj.logout();
    }
}
