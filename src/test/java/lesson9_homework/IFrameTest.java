package lesson9_homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class IFrameTest extends BaseTest{

    protected String iFrameTitle = "fb:like_box Facebook Social Plugin";
    protected String iFrameX = "document.querySelector('[title=\"" + iFrameTitle + "\"]').getBoundingClientRect().left";
    protected String iFrameY = "document.querySelector('[title=\"" + iFrameTitle + "\"]').getBoundingClientRect().top";

    @Test
    public void iFrameTest(){
        MainPage mainPage = new MainPage(webDriver);
        JavascriptExecutor js = ((JavascriptExecutor) webDriver);
        js.executeScript("window.scrollTo(" + iFrameX + "," + iFrameY + ")");
        webDriver.switchTo().frame(mainPage.iFrame);
        Assert.assertEquals("PrestaShop", webDriver.findElement(By.xpath("//a[@title='PrestaShop']")).getText());
    }
}
