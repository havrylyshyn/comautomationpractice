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

import static org.hamcrest.CoreMatchers.containsString;

public class SearchTest {
    protected static final String BASE_URL = "http://automationpractice.com/";
    protected static WebDriver webDriver;

    @Test
    public void search() {
        WebElement searchFld = webDriver.findElement(By.name("search_query"));
        searchFld.click();
        searchFld.clear();
        searchFld.sendKeys("Printed Summer Dress");
        WebElement searchBtn = webDriver.findElement(By.name("submit_search"));
        searchBtn.click();
        WebElement result1 = webDriver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div"));
        WebElement result2 = webDriver.findElement(By.xpath("//*[@id='center_column']/ul/li[2]/div"));
        WebElement result3 = webDriver.findElement(By.xpath("//*[@id='center_column']/ul/li[3]/div"));

        Assert.assertThat("", result1.getText(), containsString("Printed Summer Dress"));
        Assert.assertThat("", result2.getText(), containsString("Printed Summer Dress"));
        Assert.assertThat("", result3.getText(), containsString("Dress"));
    }
}
