package elements;

import helpers.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.Random;

public class FeedbackModuleContent {
    private String state = "";
    private WebDriver driver;
    private final By openFeedbackBtn = By.xpath(".//div[@class='b24-widget-button-icon-container']/div[1]");
    private final By contentFeedbackWindow = By.xpath(".//div[@class='b24-window-panel b24-window-panel-pos-right']/button/..");
    private final By closeFeedbackBtn = By.xpath(".//div[@class='b24-window-panel b24-window-panel-pos-right']/button");

    private final By inputName = By.name("name");
    private final By warningMessageInputName = By.xpath(".//input[@name='name']/../div[2]");
    private final By inputLastName = By.name("lastname");
    private final By warningMessageInputLastName = By.xpath(".//input[@name='lastname']/../div[2]");
    private final By inputPhone = By.name("phone");
    private final By warningMessageInputPhone = By.xpath(".//input[@name='phone']/../div[2]");
    private final By inputEmail = By.name("email");
    private final By warningMessageInputEmail = By.xpath(".//input[@name='email']/../div[2]");
    private final By inputComments = By.xpath(".//textarea[@class='b24-form-control']");
    private final By warningMessageInputComments = By.xpath(".//textarea[@class='b24-form-control']/../div[2]");
    private final By checkBoxFz152 = By.xpath(".//label[@class='b24-form-control-container']/input");
    private final By warningMessageCheckBoxFz152 = By.xpath(".//label[@class='b24-form-control-container']/div");
    private final By arrowUpScrollBtn = By.xpath(".//button[@class='b24-window-scroll-arrow-up']");
    private final By arrowDownScrollBtn = By.xpath(".//button[@class='b24-window-scroll-arrow-down']");
    private final By sendBtn = By.xpath(".//form/div[@class='b24-form-btn-container']/div/button");

