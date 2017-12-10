package lesson8_homework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

public class SearchPage {

    private static final Logger LOG = LogManager.getLogger(MainPage.class);

    static WebDriver webDriver;

    @FindBy(xpath = "//h5[@itemprop='name'][contains(.,'Printed Chiffon Dress')]/a")
    WebElement dress;

    @FindBy(xpath = "//div[@class='product-container'][contains(.,'Printed Chiffon Dress')]//a[@title='Add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    WebElement cart;

    SearchPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    void addProductToCart(){
        LOG.info("Add product 'Printed Chiffon Dress' to Cart");
        new Actions(webDriver).moveToElement(dress).perform();
        webDriver.findElement(By.xpath("//div[@class='product-container'][contains(.,'Printed Chiffon Dress')]//a[@title='Add to cart']")).click();
    }

    CartPage openCartPage(){
        LOG.info("Open Cart page");
        cart.click();
        return new CartPage(webDriver);
    }

}
