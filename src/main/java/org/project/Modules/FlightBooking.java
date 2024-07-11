package org.project.Modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightBooking {

    WebDriver driver;

    public FlightBooking(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "ctl00_mainContent_ddl_originStation1_CTXT")
    WebElement originStation;

    @FindBy(xpath = "//a[@value='BHO']")
    WebElement originValue;

    @FindBy(id = "ctl00_mainContent_ddl_destinationStation1_CTXT\"")
    WebElement destinationStation;

    @FindBy(xpath = "(//a[@value='BLR'])[2]")
    WebElement destinationValue;

    public void enterOrigin() {
        originStation.click();
        originValue.click();
    }

    public void enterDestination() {
        destinationStation.click();
        destinationValue.click();
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }


}
