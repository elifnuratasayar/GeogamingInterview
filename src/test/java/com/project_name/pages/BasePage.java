package com.project_name.pages;


import com.project_name.utilities.BrowserUtils;
import com.project_name.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@data-test-locator='LOGIN']")
    public WebElement loginButtn;
    @FindBy(xpath = "//input[@name='username']")
    public WebElement username1;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password1;
    @FindBy(xpath = "//button[@data-test-locator='loginText']")
    public WebElement login1;

    @FindBy(xpath = "/html/body/div[5]/div/div[2]/div/button")
    public WebElement buttonAcceptAllCookies;

    @FindBy(xpath = "//div[contains(@class, \'spb-alert-block--popup\')]")
    public WebElement message1;

    @FindBy(xpath = "//div[@class='ng-star-inserted'][.//spb-links]")
    public WebElement topEvents;
    @FindBy(xpath = "//div[@class='spb-bespoke-widgets-wrapper spb-bespoke-widgets-wrapper--right-betslip']")
    public WebElement topBets;

    @FindBy(xpath = "//span[.='Casino']")
    public WebElement mainCasino;

    @FindBy(xpath = "//span[.='Promotions']")
    public WebElement mainPromotions;
    @FindBy(xpath = "//div[@class='spb-logo spb-logo__logo-container spb-util-align-float-left spb-logo__logo-container--sport-and-inplay-page']")
    public WebElement logo;


//

    /*
    Write a UI automation test using Java + Selenium + Cucumber that:
Navigates to the site
Clicks Login
Inputs invalid credentials
Asserts that the appropriate error message is displayed
Task Instructions – Please begin now:
Open: https://en.sportingbull.com/sportsbook
Click the Login button
Enter invalid credentials (e.g., testuser / wrongpass)
Verify that an error message appears
You have 30 minutes from now. The recording is running.
Good luck!
     */
}
