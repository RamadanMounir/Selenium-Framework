package shoppingCart;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderDetailsPage extends PageBase {
    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }
    By printBtn = By.xpath("//a[@class='button-2 print-order-button']");
    By PDFInvoice = By.xpath("//a[@class='button-2 pdf-invoice-button']");

    public void clickPrintBtn(){
        click(printBtn);
    }
    public void downloadPDFInvoice(){
        click(PDFInvoice);
    }
}
