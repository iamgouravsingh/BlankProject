package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.project.Modules.FlightBooking;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public class BaseClass {
    public WebDriver driver;
    public FlightBooking flightBooking;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();


    private WebDriver initializeDriver(String browser) {
        System.out.println("browser value is: " + browser);

        if (browser.equals("chrome")) {
            tlDriver.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {

            tlDriver.set(new FirefoxDriver());
        } else if (browser.equals("safari")) {
            tlDriver.set(new SafariDriver());
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return getDriver();

    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
    @BeforeMethod
    public FlightBooking launchApplication() throws IOException {
        String browser = "chrome";
        driver = initializeDriver(browser);
        flightBooking = new FlightBooking(driver);
        flightBooking.goTo();
        return flightBooking;
    }


}
