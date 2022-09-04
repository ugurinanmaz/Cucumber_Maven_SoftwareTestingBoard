package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePOM {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.authorization-link > a")  //"header.page-header div > ul > li.authorization-link > a"
    private WebElement homePageSignInButton;


    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(name = "login[password]")
    private WebElement passInput;

    @FindBy(name = "send")
    private WebElement loginPageSignInButton;

    @FindBy(xpath = "(//li//span[contains(text(),'Welcome')])[1]")
    private WebElement welcomeVerify;

    private String email = "omenoo@mailinator.com";
    private String password = "Omen1234";

    private String verifiedText = "Welcome, Omen oo!";

    public void navigateToLoginPage(){
        wait.until(ExpectedConditions.visibilityOf(homePageSignInButton));
        homePageSignInButton.click();
    }

    public void enterUserInputAndClickSignIn(){
        emailInput.sendKeys(email);
        passInput.sendKeys(password);
        loginPageSignInButton.click();
    }

    public void setWelcomeVerify(){

        Assert.assertTrue(welcomeVerify.getText().equalsIgnoreCase(verifiedText));
    }



}
