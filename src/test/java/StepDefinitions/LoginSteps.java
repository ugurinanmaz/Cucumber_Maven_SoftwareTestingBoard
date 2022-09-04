package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    LoginPage loginPage;

    @Given("Navigate to magento Software testing board")
    public void navigateToMagentoSoftwareTestingBoard() {
        loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        loginPage = new LoginPage();
        loginPage.enterUserInputAndClickSignIn();
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        loginPage = new LoginPage();
        loginPage.setWelcomeVerify();
    }


}
