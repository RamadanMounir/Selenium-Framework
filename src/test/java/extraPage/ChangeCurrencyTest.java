package extraPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import itemsDetails.ItemPage;
import itemsDetails.SearchPage;
import setUp.TestBase;

public class ChangeCurrencyTest extends TestBase {

    SearchPage searchPageObj;
    ItemPage itemPageObj;
    String itemName = "Apple MacBook Pro 13-inch";
    String currencyType="Euro";

    @Test
    public void test(){
        homePageObj.changeCurrency(currencyType);
        searchPageObj = homePageObj.searchFor(itemName);
        //will open item page
       itemPageObj = searchPageObj.addToCart();
       String currency = itemPageObj.checkCurrency();
        Assert.assertTrue(currency.contains("€"),"fault currency");
    }
}
