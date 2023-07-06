import elemants.FeedbackModuleBtn;
import elemants.FeedbackModuleContent;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FeedbackModule {
    static WebDriver driver;
    static FeedbackModuleBtn feedbackModuleBtn;
    static FeedbackModuleContent feedbackModuleContent;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://zooshoptest.ru/");

        feedbackModuleBtn = new FeedbackModuleBtn(driver);
        feedbackModuleContent = new FeedbackModuleContent(driver);
    }

    @Test
    @Order(1)
    public void openBackgroundModuleTest() {
        feedbackModuleBtn.clickLoginBtn();
    }

    @Test
    @Order(2)
    public void clearFirstName() {
        feedbackModuleContent.clearInputFirstName();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Order(3)
    public void inputFirstName() throws InterruptedException {
        feedbackModuleContent.setInputFirstName("Hello");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Order(4)
    public void closeBackgroundModuleTest() throws InterruptedException {
        feedbackModuleContent.clickCloseBtn();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
