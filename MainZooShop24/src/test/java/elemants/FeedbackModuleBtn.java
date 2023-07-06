package elemants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeedbackModuleBtn {
    public WebDriver driver;

    public FeedbackModuleBtn(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div[3]/div[2]/div[2]/div[1]/div[1]")
    private WebElement backgroundButton;

    public void clickLoginBtn() {
        backgroundButton.click();
    }
}
