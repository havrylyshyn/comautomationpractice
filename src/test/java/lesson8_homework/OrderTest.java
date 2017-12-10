package lesson8_homework;

import org.junit.Assert;
import org.junit.Test;

public class OrderTest extends BaseTest{

    protected String email = "bob.hawrylyshyn@gmail.com";
    protected String password = "191290";
    protected String query = "Dress";

    @Test
    public void checkOrder(){
        MainPage mainPage = new MainPage(webDriver);
        LoginPage loginPage = mainPage.openLoginPage();
        AccountPage accountPage = loginPage.logIn(email, password);
        accountPage.enterQuery(query);
        SearchPage searchPage = accountPage.initiateSearch();
        searchPage.addProductToCart();
        CartPage cartPage = searchPage.openCartPage();
        cartPage.makeOrder();
        String expectedReference = cartPage.getReference();
        OrderHistoryPage orderHistoryPage = cartPage.backToOrders();
        String actualReference = orderHistoryPage.getReference();
        Assert.assertTrue(actualReference.equals(expectedReference));
    }

}