    public FeedbackModuleContent(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void saveState(String value) {
        this.state = value;
    }

    public String getState() {
        return this.state;
    }

    public void resetState() {
        this.state = "";
    }
    public void clickOpenBtn() {
        driver.findElement(openFeedbackBtn)
                .click();
        Utils.delay(1500);
    }

    public boolean contentFeedbackWindowIsVisiable() {
        return driver.findElement(contentFeedbackWindow)
                .isDisplayed();
    }
    public void clickCloseBtn() {
        driver.findElement(closeFeedbackBtn)
                .click();
        Utils.delay(1500);
    }

    public void clickArrowUpBtn() {
        if (driver.findElement(arrowUpScrollBtn).isEnabled()) {
            driver.findElement(arrowUpScrollBtn)
                    .click();
            Utils.delay(1500);
        }

    }

    public void clickArrowDownBtn() {
        if (driver.findElement(arrowDownScrollBtn).isEnabled()) {
            driver.findElement(arrowDownScrollBtn)
                    .click();
            Utils.delay(1500);
        }
    }

    public void clearInputName() {
        driver.findElement(inputName).clear();
        Utils.delay(1500);
    }

    public void clearInputLastName() {
        driver.findElement(inputLastName).clear();
        Utils.delay(1500);
    }

    public void clearInputPhone() {
        driver.findElement(inputPhone).clear();
        Utils.delay(1500);
    }

    public void clearInputEmail() {
        driver.findElement(inputEmail).clear();
        Utils.delay(1500);
    }

    public void clearInputComments() {
        driver.findElement(inputComments).clear();
        Utils.delay(1500);
    }

    public void changeValueText(String elementName, String mode, int maxLength, boolean dashIsExist) {
        if (driver.findElement(inputName).isEnabled()) {
            Random rand = new Random();
            int randomLength = rand.nextInt(maxLength - 10) + 1;
            String startValue = "";
            String finalValue;

            switch (mode) {
                case "rus":
                    startValue = Utils.generateRussianText(randomLength);
                    break;
                case "eng":
                    startValue = Utils.generateEnglishText(randomLength);
                    break;
                default:
                    break;
            }

            finalValue = startValue.substring(0, 1).toUpperCase() + startValue.substring(1);
            if (dashIsExist) {
                int separatorIndexFirst = 0;
                if (elementName.endsWith("inputLastName")) {
                    separatorIndexFirst = finalValue.length() / 3;
                    int separatorIndexSecond = finalValue.length() - separatorIndexFirst;
                    if (finalValue.length() % 3 == 2) {
                        separatorIndexFirst++;
                    }
                    finalValue = finalValue.substring(0, separatorIndexFirst) + "-" +
                                finalValue.substring(separatorIndexFirst, separatorIndexSecond) + "-" +
                                finalValue.substring(separatorIndexSecond);
                } else {
                    separatorIndexFirst = finalValue.length() / 2;
                    finalValue = finalValue.substring(0, separatorIndexFirst) + "-" + finalValue.substring(separatorIndexFirst);
                }
            }
            saveState(finalValue);
            Utils.delay(50);

            WebElement element;
            switch (elementName) {
                case "inputName":
                    element = driver.findElement(inputName);
                    break;
                case "inputLastName":
                    element = driver.findElement(inputLastName);
                    break;
                default:
                    return;
            }
            element.click();
            Utils.sendKeysWithDelay(element, finalValue);
            Utils.delay(1500);
        }
    }

    public void changeValuePhone(String codeCountry) {
        String phone = codeCountry;
        if (codeCountry.length() == 1) {
            phone += Utils.generateNumberText(10);
        } else {
            phone += Utils.generateNumberText(12 - codeCountry.length());
        }
        saveState(phone);
        Utils.sendKeysWithDelay(driver.findElement(inputPhone), phone);
    }

    public void changeValueEmail(String mode, boolean toggleNumbers, boolean toggleSymbols) {
        int emailSize = 20;
        String email = "";
        switch (mode) {
            case "rus": {
                if (toggleNumbers || toggleSymbols) {
                    if (toggleNumbers) {
                        email += Utils.generateRussianText(emailSize - 6) +
                                Utils.generateNumberText(6) + "@домен.рф";
                    }
                    if (toggleSymbols) {
                        email = "";
                        String symbols = ".-_";
                        email += Utils.generateRussianText((emailSize - 5) / 2) +
                                symbols.charAt((int) (Math.random() * symbols.length())) +
                                Utils.generateRussianText((emailSize - 5) / 2) +
                                Utils.generateNumberText(6) + "@домен.рф";
                    }
                } else {
                    email += Utils.generateRussianText(emailSize) + "@домен.рф";
                }

                break;
            }
            case "eng": {
                if (toggleNumbers || toggleSymbols) {
                    if (toggleNumbers) {
                        email += Utils.generateEnglishText(emailSize - 6) +
                                Utils.generateNumberText(6) + "@gmail.com";
                    }
                    if (toggleSymbols) {
                        email = "";
                        String symbols = ".-_";
                        email += Utils.generateEnglishText((emailSize - 5) / 2) +
                                symbols.charAt((int) (Math.random() * symbols.length())) +
                                Utils.generateEnglishText((emailSize - 5) / 2) +
                                Utils.generateNumberText(6) + "@gmail.com";
                    }
                } else {
                    email += Utils.generateEnglishText(emailSize) + "@gmail.com";
                }
                break;
            }
            default:
                break;
        }
        saveState(email);
        Utils.sendKeysWithDelay(driver.findElement(inputEmail), email);
    }

    public void changeValueComments() {
        String comments = "";
        comments += Utils.shuffleString(
                Utils.generateNumberText(100) +
                    Utils.generateSymbolText(100) +
                    Utils.generateEnglishText(100));
        saveState(comments);
        Utils.sendKeysWithDelay(driver.findElement(inputComments), comments);
    }

    public String getValue(String elementName) {
        String result = "";
        switch (elementName){
            case "inputName": {
                if (driver.findElement(inputName).isEnabled()) {
                    result =  driver.findElement(inputName)
                                    .getText();
                }
                break;
            }
            case "inputLastName": {
                if (driver.findElement(inputLastName).isEnabled()) {
                    result =  driver.findElement(inputLastName)
                                    .getText();
                }
                break;
            }
            case "inputPhone": {
                if (driver.findElement(inputPhone).isEnabled()) {
                    result =  driver.findElement(inputPhone)
                                    .getText()
                                    .replaceAll("-", "");
                }
                break;
            }
            case "inputEmail": {
                if (driver.findElement(inputEmail).isEnabled()) {
                    result =  driver.findElement(inputEmail)
                            .getText();
                }
                break;
            }
            case "inputComments": {
                if (driver.findElement(inputComments).isEnabled()) {
                    result =  driver.findElement(inputComments)
                            .getText();
                }
                break;
            }
            default:
                break;
        }
        return result;
    }

    public boolean nameWarningIsVisiable() {
        if (driver.findElement(warningMessageInputName).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean lastNameWarningIsVisiable() {
        if (driver.findElement(warningMessageInputLastName).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean phoneWarningIsVisiable() {
        if (driver.findElement(warningMessageInputPhone).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean emailWarningIsVisiable() {
        if (driver.findElement(warningMessageInputEmail).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean commentWarningIsVisiable() {
        if (driver.findElement(warningMessageInputComments).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean fz152WarningIsVisiable() {
        if (driver.findElement(warningMessageCheckBoxFz152).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void clickSendBtn() {
        if (driver.findElement(sendBtn).isDisplayed()) {
            driver.findElement(sendBtn)
                    .click();
            Utils.delay(1500);
        }
    }
}
