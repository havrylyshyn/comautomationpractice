package lesson6_homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    static WebDriver webDriver;

    @FindBy(className = "page-heading")
    WebElement loginPage;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "passwd")
    WebElement password;

    @FindBy(name = "SubmitLogin")
    WebElement loginBtn;

    LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    AccountPage logIn(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSignInBtn();
        return new AccountPage(webDriver);
    }

    public LoginPage enterUsername(String username) {
        email.clear();
        email.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
        return this;
    }

    public LoginPage clickSignInBtn() {
        loginBtn.click();
        return this;
    }
}
