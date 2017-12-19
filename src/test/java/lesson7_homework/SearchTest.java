package lesson7_homework;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchTest {
    protected static final String BASE_URL = "http://automationpractice.com";
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

    private void assertThat(ExpectedCondition<Boolean> condition){
        (new WebDriverWait(webDriver, 5)).until(condition);
    }

    @Test
    public void checkListNthElementHasText(){
        WebElement searchFld = webDriver.findElement(By.name("search_query"));
        searchFld.click();
        searchFld.clear();
        searchFld.sendKeys("Dress");
        WebElement searchBtn = webDriver.findElement(By.name("submit_search"));
        searchBtn.click();
        CustomConditions customConditions = new CustomConditions(webDriver);
        assertThat(customConditions.listNthElementHasText(By.xpath("//h5[@itemprop='name']/a"), 4, "Dress"));
    }

    @Test
    public void checkPageIsLoaded(){
        WebElement searchFld = webDriver.findElement(By.name("search_query"));
        searchFld.click();
        searchFld.clear();
        searchFld.sendKeys("Dress");
        WebElement searchBtn = webDriver.findElement(By.name("submit_search"));
        searchBtn.click();
        CustomConditions customConditions = new CustomConditions(webDriver);
        assertThat(customConditions.pageIsLoaded("Search","controller=search"));
    }

    @Test
    public void checkStalenessOfElement(){
        WebElement searchFld = webDriver.findElement(By.name("search_query"));
        searchFld.click();
        searchFld.clear();
        searchFld.sendKeys("Dress");
        WebElement searchBtn = webDriver.findElement(By.name("submit_search"));
        searchBtn.click();
        CustomConditions customConditions = new CustomConditions(webDriver);
        assertThat(customConditions.stalenessOfElement(searchFld));
    }
}
