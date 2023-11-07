package extraPage;

import extraPagesForHelpUs.EmailFriendPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import registration.LoginPage;
import registration.RegistrationResultsPage;
import registration.UserRegistrationPage;
import itemsDetails.ItemPage;
import itemsDetails.SearchPage;
import setUp.TestBase;

public class EmailFriendTest extends TestBase {
    UserRegistrationPage userRegistrationPageObj;
    RegistrationResultsPage  registrationResultsPageObj;
    LoginPage loginPageObj;
    SearchPage searchPageObj;
    ItemPage itemPageObj;
    EmailFriendPage emailFriendPageObj;

    String firstName = "Ramadan",lastName = "Mazaly",
            email = "r1kjb12@gmaukhfsil.com",password = "Ramadan123";
    String friendEmail = "rtdtf@gmail.com",
            Message ="i recommend this item for you bro" ;
    String itemName = "Apple MacBook Pro 13-inch";
    @Test(priority = 0)
    public void testEmailFriendSuccessful(){
        //1- user register successfully
        userRegistrationPageObj = homePageObj.openRegistrationPage();
        registrationResultsPageObj= userRegistrationPageObj.userRegistration(firstName,lastName,email,password);
        Assert.assertTrue(registrationResultsPageObj
                .getMessageResult()
                .contains("Your registration completed"),"not correct message");
        homePageObj=registrationResultsPageObj.clickContinue();
        //2- user login
        loginPageObj = homePageObj.openLoginPage();
        homePageObj=loginPageObj.login(email,password);
        //3- user search about product
        searchPageObj = homePageObj.searchFor(itemName);
        // will redirect me to item page not will add to cart
        itemPageObj = searchPageObj.addToCart();
        //4- open email friend page
        emailFriendPageObj = itemPageObj.emailFriend();
        //5- add your message to your friend
        emailFriendPageObj.sendEmailFriendMessage(friendEmail,Message);
        String result =emailFriendPageObj.getMessageResult();
        // 6- check if your message was sent to your friend successfully
        Assert.assertTrue(result.contains("Your message has been sent"),"message not sent to your friend");

    }
    @Test(priority = 1)
    public void userLogoutSuccessfully(){
        homePageObj.logout();
    }
}
