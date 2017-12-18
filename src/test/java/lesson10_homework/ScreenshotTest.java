package lesson10_homework;

import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ScreenshotTest extends BaseTest{

    protected String email = "bob.hawrylyshyn@gmail.com";
    protected String password1 = "191290";
    protected String password2 = "1111";

    @Test
    public void checkLoginWithPassword1(){
        MainPage mainPage = new MainPage(webDriver);
        LoginPage loginPage = mainPage.openLoginPage();
        AccountPage accountPage = loginPage.logIn(email, password1);
        assertThat(ExpectedConditions.textToBePresentInElement(accountPage.accountPage, "MY ACCOUNT"));
    }

    @Test
    public void checkLoginWithPassword2(){
        MainPage mainPage = new MainPage(webDriver);
        LoginPage loginPage = mainPage.openLoginPage();
        AccountPage accountPage = loginPage.logIn(email, password2);
        assertThat(ExpectedConditions.textToBePresentInElement(accountPage.accountPage, "MY ACCOUNT"));
    }
}
