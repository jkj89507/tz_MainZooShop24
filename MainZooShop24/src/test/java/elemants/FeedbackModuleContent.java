package elemants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeedbackModuleContent {
    public WebDriver driver;

    public FeedbackModuleContent(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"b24-b24-site-button-form-4\"]/div/div[2]/button")
    private WebElement closeBtn;

    @FindBy(xpath = "//*[@id=\"b24-b24-site-button-form-4\"]/div/div[2]/div/div/div[2]/div[2]/form/div[1]/div[1]/div/div/div/input")
    private WebElement inputFirstName;

    @FindBy(xpath = "//*[@id=\"b24-b24-site-button-form-4\"]/div/div[2]/div/div/div[2]/div[2]/form/div[1]/div[2]/div/div/div/input]")
    private WebElement inputSecondName;

    @FindBy(xpath = "//*[@id=\"b24-b24-site-button-form-4\"]/div/div[2]/div/div/div[2]/div[2]/form/div[1]/div[3]/div/div/div/input")
    private WebElement inputPhone;

    @FindBy(xpath = "//*[@id=\"b24-b24-site-button-form-4\"]/div/div[2]/div/div/div[2]/div[2]/form/div[1]/div[3]/div/a")
    private WebElement inputPhoneMoreBtn;

    @FindBy(xpath = "//*[@id=\"b24-b24-site-button-form-4\"]/div/div[2]/div/div/div[2]/div[2]/form/div[1]/div[4]/div/div/div/input")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@id=\"b24-b24-site-button-form-4\"]/div/div[2]/div/div/div[2]/div[2]/form/div[1]/div[5]/div/div/div/textarea")
    private WebElement inputComment;

    @FindBy(xpath = "//*[@id=\"b24-b24-site-button-form-4\"]/div/div[2]/div/div/div[2]/div[2]/form/div[2]/div[1]/div/label/input")
    private WebElement checkboxFZ152;

    @FindBy(xpath = "//*[@id=\"b24-b24-site-button-form-4\"]/div/div[2]/div/div/div[2]/div[2]/form/div[3]/div/button")
    private WebElement sendFeedbackBtn;

    public void clickCloseBtn() {
        closeBtn.click();
    }

    public void clearInputFirstName() {
        inputFirstName.clear();
    }
    public void setInputFirstName(String inputFirstNameValue) {
        inputFirstName.sendKeys(inputFirstNameValue);
    }
}
