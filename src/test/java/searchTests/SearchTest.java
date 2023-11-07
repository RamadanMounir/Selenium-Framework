package searchTests;

import org.testng.annotations.Test;
import itemsDetails.ItemPage;
import itemsDetails.SearchPage;
import setUp.TestBase;
public class SearchTest extends TestBase {
    SearchPage searchPageObj;
    ItemPage itemPageObj;
    String itemName = "Apple MacBook Pro 13-inch";
    @Test
    public void testSuccessfulTest(){
       searchPageObj = homePageObj.searchFor(itemName);
       itemPageObj = searchPageObj.addToCart();
       itemPageObj.addToCart();

    }
}
