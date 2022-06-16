package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationPage {

    @FindBy(name = "Gender")
    List<WebElement> genderRadioButtons;

    @FindBy(id = "FirstName")
    WebElement firstNameimput;

    @FindBy(id = "LastName")
    WebElement lastNameimput;
    @FindBy(id = "Email")
    WebElement emailimput;
    @FindBy(id = "Company")
    WebElement companyimput;
    @FindBy(id = "Newsletter")
    WebElement newslettercheckbox;
    @FindBy(id = "Password")
    WebElement passwordimput;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassworfimput;
    @FindBy(name = "DateOfBirthDay")
    private WebElement dobDropdown;
    @FindBy(name = "DateOfBirthMonth")
    private WebElement mounthDobDropDown;
    @FindBy(name = "DateOfBirthYear")
    private WebElement yearDobDropDown;
    @FindBy(xpath = "//*[@id=\"register-button\"]")
    private WebElement registerbutton;
    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    private WebElement validMessage;

    @FindBy(xpath = "//li[contains(text(),'The specified email already exists')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[@id='FirstName-error']")
    private WebElement errorMessagee;

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectGender(String gender) {

        if (gender.equalsIgnoreCase("Male")) {
            genderRadioButtons.get(0).click();
        } else {
            genderRadioButtons.get(1).click();
        }
    }


    public void selectDayOfBirth(String day) {
        Select select = new Select(dobDropdown);
        select.selectByVisibleText(day);
    }

    public void selectDateOfBirthMonth(String month) {
        Select select = new Select(mounthDobDropDown);
        select.selectByVisibleText(month);
    }

    public void selectDateOfBirthYear(String year) {
        Select select = new Select(yearDobDropDown);
        select.selectByVisibleText(year);
    }


    public void selectNewsLetterCheckBox(boolean newsLetter) {
        if (newsLetter == false)
            newslettercheckbox.click();

    }

    public void registerUs(String gender, String firstName, String lastName, String day, String month, String year, String email, String company, boolean newsLetter, String password, String confirmPassword) {
        selectGender(gender);
        firstNameimput.sendKeys(firstName);
        lastNameimput.sendKeys(lastName);
        selectDayOfBirth(day);
        selectDateOfBirthMonth(month);
        selectDateOfBirthYear(year);
        emailimput.sendKeys(email);
        companyimput.sendKeys(company);
        selectNewsLetterCheckBox(newsLetter);
        passwordimput.sendKeys(password);
        confirmPassworfimput.sendKeys(confirmPassword);
        registerbutton.click();

    }

    public String getValidMessage() {
        return validMessage.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();

    }
    public String getErrorMessagee() {
        return errorMessagee.getText();
    }

}
