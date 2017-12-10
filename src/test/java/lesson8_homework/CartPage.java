package lesson8_homework;

import org.apache.commons.exec.util.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private static final Logger LOG = LogManager.getLogger(MainPage.class);

    static WebDriver webDriver;

    @FindBy(xpath = "//p/a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutBtn;

    @FindBy(name = "processAddress")
    WebElement processAddressBtn;

    @FindBy(name = "cgv")
    WebElement agreementCheckbox;

    @FindBy(name = "processCarrier")
    WebElement processCarrierBtn;

    @FindBy(className = "bankwire")
    WebElement bankWire;

    @FindBy(xpath = "//button[contains(.,'confirm')]")
    WebElement confirmOrderBtn;

    @FindBy(xpath = "//a[@title='Back to orders']")
    WebElement backToOrdersBtn;

    @FindBy(className = "box")
    WebElement referenceBox;

    CartPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    void proceedToCheckout(){
        LOG.info("Proceed to Checkout");
        proceedToCheckoutBtn.click();
    }

    void processAddress(){
        LOG.info("Confirm delivery address");
        processAddressBtn.click();
    }

    void agreeTerms(){
        LOG.info("Confirm agreement of Terms");
        agreementCheckbox.click();
    }

    void processCarrier(){
        LOG.info("Go to Payment");
        processCarrierBtn.click();
    }

    void selectBankWire(){
        LOG.info("Select Bank Wire option");
        bankWire.click();
    }

    void confirmOrder(){
        LOG.info("Confirm Order");
        confirmOrderBtn.click();
    }

    void makeOrder(){
        proceedToCheckout();
        processAddress();
        agreeTerms();
        processCarrier();
        selectBankWire();
        confirmOrder();
    }

    OrderHistoryPage backToOrders(){
        LOG.info("Return to Order History page");
        backToOrdersBtn.click();
        return new OrderHistoryPage(webDriver);
    }

    String getReference(){
        LOG.info("Get product reference from Order");
        String reference = referenceBox.getText();
        reference = reference.substring(reference.indexOf("reference ") + 10, reference.indexOf(" in "));
        return reference;
    }
}
