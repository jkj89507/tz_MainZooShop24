package elements;

import helpers.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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

    private final By inputCommentsNotEmpty = By.xpath(".//textarea[@class='b24-form-control b24-form-control-not-empty']");
    private final By warningMessageInputComments = By.xpath(".//textarea[@class='b24-form-control b24-form-control-not-empty']/../div[2]");
    private final By warningMessageInputCommentsIsEmpty = By.xpath(".//textarea[@class='b24-form-control']/../div[2]");
    private final By checkBoxFz152 = By.xpath(".//label[@class='b24-form-control-container']/input");
    private final By moduleWindowFz152 = By.xpath(".//div[@class='b24-window-popup-wrapper']");
    private final By moduleWindowFz152CloseBtn = By.xpath(".//div[@class='b24-window-popup-wrapper']/button");
    private final By moduleWindowFz152DownScrollBtn = By.xpath(".//div[@class='b24-form-scroll-textable-arrow']");
    private final By moduleWindowFz152AccessBtn = By.xpath(".//div[@class='b24-window-popup-wrapper']/div/div/div[3]/div/div[2]/div[1]/button");
    private final By moduleWindowFz152CancelBtn = By.xpath(".//div[@class='b24-window-popup-wrapper']/div/div/div[3]/div/div[2]/div[2]/button");
    private final By warningMessageCheckBoxFz152 = By.xpath(".//label[@class='b24-form-control-container']/div");
    private final By arrowUpScrollBtn = By.xpath(".//button[@class='b24-window-scroll-arrow-up']");
    private final By arrowDownScrollBtn = By.xpath(".//button[@class='b24-window-scroll-arrow-down']");
    private final By sendBtn = By.xpath(".//form/div[@class='b24-form-btn-container']/div/button");
    private final By successWindow = By.xpath(".//div[@class='b24-form-state b24-form-success']");

    /**
     * Конструкто для класса FeedbackModuleContent,
     * определяющий методы и элементы для работы
     * с формой обратной связи на сайте https://zooshoptest.ru
     *
     * @param driver Web-драйвер для работы с браузером
     */
    public FeedbackModuleContent(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Метод сохранения состояни для строк
     *
     * @param value значение для сохранения
     */
    private void saveState(String value) {
        this.state = value;
    }

    /**
     * Метод получения значения строки состояния
     *
     * @return значения строки состояния
     */
    public String getState() {
        return this.state;
    }

    /**
     * Метод сброса значения строки состояния
     */
    public void resetState() {
        this.state = "";
    }

    /**
     * Метод для нажатия кнопки "Открыть форму обратной связи"
     */
    public void clickOpenBtn() {
        driver.findElement(openFeedbackBtn)
                .click();
        Utils.delay(1500);
    }

    /**
     * Метод проверки отоброжения формы обратной связи
     *
     * @return состояние отоброжения true/false
     */
    public boolean contentFeedbackWindowIsVisiable() {
        return driver.findElement(contentFeedbackWindow)
                .isDisplayed();
    }

    /**
     * Метод проверки отоброжения модального окна
     * "О персональных данных"
     *
     * @return состояние отоброжения true/false
     */
    public boolean moduleWindowFz152IsVisiable() {
        return driver.findElement(moduleWindowFz152)
                .isDisplayed();
    }

    /**
     * Метод проверки отоброжения успешной отправки
     * данных из формы обратной связи
     *
     * @return состояние отоброжения true/false
     */
    public boolean successWindowIsVisiable() {
        return driver.findElement(successWindow)
                .isDisplayed();
    }

    /**
     * Метод для нажатия по кнопке "Закрыть" формы обратной связи
     * с задержкой после исполнения 1.5 сек
     */
    public void clickCloseBtn() {
        driver.findElement(closeFeedbackBtn)
                .click();
        Utils.delay(1500);
    }

    /**
     * Метод для нажатия по кнопке "Прокрутка вверх" формы обратной связи
     * с задержкой после исполнения 1.5 сек
     */
    public void clickArrowUpBtn() {
        if (driver.findElement(arrowUpScrollBtn).isEnabled()) {
            driver.findElement(arrowUpScrollBtn)
                    .click();
            Utils.delay(1500);
        }

    }

    /**
     * Метод для нажатия по кнопке "Прокрутка вниз" формы обратной связи
     * с задержкой после исполнения 1.5 сек
     */
    public void clickArrowDownBtn() {
        if (driver.findElement(arrowDownScrollBtn).isEnabled()) {
            driver.findElement(arrowDownScrollBtn)
                    .click();
            Utils.delay(1500);
        }
    }

    /**
     * Метод для нажатия по чек-боксу "Соглашение о предоставлении ПДн"
     * с задержкой после исполнения 1.5 сек
     */
    public void clickCheckBoxFz152() {
        if (driver.findElement(checkBoxFz152).isEnabled()) {
            driver.findElement(checkBoxFz152)
                    .click();
            Utils.delay(1500);
        }
    }

    /**
     * Метод для нажатия по кнопке "Закрыть" для модального окна
     * "О персональных данных" с задержкой после исполнения 1.5 сек
     */
    public void clickModuleWindowFz152CloseBtn() {
        if (driver.findElement(moduleWindowFz152CloseBtn).isEnabled()) {
            driver.findElement(moduleWindowFz152CloseBtn)
                    .click();
            Utils.delay(1500);
        }
    }

    /**
     * Метод для нажатия по кнопке "Прокрутка вниз" для модального окна
     * "О персональных данных" с задержкой после исполнения 1.5 сек
     */
    public void clickModuleWindowFz152DownScrollBtn() {
        if (driver.findElement(moduleWindowFz152DownScrollBtn).isEnabled()) {
            driver.findElement(moduleWindowFz152DownScrollBtn)
                    .click();
            Utils.delay(1500);
        }
    }

    /**
     * Метод для нажатия по кнопке "Принимаю" для модального окна
     * "О персональных данных" с задержкой после исполнения 1.5 сек
     */
    public void clickModuleWindowFz152AccessBtn() {
        if (driver.findElement(moduleWindowFz152AccessBtn).isEnabled()) {
            driver.findElement(moduleWindowFz152AccessBtn)
                    .click();
            Utils.delay(1500);
        }
    }

    /**
     * Метод для нажатия по кнопке "Не принимаю" для модального окна
     * "О персональных данных" с задержкой после исполнения 1.5 сек
     */
    public void clickModuleWindowFz152CancelBtn() {
        if (driver.findElement(moduleWindowFz152CancelBtn).isEnabled()) {
            driver.findElement(moduleWindowFz152CancelBtn)
                    .click();
            Utils.delay(1500);
        }
    }

    /**
     * Метод очистки поля Имя
     */
    public void clearInputName() {
        driver.findElement(inputName).clear();
        Utils.delay(1500);
    }

    /**
     * Метод очистки поля Фамилия
     */
    public void clearInputLastName() {
        driver.findElement(inputLastName).clear();
        Utils.delay(1500);
    }

    /**
     * Метод очистки поля Телефон
     */
    public void clearInputPhone() {
        driver.findElement(inputPhone).clear();
        Utils.delay(1500);
    }

    /**
     * Метод очистки поля E-mail
     */
    public void clearInputEmail() {
        driver.findElement(inputEmail).clear();
        Utils.delay(1500);
    }

    /**
     * Метод очистки поля Комментарий
     */
    public void clearInputComments() {
        driver.findElement(inputComments).clear();
        Utils.delay(1500);
    }

    /**
     * Метод очистки поля Комментарий
     */
    public void clearNotEmtyInputComments() {
        driver.findElement(inputCommentsNotEmpty).clear();
        Utils.delay(1500);
    }


    /**
     * Метод изменения значения для полей ввода Имя и Фамилия
     *
     * @param elementName Web-элемент для ввода значения
     * @param mode язык вводимого значения
     * @param maxLength макс.длина вводимого значения
     * @param dashIsExist существует ли пробел в вводимом
     *                    значении true/false
     */
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

    /**
     * Метод ввода значения для поля Телефон
     *
     * @param codeCountry код страны от 1ого
     *                    до 3х символов
     */
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

    /**
     * Метод ввода значения для поля E-mail
     *
     * @param mode язык вводимого значения
     * @param toggleNumbers переключатель есть ли в эл.почте цифры
     * @param toggleSymbols переключатель есть ли в эл.почте символы-разделители
     */
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
                                symbols.charAt((int)(Math.random() * symbols.length())) +
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
                                symbols.charAt((int)(Math.random() * symbols.length())) +
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

    /**
     * Метод ввода значения для поля Комментарий
     */
    public void changeValueComments() {
        String comments = "";
        comments += Utils.shuffleString(
                Utils.generateNumberText(100) +
                        Utils.generateSymbolText(100) +
                        Utils.generateEnglishText(100));
        saveState(comments);
        Utils.sendKeysWithDelay(driver.findElement(inputComments), comments);
    }

    /**
     * Метод получения значения из поля ввода по его названию
     *
     * @param elementName название поля ввода (inputName, inputLastName
     *                    inputPhone, inputEmail, inputComments)
     * @return значение поля ввода
     */
    public String getValue(String elementName) {
        String result = "";
        switch (elementName) {
            case "inputName": {
                if (driver.findElement(inputName).isEnabled()) {
                    result = driver.findElement(inputName)
                            .getText();
                }
                break;
            }
            case "inputLastName": {
                if (driver.findElement(inputLastName).isEnabled()) {
                    result = driver.findElement(inputLastName)
                            .getText();
                }
                break;
            }
            case "inputPhone": {
                if (driver.findElement(inputPhone).isEnabled()) {
                    result = driver.findElement(inputPhone)
                            .getText()
                            .replaceAll("-", "");
                }
                break;
            }
            case "inputEmail": {
                if (driver.findElement(inputEmail).isEnabled()) {
                    result = driver.findElement(inputEmail)
                            .getText();
                }
                break;
            }
            case "inputComments": {
                if (driver.findElement(inputCommentsNotEmpty).isEnabled()) {
                    result = driver.findElement(inputCommentsNotEmpty)
                            .getAttribute("value");
                }
                break;
            }
            default:
                break;
        }
        return result;
    }

    /**
     * Метод проверки отображения предупреждения для поля Имя
     *
     * @return статус отображения true/false
     */
    public boolean nameWarningIsVisible() {
        return driver.findElement(warningMessageInputName).isDisplayed();
    }

    /**
     * Метод проверки отображения предупреждения для поля Фамилия
     *
     * @return статус отображения true/false
     */
    public boolean lastNameWarningIsVisible() {
        return driver.findElement(warningMessageInputLastName).isDisplayed();
    }

    /**
     * Метод проверки отображения предупреждения для поля Телефон
     *
     * @return статус отображения true/false
     */
    public boolean phoneWarningIsVisible() {
        return driver.findElement(warningMessageInputPhone).isDisplayed();
    }

    /**
     * Метод проверки отображения предупреждения для поля E-mail
     *
     * @return статус отображения true/false
     */
    public boolean emailWarningIsVisible() {
        return driver.findElement(warningMessageInputEmail).isDisplayed();
    }

    /**
     * Метод проверки отображения предупреждения для поля Комментарий
     *
     * @return статус отображения true/false
     */
    public boolean commentIsEmptyWarningIsVisible() {
        return driver.findElement(warningMessageInputCommentsIsEmpty).isDisplayed();
    }

    /**
     * Метод проверки отображения предупреждения для поля Комментарий
     *
     * @return статус отображения true/false
     */
    public boolean commentWarningIsVisible() {
        return driver.findElement(warningMessageInputComments).isDisplayed();
    }

    /**
     * Метод проверки отображения предупреждения для чек-бокса
     * "Соглашение о предоставлении ПДн"
     *
     * @return статус отображения true/false
     */
    public boolean fz152WarningIsVisible() {
        return driver.findElement(warningMessageCheckBoxFz152).isDisplayed();
    }

    /**
     * Метод нажатия кнопки Отправить с
     * задержкой после исполнения 2 сек
     */
    public void clickSendBtn() {
        if (driver.findElement(sendBtn).isDisplayed()) {
            driver.findElement(sendBtn)
                    .click();
            Utils.delay(2000);
        }
    }
}