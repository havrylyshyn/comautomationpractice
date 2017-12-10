package lesson8_homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MainPage {

    private static final Logger LOG = LogManager.getLogger(MainPage.class);

    static WebDriver webDriver;

    @FindBy(className = "login")
    WebElement login;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    WebElement cart;

    MainPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    LoginPage openLoginPage(){
        LOG.info("Open Login page");
        login.click();
        return new LoginPage(webDriver);
    }

}
