package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest {

    RegistrationPage registrationPage;
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void canRegisterWithValidCredentials() {
        registrationPage.registerUs("Male", "Timmy", "Test", "16", "May", "1999", "timmizc@test.com", "Endava", true, "test123", "test123");
        assertEquals(registrationPage.getValidMessage(), "Your registration completed");
    }


    @Test
    public void cannotRegisterWithSameEmail() {
        registrationPage.registerUs("Male", "Timmy", "Test", "16", "May", "1999", "timmyyy@test.com", "Endava", true, "test123", "test123");
        assertEquals(registrationPage.getErrorMessage(), "The specified email already exists");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

