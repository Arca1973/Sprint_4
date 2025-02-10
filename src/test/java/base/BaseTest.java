package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp() {

        String browser = System.getProperty("browser", "firefox");
        driver = WebDriverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

