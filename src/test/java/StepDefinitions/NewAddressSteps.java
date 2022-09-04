package StepDefinitions;

import Pages.MyAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class NewAddressSteps {

    MyAccountPage myAccountPage;

    @Then("User click to My Account page and then click on Manage Addresses")
    public void userClickOnManageAddresses() {
        myAccountPage = new MyAccountPage();
        myAccountPage.navigateToManageAddresses();

    }

    @And("User add a new address with {string}, {string}, {string}, {string}, {string}, {string}")
    public void userAddANewAddressWith(String firstName, String lastName, String streetAddress, String phone, String city, String zipcode) {

        myAccountPage = new MyAccountPage();
        myAccountPage.enterAddressInputs(firstName, lastName, streetAddress, phone, city, zipcode);

    }

    @Then("Validate saved Address")
    public void validateSavedAddress() {
        myAccountPage = new MyAccountPage();
        myAccountPage.addressVerification();
    }

}
