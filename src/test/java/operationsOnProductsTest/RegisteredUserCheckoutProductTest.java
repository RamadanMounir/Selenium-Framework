package operationsOnProductsTest;

import itemsDetails.ItemPage;
import itemsDetails.SearchPage;
import org.testng.Assert;
import shoppingCart.CheckoutPage;
import shoppingCart.OrderDetailsPage;
import shoppingCart.ShoppingCartPage;
import org.testng.annotations.Test;
import registration.LoginPage;
import registration.RegistrationResultsPage;
import registration.UserRegistrationPage;
import setUp.TestBase;

public class RegisteredUserCheckoutProductTest  extends TestBase {
   UserRegistrationPage userRegistrationPageObj;
   RegistrationResultsPage registrationResultsPageObj;
   LoginPage loginPageObj;
   SearchPage searchPageObj;
   ItemPage itemPageObj;
   ShoppingCartPage shoppingCartPageObj;
   CheckoutPage checkoutPageObj;
   OrderDetailsPage orderDetailsPageObj;
    String firstName = "Ramadan",lastName = "Mazaly",
            email = "r5kln20@gmddrfdfail.com",password = "Ramadan123";
    String itemName = "Apple MacBook Pro 13-inch";
    String CountryName ="Egypt" , CityName = "Giza", Address = "6October",zipPostalCodeNumber = "1234",PhoneNumber = "012345678910";
    @Test(priority = 0)
    public void testCheckoutProductAsRegisteredUserSuccessfully(){
        //1- user registration
        userRegistrationPageObj = homePageObj.openRegistrationPage();
        registrationResultsPageObj= userRegistrationPageObj.userRegistration(firstName,lastName,email,password);
        homePageObj=registrationResultsPageObj.clickContinue();
        //2- user login
        loginPageObj = homePageObj.openLoginPage();
        homePageObj=loginPageObj.login(email,password);
        //3- user search about item
        searchPageObj = homePageObj.searchFor(itemName);
        // will redirect me to item page not will add to cart
        itemPageObj = searchPageObj.addToCart();
        itemPageObj.addToCart();
        //4- open shopping cart page
        shoppingCartPageObj= itemPageObj.openCartPage();
        //5- confirm to check out
        shoppingCartPageObj.clickConditionCheckboxBtn();
        checkoutPageObj = shoppingCartPageObj.clickCheckoutBtn();
        //6- fill data to continue  check out
        checkoutPageObj.fillBillingAddress(CountryName,CityName,Address,zipPostalCodeNumber,PhoneNumber);
        checkoutPageObj.chooseShippingAddress();
        checkoutPageObj.choosePaymentMethod();
        checkoutPageObj.clickContinueInformationBtn();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        checkoutPageObj.confirmOrder();
        // 7- check if the order successfully completed
        String completedMessage = checkoutPageObj.getCompletedOrderMessage();
        Assert.assertTrue(completedMessage.contains("Your order has been successfully processed!")
                ,"your order failed");
        orderDetailsPageObj = checkoutPageObj.openOrderDetailsPage();
        orderDetailsPageObj.downloadPDFInvoice();
        orderDetailsPageObj.clickPrintBtn();
    }
    @Test(priority = 1)
    public void userLogoutSuccessfully(){
        homePageObj.logout();
    }


}
