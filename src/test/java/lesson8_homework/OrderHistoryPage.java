package lesson8_homework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {

    private static final Logger LOG = LogManager.getLogger(MainPage.class);

    static WebDriver webDriver;

    @FindBy(xpath = "//*[@id='order-list']/tbody/tr[1]/td[1]/a")
    WebElement reference;

    OrderHistoryPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    String getReference(){
        LOG.info("Get last product reference");
        return reference.getText();
    }
}
