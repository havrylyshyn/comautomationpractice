package lesson6_homework;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorizationTest {

    protected static final String BASE_URL = "http://automationpractice.com";
    protected static WebDriver webDriver;
    protected String email = "bob.hawrylyshyn@gmail.com";
    protected String password = "191290";

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\JAVA\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(BASE_URL);
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
        webDriver = null;
    }

    private void assertThat(ExpectedCondition<Boolean> condition){
        (new WebDriverWait(webDriver, 5)).until(condition);
    }

    @Test
    public void checkAccountPageIsOpenedAfterLogin(){
        MainPage mainPage = new MainPage(webDriver);
        LoginPage loginPage = mainPage.openLoginPage();
        AccountPage accountPage = loginPage.logIn(email, password);
        assertThat(textToBePresentInElement(accountPage.accountPage, "MY ACCOUNT"));
    }

    @Ignore
    @Test
    public void checkAccountPageIsOpenedAfterLogin2(){
        MainPage mainPage = new MainPage(webDriver);
        LoginPage loginPage = mainPage.openLoginPage();
        loginPage.enterUsername(email).enterPassword(password).clickSignInBtn();
        AccountPage accountPage = new AccountPage(webDriver);
        assertThat(textToBePresentInElement(accountPage.accountPage, "MY ACCOUNT"));
    }

    @Test
    public void checkLoginPageIsOpenedAfterLogout(){
        AccountPage accountPage = new AccountPage(webDriver);
        LoginPage loginPage = accountPage.signOut();
        assertThat(textToBePresentInElement(loginPage.loginPage, "AUTHENTICATION"));
    }
}
