package lesson8_homework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    private static final Logger LOG = LogManager.getLogger(MainPage.class);

    static WebDriver webDriver;

    @FindBy(className = "logout")
    WebElement logoutBtn;

    @FindBy(name = "search_query")
    WebElement searchInput;

    @FindBy(name = "submit_search")
    WebElement searchBtn;

    AccountPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    LoginPage signOut() {
        logoutBtn.click();
        return new LoginPage(webDriver);
    }

    void enterQuery(String query){
        LOG.info("Enter query " + query);
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(query);
    }

    SearchPage initiateSearch(){
        LOG.info("Initiate search");
        searchBtn.click();
        return new SearchPage(webDriver);
    }
}
