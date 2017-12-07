package lesson5_homework;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

public class SearchTest {
    protected static final String BASE_URL = "http://automationpractice.com/";
    protected static WebDriver webDriver;

    @BeforeClass
    public static void setUp() {
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

    @Test
    public void search() {
        WebElement searchFld = webDriver.findElement(By.name("search_query"));
        searchFld.click();
        searchFld.clear();
        searchFld.sendKeys("Printed Summer Dress");
        WebElement searchBtn = webDriver.findElement(By.name("submit_search"));
        searchBtn.click();
        WebElement resultNumber = webDriver.findElement(By.xpath("//span[@class='heading-counter']"));
        WebElement result1 = webDriver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div"));

        Assert.assertThat("Results number should be 3", resultNumber.getText().trim(), containsString("3 results have been found."));
        Assert.assertThat("First result should be 'Printed Summer Dress'", result1.getText(), containsString("Printed Summer Dress"));

    }
}
