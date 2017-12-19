package lesson7_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
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
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                List<WebElement> listElements = webDriver.findElements(by);
                try {
                    result = listElements.get(index);
                    return result.getText().contains(text);

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("There is no element with index " + index);
                    return false;
                }
            }
        };
    }

    ExpectedCondition<Boolean> pageIsLoaded(String titleText, String urlText){
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                return (webDriver.getTitle().contains(titleText))&&(webDriver.getCurrentUrl().contains(urlText));
            }
        };
    }

    ExpectedCondition<Boolean> stalenessOfElement(WebElement webElement){
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                try {
                    return (!webElement.isDisplayed());
                } catch (StaleElementReferenceException e){
                    return true;
                }
            }
        };
    }

}
