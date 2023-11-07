package operationsOnProductsTest;

import itemsDetails.ItemPage;
import itemsDetails.SearchPage;
import shoppingCart.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import setUp.TestBase;

public class AddProductToCartTest extends TestBase {

    ShoppingCartPage ShoppingCartPageObj;
    SearchPage searchPageObj;
    ItemPage itemPageObj;
    ShoppingCartPage shoppingCartPageObj;
    String itemName = "Apple MacBook Pro 13-inch";
    @Test
    public void testAddItemToCartSuccessfully(){
        //1- search for item
        searchPageObj = homePageObj.searchFor(itemName);
        //2- switch to item page
        itemPageObj = searchPageObj.addToCart();
        //3- add item to cart
        itemPageObj.addToCart();
        //4- open shopping cart page
        shoppingCartPageObj= itemPageObj.openCartPage();

        String shoppingCartTitle = shoppingCartPageObj.getShoppingCartTitle();
        Assert.assertTrue(shoppingCartTitle.contains("Shopping cart")
                ,"you are not on shopping cart");
        String itemOnCart = shoppingCartPageObj.getItemName();
        Assert.assertTrue(itemOnCart.contains(itemName)
                ,"item not added to cart");

    }
}
