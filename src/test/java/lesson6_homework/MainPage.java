package lesson6_homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    static WebDriver webDriver;

    @FindBy(className = "login")
    WebElement login;

    MainPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage openLoginPage(){
        login.click();
        return new LoginPage(webDriver);
    }
}
