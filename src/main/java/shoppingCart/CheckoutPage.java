package shoppingCart;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    By countries = By.id("BillingNewAddress_CountryId");
    By city = By.id("BillingNewAddress_City");
    By address1 = By.id("BillingNewAddress_Address1");
    By zipPostalCode = By.id("BillingNewAddress_ZipPostalCode");
    By phoneNumber = By.id("BillingNewAddress_PhoneNumber");
    By continueBtn = By.xpath("//button[@onclick='Billing.save()']");
    By shippingAddress = By.id("shippingoption_1");
    By continueShippingAddressBtn = By.cssSelector(".button-1.shipping-method-next-step-button");
    By paymentMethodRadioBtn = By.id("paymentmethod_0");
    By paymentMethodContinueBtn = By.cssSelector("button[class='button-1 payment-method-next-step-button']");
    By paymentInformationContinueBtn = By.xpath("//button[@class='button-1 payment-info-next-step-button']");
    By confirmOrderBtn = By.cssSelector(".button-1.confirm-order-next-step-button");
    By completedMessage = By.xpath("//strong[normalize-space()='Your order has been successfully processed!']");
    By orderDetailsLink = By.xpath("//a[normalize-space()='Click here for order details.']");
    public void selectCountry(String country){
        select =new Select(driver.findElement(countries));
        select.selectByVisibleText(country);
    }

    public void fillBillingAddress(String Country,String City,String Address,String zipPostalCodeNumber,String PhoneNumber){
        selectCountry(Country);
        setText(city,City);
        setText(address1,Address);
        setText(zipPostalCode,zipPostalCodeNumber);
        setText(phoneNumber,PhoneNumber);
        click(continueBtn);
    }
    public void chooseShippingAddress(){
        click(shippingAddress);
        click(continueShippingAddressBtn);
    }
    public void choosePaymentMethod(){
        click(paymentMethodRadioBtn);
        click(paymentMethodContinueBtn);
    }
    public void clickContinueInformationBtn(){
        click(paymentInformationContinueBtn);
    }
    public void confirmOrder(){
        click(confirmOrderBtn);
    }
    public String getCompletedOrderMessage(){
        return driver.findElement(completedMessage).getText();
    }
    public OrderDetailsPage openOrderDetailsPage(){
         click(orderDetailsLink);
         return new OrderDetailsPage(driver);
    }






}
