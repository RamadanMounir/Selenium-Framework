package workingWithDDT;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import registration.*;
import setUp.TestBase;

public class UserRegistrationTestWithDDTUsingJavaFaker extends TestBase {
    UserRegistrationPage userReg;
    RegistrationResultsPage registrationResultsPageObj;
    LoginPage loginPageObj;
    MyAccountPage myAccountPageObj;
    ChangePasswordPage changePasswordPageObj;

    Faker faker = new Faker();
    public  String firstName = faker.name().firstName(), lastName =faker.name().lastName(),
    email = faker.internet().emailAddress(), password = faker.number().digits(8),
            newPassword = faker.number().digits(8);

    @Test()
    public void testSuccessfulRegistrationTest() {

        //1- user register
        userReg=homePageObj.openRegistrationPage();
        registrationResultsPageObj =
                userReg.userRegistration(firstName,lastName,email,password);
        Assert.assertTrue(registrationResultsPageObj
                .getMessageResult()
                .contains("Your registration completed"),"not correct message");
        homePageObj=registrationResultsPageObj.clickContinue();
        //2- user login
        loginPageObj = homePageObj.openLoginPage();
        homePageObj=loginPageObj.login(email,password);
        Assert.assertTrue(homePageObj.checkLogOutLinkVisibility().contains("Log out"),"not on home page");
        //3- user open My Account page
        myAccountPageObj= homePageObj.openMyAccountLink();
        changePasswordPageObj =  myAccountPageObj.openChangePasswordLink();
        //4-user change his password
        changePasswordPageObj.changePassword(password,newPassword);
        changePasswordPageObj.closeAlert();
        //5- user logout
        homePageObj = changePasswordPageObj.logout();
        //6- user loin with new password
        loginPageObj = homePageObj.openLoginPage();
        homePageObj = loginPageObj.login(email,newPassword);
        Assert.assertTrue(homePageObj.checkLogOutLinkVisibility().contains("Log out"),"not on home page");
        //7- user logout
        homePageObj.logout();
        System.out.println("firstname :"+firstName+"\nlastname :"+lastName+"\nemail :"+email
                          +"\npassword :"+password+"\nnewPassword :"+newPassword);
    }
}
