package StepDefinitions;

import Pages.MyAccountPage;
import Pages.PurchaseFunctionality;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class PurchaseSteps {
    PurchaseFunctionality pf;
    @And("User select an item and complete purchase steps")
    public void userSelectAnItemAndCompletePurchaseSteps() {
        pf = new PurchaseFunctionality();
        pf.purchaseAnItem();
        pf.placeOrder();

    }

    @Then("Validate purchase")
    public void validatePurchase() {
        pf = new PurchaseFunctionality();
        pf.validationOfPurchase();


    }
}
