package itemsDetails;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductReviewsPage extends PageBase {
    public ProductReviewsPage(WebDriver driver) {
        super(driver);
    }
    By productReviewTitle = By.id("AddProductReview_Title");
    By reviewText = By.id("AddProductReview_ReviewText");

    By rating = By.id("addproductrating_4");;
    By submitReviewBtn = By.xpath("//button[@name='add-review']");
    By resultReview = By.xpath("//div[@class='result']");

    public void addReview(String Title,String ReviewText){
        setText(productReviewTitle,Title);
        setText(reviewText,ReviewText);
        click(rating);
        click(submitReviewBtn);
    }
    public String getReviewResult(){
        return driver.findElement(resultReview)
                .getText();
    }
}
