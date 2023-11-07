package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    WebDriverWait wait;
    protected WebDriver driver;
    protected Select select;

    protected Actions actions;
    public PageBase(WebDriver driver){
         this.driver = driver;
    }

    protected void click(By target){
        driver.findElement(target)
                .click();
    }
    protected void setText(By target,String value){
        driver.findElement(target)
                .sendKeys(value);
    }

    protected void waitAndClick(By target){
     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     WebElement element = wait.until(ExpectedConditions.elementToBeClickable(target));
     ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
}

}
