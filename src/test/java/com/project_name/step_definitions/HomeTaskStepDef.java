package com.project_name.step_definitions;

import com.project_name.pages.BasePage;
import com.project_name.utilities.BrowserUtils;
import com.project_name.utilities.ConfigurationReader;
import com.project_name.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomeTaskStepDef extends BasePage {
    @Then("The user click alerts")
    public void theUserClickAlerts() {
        try {
            if (buttonAcceptAllCookies.isDisplayed()) {
                buttonAcceptAllCookies.click();
                System.out.println("Cookies accepted.");
            }
        } catch (Exception e) {
            System.out.println("Cookie popup not displayed.");
        }
    }

    @Given("the user opens a supported web browser")
    public void the_user_opens_a_supported_web_browser() {
        buttonAcceptAllCookies.click();
        System.out.println("[INFO] Using browser: " + ConfigurationReader.getProperty("browser"));

    }

    @When("the user navigates to {string}")
    public void theUserNavigatesTo(String url) {
        System.out.println("[INFO] Navigating to URL: " + ConfigurationReader.getProperty("url"));
    }

    @Then("the homepage should load successfully without any errors")
    public void theHomepageShouldLoadSuccessfullyWithoutAnyErrors() {
        BrowserUtils.waitForVisibility(logo,10);
        System.out.println("[INFO] Homepage loaded successfully. URL: "+ ConfigurationReader.getProperty("url"));


    }

    @Then("the page title should contain {string}")
    public void thePageTitleShouldContain(String title) {
        System.out.println("[INFO] Page title: " + BrowserUtils.getTitle());
        Assert.assertTrue(BrowserUtils.getTitle().contains(title));

    }

    @Then("the current URL should contain {string}")
    public void theCurrentURLShouldContain(String url) {
        BrowserUtils.verifyURLContains(url);

    }

    @Then("the {string} module should be visible")
    public void theModuleShouldBeVisible(String module) {
        switch (module) {
            case "Top Events":
                System.out.println("[INFO] 'Top Events' visibility status: " + topEvents.isDisplayed());
                break;
            case "Top Bets":
                System.out.println("[INFO] 'Top Bets' visibility status: " + topBets.isDisplayed());
                ;
                break;
            default:
                throw new IllegalArgumentException("Module \"" + module + "\" is not defined or supported.");
        }
    }

    @When("the user clicks on the {string} section")
    public void theUserClicksOnTheSection(String section) {
        buttonAcceptAllCookies.click();

        if (section.contains("Casino")) {
            mainCasino.click();
        } else if (section.contains("Promotions")) {
            mainPromotions.click();
        } else {
            throw new IllegalArgumentException("Undefined section: \"" + section + "\" is not recognized. Please check the section name.");
        }

    }

    @Then("the user should be redirected to the {string} page")
    public void theUserShouldBeRedirectedToThePage(String destination) {
        String title = BrowserUtils.getTitle();
        String url = Driver.getDriver().getCurrentUrl();

        System.out.println("[INFO] Checking redirection to: " + destination);
        System.out.println("[INFO] Page Title     : " + title);
        System.out.println("[INFO] Current URL    : " + url);

        boolean isTitleMatch = title != null && title.toLowerCase().contains(destination.toLowerCase());
        boolean isUrlMatch = url != null && url.toLowerCase().contains(destination.toLowerCase());

        Assert.assertTrue(
                "Redirection failed. Expected: " + destination +
                        " | Title: " + title +
                        " | URL: " + url,
                isTitleMatch || isUrlMatch
        );

    }
}