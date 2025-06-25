package com.project_name.step_definitions;

import com.project_name.pages.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class InvalidLoginStepDef extends BasePage {
    @Given("The user able to click Login button")
    public void the_user_able_to_click_login_button() {
        buttonAcceptAllCookies.click();
        loginButtn.click();

    }

    @Then("The user able to fill out {string}")
    public void theUserAbleToFillOut(String username) {
        username1.sendKeys(username);


    }

    @Then("The user able to fill out {string} and click  login button")
    public void theUserAbleToFillOutAndClickLoginButton(String password) {
        password1.sendKeys(password);
        login1.click();
    }

    @And("Verify the user should see {string}")
    public void verifyTheUserShouldSee(String errorMessage) {
        System.out.println("message1.getText() = " + message1.getText());
        Assert.assertTrue(errorMessage,true);

    }
}
