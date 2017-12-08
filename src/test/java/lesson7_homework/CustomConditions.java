package lesson7_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CustomConditions {

    static WebDriver webDriver;
    static WebElement result;
    static WebDriverWait wait;

    CustomConditions(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 5);
    }

    ExpectedCondition<Boolean> listNthElementHasText(By by, int index, String text){
        List<WebElement> listElements = webDriver.findElements(by);
        try {
            result = listElements.get(index);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is no element with index " + index);
        }
        return ExpectedConditions.textToBePresentInElement(result, text);
    }

    Boolean pageIsLoaded(String titleText, String urlText){
        wait.until(ExpectedConditions.titleContains(titleText));
        wait.until(ExpectedConditions.urlContains(urlText));
        return true;
    }

    ExpectedCondition<Boolean> stalenessOfElement(WebElement webElement){
        return ExpectedConditions.stalenessOf(webElement);
    }

}
