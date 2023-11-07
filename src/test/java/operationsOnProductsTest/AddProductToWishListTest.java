package operationsOnProductsTest;

import itemsDetails.ItemPage;
import itemsDetails.SearchPage;
import itemsDetails.WishListPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import setUp.TestBase;

public class AddProductToWishListTest extends TestBase {
    SearchPage searchPageObj;
    ItemPage itemPageObj;
    WishListPage wishListPageObj;
    String itemName = "Apple MacBook Pro 13-inch";
    @Test
    public void testAddToWishListSuccessfulTest(){
        searchPageObj = homePageObj.searchFor(itemName);
        itemPageObj = searchPageObj.addToCart();
        itemPageObj.addToWishList();
        wishListPageObj = itemPageObj.openWishListPage();
       String itemName= wishListPageObj.getWishListProductItemName();
       Assert.assertTrue(itemName.contains("Apple MacBook Pro 13-inch")
               ,"item not added to wishlist");
       wishListPageObj.removeItemFromWishList();
       String emptyMessage = wishListPageObj.wishListIsEmptyMessage();
       Assert.assertTrue(emptyMessage.contains("empty")
               ,"item not deleted");

    }
}
