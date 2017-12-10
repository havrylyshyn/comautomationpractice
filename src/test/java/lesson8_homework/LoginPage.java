package lesson8_homework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private static final Logger LOG = LogManager.getLogger(MainPage.class);

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
        LOG.info("User login:");
        enterUsername(username);
        enterPassword(password);
        clickSignInBtn();
        return new AccountPage(webDriver);
    }

    public void enterUsername(String username) {
        LOG.info("Enter email");
        email.clear();
        email.sendKeys(username);
    }

    public void enterPassword(String password) {
        LOG.info("Enter password");
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void clickSignInBtn() {
        LOG.info("Click on SignIn button");
        loginBtn.click();
    }
}
