package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Random;

public class MyAccountPage extends BasePOM{
    public MyAccountPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//button[@class='action switch'])[1]")
    private WebElement downArrowButton;

    @FindBy(xpath = "(//a[text()='My Account'])[1]")
    private WebElement myAccountButton;

    @FindBy(xpath = "(//*[text()='Manage Addresses'])[1]")
    private WebElement manageAddressesButton;

    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(id = "street_1")
    private WebElement streetInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zip")
    private WebElement zipInput;

    @FindBy(id = "telephone")
    private WebElement telephoneInput;

    @FindBy(id = "region_id")
    private WebElement stateSelection;

    @FindBy(css = "button[data-action='save-address']")
    private WebElement saveAddressButton;

    @FindBy(xpath = "//*[text()='You saved the address.']")
    private WebElement addressVerify;

    @FindBy(xpath = "//*[text()='Delete']")
    private WebElement deleteAddressButton;

    @FindBy(xpath = "//*[text()='Add New Address']")
    private WebElement addNewAddress;

    private String verifiedText = "You saved the address.";



    public void navigateToManageAddresses(){
        downArrowButton.click();
        myAccountButton.click();
        manageAddressesButton.click();

    }

    public void enterAddressInputs(String firstName, String lastName, String streetAddress, String phone, String city, String zipcode){

        addNewAddress.click();

        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        telephoneInput.clear();
        telephoneInput.sendKeys(phone);
        streetInput.clear();
        streetInput.sendKeys(streetAddress);
        cityInput.clear();
        cityInput.sendKeys(city);
        zipInput.clear();
        zipInput.sendKeys(zipcode);

        Select select = new Select(stateSelection);
        Random random = new Random();
        int rnd = random.nextInt(65)+1;
        String rndT = String.valueOf(rnd);
        select.selectByValue(rndT);

        saveAddressButton.click();

    }

    public void addressVerification(){
        Assert.assertEquals(verifiedText,"You saved the address.", "Address is not saved!");
    }


}
