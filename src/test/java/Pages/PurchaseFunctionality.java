package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PurchaseFunctionality extends BasePOM{

    public PurchaseFunctionality() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//span//img[@class='product-image-photo'])[1]")
    private WebElement item;


    @FindBy(xpath = "(//button//span[text()='Add to Cart'])[1]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[text()='S']")
    private WebElement sizeButton;

    @FindBy(css = "div[id='option-label-color-93-item-50']")
    private WebElement colorButton;

    @FindBy(xpath = "//div[contains(text(),'You added Radiant Tee to your')]")
    private WebElement addedItemText;

    @FindBy(xpath = "//div[contains(text(),'You added Radiant Tee to your')]//a")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "//button//span[contains(text(),'Proceed to Checkout')]")
    private WebElement proceedToCheckOut;

    @FindBy(css = "input[name='ko_unique_1']")
    private WebElement shippingMethodsRadioButton;

    @FindBy(css = "button[data-role='opc-continue']")
    private WebElement nextButton;
    @FindBy(css = "//span[text()='Place Order']/..")
    private WebElement placeOrderButton;
    @FindBy(css = "h1 >span")
    private WebElement purchaseApproveText;



    private String addedCartVerificationText = "You added Radiant Tee to your ";
    private String purchaseVerificationText = "Thank you for your purchase!";


    public void purchaseAnItem(){

        item.click();
        sizeButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(colorButton));
        colorButton.click();
        addToCartButton.click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(addedItemText.getText().toLowerCase().contains(addedCartVerificationText));
        System.out.println("addedItemText.getText().toLowerCase() = " + addedItemText.getText().toLowerCase());

        shoppingCartButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOut));
        proceedToCheckOut.click();

        shippingMethodsRadioButton.click();
        nextButton.click();

    }

    public void placeOrder() {

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        for(int i =0; i <4 ; i++){
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void validationOfPurchase(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(purchaseApproveText,purchaseVerificationText);
    }



}
