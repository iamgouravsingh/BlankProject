package StepDefinitions;

import Setup.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.project.Modules.FlightBooking;

import java.io.IOException;

public class FLightBookingStepDef extends BaseClass {

    public FlightBooking flightBooking;

    @Given("user is on landing page")
    public void userIsOnLandingPage() throws IOException {
        flightBooking = launchApplication();
    }

    @When("user select origin")
    public void userSelectOrigin() throws InterruptedException {
        flightBooking.enterOrigin();
        Thread.sleep(2000);
    }

    @And("select destination")
    public void selectDestination() {
        flightBooking.enterDestination();
    }
}
