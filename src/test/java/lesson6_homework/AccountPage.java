package lesson6_homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    static WebDriver webDriver;

    @FindBy(className = "page-heading")
    WebElement accountPage;

    @FindBy(className = "logout")
    WebElement logoutBtn;

    AccountPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    LoginPage signOut() {
        logoutBtn.click();
        return new LoginPage(webDriver);
    }
}
