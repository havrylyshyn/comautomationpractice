package lesson5_homework;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@Suite.SuiteClasses({SearchTest.class})
@RunWith(Suite.class)
public class LoginTest {
    protected static final String BASE_URL = "http://automationpractice.com/";
    protected static WebDriver webDriver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\JAVA\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(BASE_URL);
        login();
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
        webDriver = null;
    }

    public static void login() {
        WebElement login = webDriver.findElement(By.className("login"));
        login.click();
        WebElement email = webDriver.findElement(By.name("email"));
        email.sendKeys("bob.hawrylyshyn@gmail.com");
        WebElement password = webDriver.findElement(By.name("passwd"));
        password.sendKeys("191290");
        WebElement loginBtn = webDriver.findElement(By.name("SubmitLogin"));
        loginBtn.click();
    }

    @Test
    public void accountPageIsOpened() {
        WebElement account = webDriver.findElement(By.className("account"));
        account.click();
        WebElement accountPage = webDriver.findElement(By.className("page-heading"));
        Assert.assertEquals("MY ACCOUNT", accountPage.getText());
    }

    @Test
    public void historyPageIsOpened() {
        WebElement account = webDriver.findElement(By.className("account"));
        account.click();
        WebElement historyTitle = webDriver.findElement(By.xpath("//a[@title='Orders']"));
        historyTitle.click();

        WebElement historyPage = webDriver.findElement(By.className("page-heading"));
        Assert.assertEquals("ORDER HISTORY", historyPage.getText());
    }

    @Test
    public void creditPageIsOpened() {
        WebElement account = webDriver.findElement(By.className("account"));
        account.click();
        WebElement creditTitle = webDriver.findElement(By.xpath("//a[@title='Credit slips']"));
        creditTitle.click();

        WebElement creditPage = webDriver.findElement(By.className("page-heading"));
        Assert.assertEquals("CREDIT SLIPS", creditPage.getText());
    }

    @Test
    public void addressesPageIsOpened() {
        WebElement account = webDriver.findElement(By.className("account"));
        account.click();
        WebElement addressesTitle = webDriver.findElement(By.xpath("//a[@title='Addresses']"));
        addressesTitle.click();

        WebElement addressesPage = webDriver.findElement(By.className("page-heading"));
        Assert.assertEquals("MY ADDRESSES", addressesPage.getText());
    }

    @Test
    public void informationPageIsOpened() {
        WebElement account = webDriver.findElement(By.className("account"));
        account.click();
        WebElement informationTitle = webDriver.findElement(By.xpath("//a[@title='Information']"));
        informationTitle.click();

        WebElement informationPage = webDriver.findElement(By.className("page-subheading"));
        Assert.assertEquals("YOUR PERSONAL INFORMATION", informationPage.getText().trim());
    }

    @Test
    public void wishListsPageIsOpened() {
        WebElement account = webDriver.findElement(By.className("account"));
        account.click();
        WebElement wishListsTitle = webDriver.findElement(By.xpath("//a[@title='My wishlists']"));
        wishListsTitle.click();

        WebElement wishListsPage = webDriver.findElement(By.className("page-heading"));
        Assert.assertEquals("MY WISHLISTS", wishListsPage.getText());
    }
}
