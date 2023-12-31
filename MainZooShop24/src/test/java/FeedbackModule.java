import elements.FeedbackModuleContent;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FeedbackModule {
    static WebDriver driver;
    static FeedbackModuleContent feedbackModuleContent;

    @BeforeAll
    public static void setUpBeforeAll() {
        System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://zooshoptest.ru/");
        feedbackModuleContent = new FeedbackModuleContent(driver);
    }

    @AfterAll
    public static void setUpAfterAll() {
        driver.quit();
    }

    @DisplayName("TC.1")
    @Test
    @Order(1)
    public void openFeedbackModuleTest() {
        feedbackModuleContent.clickOpenBtn();
        feedbackModuleContent.clickArrowDownBtn();
        feedbackModuleContent.clickArrowUpBtn();
        assertTrue(feedbackModuleContent.contentFeedbackWindowIsVisiable(), "TC.1 is Passed. Feedback has opened");

    }

    @DisplayName("TC.2")
    @Test
    @Order(2)
    public void closeFeedbackModuleTest() {
        feedbackModuleContent.clickCloseBtn();
        assertFalse(feedbackModuleContent.contentFeedbackWindowIsVisiable(), "TC.2 is Passed. Feedback has closed");
    }

    @DisplayName("TC.5")
    @Test
    @Order(3)
    public void changeInputNameEng() {
        feedbackModuleContent.clickOpenBtn();
        feedbackModuleContent.clickArrowDownBtn();
        feedbackModuleContent.clearInputName();
        feedbackModuleContent.changeValueText("inputName","eng", 100, false);
        feedbackModuleContent.clickSendBtn();
        if (!feedbackModuleContent.getState().endsWith(feedbackModuleContent.getValue("inputName"))) {
            assertFalse(true, "TC.5 is Failed. Inserted text and received text are different");
        } else {
            feedbackModuleContent.resetState();
            if (!feedbackModuleContent.nameWarningIsVisible() &&
                    !feedbackModuleContent.lastNameWarningIsVisible() &&
                    feedbackModuleContent.phoneWarningIsVisible() &&
                    !feedbackModuleContent.emailWarningIsVisible() &&
                    feedbackModuleContent.commentIsEmptyWarningIsVisible() &&
                    !feedbackModuleContent.fz152WarningIsVisible()
            ) {
                feedbackModuleContent.clearInputName();
                driver.navigate().refresh();
                assertTrue(true, "TC.5 is Passed. Input name is corrected");
            } else {
                assertFalse(true, "TC.5 is Failed. Incorrect behavior");
            }
        }
    }

    @DisplayName("TC.6")
    @Test
    @Order(4)
    public void changeInputNameEngWithDash() {
        feedbackModuleContent.clickOpenBtn();
        feedbackModuleContent.clickArrowDownBtn();
        feedbackModuleContent.clearInputName();
        feedbackModuleContent.changeValueText("inputName","eng", 100, true);
        feedbackModuleContent.clickSendBtn();
        if (!feedbackModuleContent.getState().endsWith(feedbackModuleContent.getValue("inputName"))) {
            assertFalse(true, "TC.6 is Failed. Inserted text and received text are different");
        } else {
            feedbackModuleContent.resetState();
            if (!feedbackModuleContent.nameWarningIsVisible() &&
                    !feedbackModuleContent.lastNameWarningIsVisible() &&
                    feedbackModuleContent.phoneWarningIsVisible() &&
                    !feedbackModuleContent.emailWarningIsVisible() &&
                    feedbackModuleContent.commentIsEmptyWarningIsVisible() &&
                    !feedbackModuleContent.fz152WarningIsVisible()
            ) {
                feedbackModuleContent.clearInputName();
                driver.navigate().refresh();
                assertTrue(true, "TC.6 is Passed. Input name is corrected");
            } else {
                assertFalse(true, "TC.6 is Failed. Incorrect behavior");
            }
        }
    }

    @DisplayName("TC.9")
    @Test
    @Order(5)
    public void changeInputLastNameEng() {
        feedbackModuleContent.clickOpenBtn();
        feedbackModuleContent.clickArrowDownBtn();
        feedbackModuleContent.clearInputLastName();
        feedbackModuleContent.changeValueText("inputLastName","eng", 200, false);
        feedbackModuleContent.clickSendBtn();
        if (!feedbackModuleContent.getState().endsWith(feedbackModuleContent.getValue("inputLastName"))) {
            assertFalse(true, "TC.9 is Failed. Inserted text and received text are different");
        } else {
            feedbackModuleContent.resetState();
            if (!feedbackModuleContent.nameWarningIsVisible() &&
                    !feedbackModuleContent.lastNameWarningIsVisible() &&
                    feedbackModuleContent.phoneWarningIsVisible() &&
                    !feedbackModuleContent.emailWarningIsVisible() &&
                    feedbackModuleContent.commentIsEmptyWarningIsVisible() &&
                    !feedbackModuleContent.fz152WarningIsVisible()
            ) {
                feedbackModuleContent.clearInputLastName();
                driver.navigate().refresh();
                assertTrue(true, "TC.9 is Passed. Input lastname is corrected");
            } else {
                assertFalse(true, "TC.9 is Failed. Incorrect behavior");
            }
        }
    }

    @DisplayName("TC.10")
    @Test
    @Order(6)
    public void changeInputLastNameEngWithDash() {
        feedbackModuleContent.clickOpenBtn();
        feedbackModuleContent.clickArrowDownBtn();
        feedbackModuleContent.clearInputLastName();
        feedbackModuleContent.changeValueText("inputLastName","eng", 200, true);
        feedbackModuleContent.clickSendBtn();
        if (!feedbackModuleContent.getState().endsWith(feedbackModuleContent.getValue("inputLastName"))) {
            assertFalse(true, "TC.10 is Failed. Inserted text and received text are different");
        } else {
            feedbackModuleContent.resetState();
            if (!feedbackModuleContent.nameWarningIsVisible() &&
                    !feedbackModuleContent.lastNameWarningIsVisible() &&
                    feedbackModuleContent.phoneWarningIsVisible() &&
                    !feedbackModuleContent.emailWarningIsVisible() &&
                    feedbackModuleContent.commentIsEmptyWarningIsVisible() &&
                    !feedbackModuleContent.fz152WarningIsVisible()
            ) {
                feedbackModuleContent.clearInputLastName();
                driver.navigate().refresh();
                assertTrue(true, "TC.10 is Passed. Input lastname is corrected");
            } else {
                assertFalse(true, "TC.10 is Failed. Incorrect behavior");
            }
        }
    }

    @DisplayName("TC.11")
    @Test
    @Order(7)
    public void changeInputPhoneCodeCountryLength1() {
        feedbackModuleContent.clickOpenBtn();
        feedbackModuleContent.clickArrowDownBtn();
        feedbackModuleContent.clearInputPhone();
        feedbackModuleContent.changeValuePhone("7");
        feedbackModuleContent.clickSendBtn();
        if (!feedbackModuleContent.getState().endsWith(feedbackModuleContent.getValue("inputPhone"))) {
            assertFalse(true, "TC.11 is Failed. Inserted text and received text are different");
        } else {
            feedbackModuleContent.resetState();
            if (!feedbackModuleContent.nameWarningIsVisible() &&
                    !feedbackModuleContent.lastNameWarningIsVisible() &&
                    !feedbackModuleContent.phoneWarningIsVisible() &&
                    !feedbackModuleContent.emailWarningIsVisible() &&
                    feedbackModuleContent.commentIsEmptyWarningIsVisible() &&
                    !feedbackModuleContent.fz152WarningIsVisible()
            ) {
                feedbackModuleContent.clearInputPhone();
                driver.navigate().refresh();
                assertTrue(true, "TC.11 is Passed. Input phone is corrected");
            } else {
                assertFalse(true, "TC.11 is Failed. Incorrect behavior");
            }
        }
    }

    @DisplayName("TC.12")
    @Test
    @Order(8)
    public void changeInputPhoneCodeCountryLength2() {
        feedbackModuleContent.clickOpenBtn();
        feedbackModuleContent.clickArrowDownBtn();
        feedbackModuleContent.clearInputPhone();
        feedbackModuleContent.changeValuePhone("44");
        feedbackModuleContent.clickSendBtn();
        if (!feedbackModuleContent.getState().endsWith(feedbackModuleContent.getValue("inputPhone"))) {
            assertFalse(true, "TC.12 is Failed. Inserted text and received text are different");
        } else {
            feedbackModuleContent.resetState();
            if (!feedbackModuleContent.nameWarningIsVisible() &&
                    !feedbackModuleContent.lastNameWarningIsVisible() &&
                    !feedbackModuleContent.phoneWarningIsVisible() &&
                    !feedbackModuleContent.emailWarningIsVisible() &&
                    feedbackModuleContent.commentIsEmptyWarningIsVisible() &&
                    !feedbackModuleContent.fz152WarningIsVisible()
            ) {
                feedbackModuleContent.clearInputPhone();
                driver.navigate().refresh();
                assertTrue(true, "TC.12 is Passed. Input phone is corrected");
            } else {
                assertFalse(true, "TC.12 is Failed. Incorrect behavior");
            }
        }
    }

    @DisplayName("TC.13")
    @Test
    @Order(9)
    public void changeInputPhoneCodeCountryLength3() {
        feedbackModuleContent.clickOpenBtn();
        feedbackModuleContent.clickArrowDownBtn();
        feedbackModuleContent.clearInputPhone();
        feedbackModuleContent.changeValuePhone("375");
        feedbackModuleContent.clickSendBtn();
        if (!feedbackModuleContent.getState().endsWith(feedbackModuleContent.getValue("inputPhone"))) {
            assertFalse(true, "TC.13 is Failed. Inserted text and received text are different");
        } else {
            feedbackModuleContent.resetState();
            if (!feedbackModuleContent.nameWarningIsVisible() &&
                    !feedbackModuleContent.lastNameWarningIsVisible() &&
                    !feedbackModuleContent.phoneWarningIsVisible() &&
                    !feedbackModuleContent.emailWarningIsVisible() &&
                    feedbackModuleContent.commentIsEmptyWarningIsVisible() &&
                    !feedbackModuleContent.fz152WarningIsVisible()
            ) {
                feedbackModuleContent.clearInputPhone();
                driver.navigate().refresh();
                assertTrue(true, "TC.13 is Passed. Input phone is corrected");
            } else {
                assertFalse(true, "TC.13 is Failed. Incorrect behavior");
            }
        }
    }

    @DisplayName("TC.17")
    @Test
    @Order(10)
    public void changeInputEmailOnlyText() {
        feedbackModuleContent.clickOpenBtn();
        feedbackModuleContent.clickArrowDownBtn();
        feedbackModuleContent.clearInputEmail();
        feedbackModuleContent.changeValueEmail("eng", false, false);
        feedbackModuleContent.clickSendBtn();
        if (!feedbackModuleContent.getState().endsWith(feedbackModuleContent.getValue("inputEmail"))) {
            assertFalse(true, "TC.17 is Failed. Inserted text and received text are different");
        } else {
            feedbackModuleContent.resetState();
            if (!feedbackModuleContent.nameWarningIsVisible() &&
                    !feedbackModuleContent.lastNameWarningIsVisible() &&
                    feedbackModuleContent.phoneWarningIsVisible() &&
                    !feedbackModuleContent.emailWarningIsVisible() &&
                    feedbackModuleContent.commentIsEmptyWarningIsVisible() &&
                    !feedbackModuleContent.fz152WarningIsVisible()
            ) {
                feedbackModuleContent.clearInputEmail();
                driver.navigate().refresh();
                assertTrue(true, "TC.17 is Passed. Input email is corrected");
            } else {
                assertFalse(true, "TC.17 is Failed. Incorrect behavior");
            }
        }
    }

    @DisplayName("TC.18")
    @Test
    @Order(11)
    public void changeInputEmailTextNumbers() {
        feedbackModuleContent.clickOpenBtn();
        feedbackModuleContent.clickArrowDownBtn();
        feedbackModuleContent.clearInputEmail();
        feedbackModuleContent.changeValueEmail("eng", true, false);
        feedbackModuleContent.clickSendBtn();
        if (!feedbackModuleContent.getState().endsWith(feedbackModuleContent.getValue("inputEmail"))) {
            assertFalse(true, "TC.18 is Failed. Inserted text and received text are different");
        } else {
            feedbackModuleContent.resetState();
            if (!feedbackModuleContent.nameWarningIsVisible() &&
                    !feedbackModuleContent.lastNameWarningIsVisible() &&
                    feedbackModuleContent.phoneWarningIsVisible() &&
                    !feedbackModuleContent.emailWarningIsVisible() &&
                    feedbackModuleContent.commentIsEmptyWarningIsVisible() &&
                    !feedbackModuleContent.fz152WarningIsVisible()
            ) {
                feedbackModuleContent.clearInputEmail();
                driver.navigate().refresh();
                assertTrue(true, "TC.18 is Passed. Input email is corrected");
            } else {
                assertFalse(true, "TC.18 is Failed. Incorrect behavior");
            }
        }
    }
    @DisplayName("TC.19")
    @Test
    @Order(12)
    public void changeInputEmailTextNumbersSymbols() {
        feedbackModuleContent.clickOpenBtn();
        feedbackModuleContent.clickArrowDownBtn();
        feedbackModuleContent.clearInputEmail();
        feedbackModuleContent.changeValueEmail("eng", true, true);
        feedbackModuleContent.clickSendBtn();
        if (!feedbackModuleContent.getState().endsWith(feedbackModuleContent.getValue("inputEmail"))) {
            assertFalse(true, "TC.19 is Failed. Inserted text and received text are different");
        } else {
            feedbackModuleContent.resetState();
            if (!feedbackModuleContent.nameWarningIsVisible() &&
                    !feedbackModuleContent.lastNameWarningIsVisible() &&
                    feedbackModuleContent.phoneWarningIsVisible() &&
                    !feedbackModuleContent.emailWarningIsVisible() &&
                    feedbackModuleContent.commentIsEmptyWarningIsVisible() &&
                    !feedbackModuleContent.fz152WarningIsVisible()
            ) {
                feedbackModuleContent.clearInputEmail();
                driver.navigate().refresh();
                assertTrue(true, "TC.19 is Passed. Input email is corrected");
            } else {
                assertFalse(true, "TC.19 is Failed. Incorrect behavior");
            }
        }
    }

    @DisplayName("TC.20")
    @Test
    @Order(13)
    public void changeInputComments() {
        feedbackModuleContent.clickOpenBtn();
        feedbackModuleContent.clickArrowDownBtn();
        feedbackModuleContent.clearInputComments();
        feedbackModuleContent.changeValueComments();
        feedbackModuleContent.clickSendBtn();
        if (!feedbackModuleContent.getState().endsWith(feedbackModuleContent.getValue("inputComments"))) {
            assertFalse(true, "TC.20 is Failed. Inserted text and received text are different");
        } else {
            feedbackModuleContent.resetState();
            if (!feedbackModuleContent.nameWarningIsVisible() &&
                    !feedbackModuleContent.lastNameWarningIsVisible() &&
                    feedbackModuleContent.phoneWarningIsVisible() &&
                    !feedbackModuleContent.emailWarningIsVisible() &&
                    !feedbackModuleContent.commentWarningIsVisible() &&
                    !feedbackModuleContent.fz152WarningIsVisible()
            ) {
                feedbackModuleContent.clearNotEmtyInputComments();
                driver.navigate().refresh();
                assertTrue(true, "TC.20 is Passed. Input comments is corrected");
            } else {
                assertFalse(true, "TC.20 is Failed. Incorrect behavior");
            }
        }
    }

    @DisplayName("TC.21")
    @Test
    @Order(14)
    public void switchCheckBoxFz152WithCloseBtn() {
        feedbackModuleContent.clickOpenBtn();
        feedbackModuleContent.clickArrowDownBtn();

        feedbackModuleContent.clearInputName();
        feedbackModuleContent.changeValueText("inputName","eng", 100, true);

        feedbackModuleContent.clearInputLastName();
        feedbackModuleContent.changeValueText("inputLastName","eng", 200, true);

        feedbackModuleContent.clearInputPhone();
        feedbackModuleContent.changeValuePhone("375");

        feedbackModuleContent.clearInputEmail();
        feedbackModuleContent.changeValueEmail("eng", true, true);

        feedbackModuleContent.clearInputComments();
        feedbackModuleContent.changeValueComments();

        feedbackModuleContent.clickCheckBoxFz152();
        if (feedbackModuleContent.moduleWindowFz152IsVisiable()) {
            feedbackModuleContent.clickModuleWindowFz152CloseBtn();
            if (!feedbackModuleContent.nameWarningIsVisible() &&
                    !feedbackModuleContent.lastNameWarningIsVisible() &&
                    !feedbackModuleContent.phoneWarningIsVisible() &&
                    !feedbackModuleContent.emailWarningIsVisible() &&
                    !feedbackModuleContent.commentWarningIsVisible() &&
                    feedbackModuleContent.fz152WarningIsVisible()
            ) {
                driver.navigate().refresh();
                assertTrue(true, "TC.21 is Passed. Checkbox FZ152 has diactivated");
            } else {
                assertFalse(true, "TC.21 is Failed. Checkbox FZ152 is still activating");
            }
        } else {
            assertFalse(true, "TC.21 is Failed. Modal window hasn't appeared");
        }
    }

    @DisplayName("TC.22")
    @Test
    @Order(15)
    public void switchCheckBoxFz152WithCancelBtn() {
        feedbackModuleContent.clickOpenBtn();
        feedbackModuleContent.clickArrowDownBtn();

        feedbackModuleContent.clearInputName();
        feedbackModuleContent.changeValueText("inputName","eng", 100, true);

        feedbackModuleContent.clearInputLastName();
        feedbackModuleContent.changeValueText("inputLastName","eng", 200, true);

        feedbackModuleContent.clearInputPhone();
        feedbackModuleContent.changeValuePhone("375");

        feedbackModuleContent.clearInputEmail();
        feedbackModuleContent.changeValueEmail("eng", true, true);

        feedbackModuleContent.clearInputComments();
        feedbackModuleContent.changeValueComments();

        feedbackModuleContent.clickCheckBoxFz152();
        if (feedbackModuleContent.moduleWindowFz152IsVisiable()) {
            feedbackModuleContent.clickModuleWindowFz152DownScrollBtn();
            feedbackModuleContent.clickModuleWindowFz152CancelBtn();
            if (!feedbackModuleContent.nameWarningIsVisible() &&
                    !feedbackModuleContent.lastNameWarningIsVisible() &&
                    !feedbackModuleContent.phoneWarningIsVisible() &&
                    !feedbackModuleContent.emailWarningIsVisible() &&
                    !feedbackModuleContent.commentWarningIsVisible() &&
                    feedbackModuleContent.fz152WarningIsVisible()
            ) {
                driver.navigate().refresh();
                assertTrue(true, "TC.22 is Passed. Checkbox FZ152 has diactivated");
            } else {
                assertFalse(true, "TC.22 is Failed. Checkbox FZ152 is still activating");
            }
        } else {
            assertFalse(true, "TC.22 is Failed. Modal window hasn't appeared");
        }
    }

    @DisplayName("TC.23")
    @Test
    @Order(16)
    public void switchCheckBoxFz152WithAccessBtn() {
        feedbackModuleContent.clickOpenBtn();
        feedbackModuleContent.clickArrowDownBtn();

        feedbackModuleContent.clearInputName();
        feedbackModuleContent.changeValueText("inputName","eng", 100, true);

        feedbackModuleContent.clearInputLastName();
        feedbackModuleContent.changeValueText("inputLastName","eng", 200, true);

        feedbackModuleContent.clearInputPhone();
        feedbackModuleContent.changeValuePhone("375");

        feedbackModuleContent.clearInputEmail();
        feedbackModuleContent.changeValueEmail("eng", true, true);

        feedbackModuleContent.clearInputComments();
        feedbackModuleContent.changeValueComments();

        feedbackModuleContent.clickCheckBoxFz152();
        if (feedbackModuleContent.moduleWindowFz152IsVisiable()) {
            feedbackModuleContent.clickModuleWindowFz152CloseBtn();
            if (!feedbackModuleContent.nameWarningIsVisible() &&
                    !feedbackModuleContent.lastNameWarningIsVisible() &&
                    !feedbackModuleContent.phoneWarningIsVisible() &&
                    !feedbackModuleContent.emailWarningIsVisible() &&
                    !feedbackModuleContent.commentWarningIsVisible() &&
                    feedbackModuleContent.fz152WarningIsVisible()
            ) {
                feedbackModuleContent.clickCheckBoxFz152();
                if (feedbackModuleContent.moduleWindowFz152IsVisiable()) {
                    feedbackModuleContent.clickModuleWindowFz152DownScrollBtn();
                    feedbackModuleContent.clickModuleWindowFz152AccessBtn();
                    feedbackModuleContent.clickSendBtn();
                    assertTrue(feedbackModuleContent.successWindowIsVisiable());
                } else {
                    assertFalse(true, "TC.23 is Failed. Modal window hasn't appeared");
                }
            } else {
                assertFalse(true, "TC.23 is Failed. Checkbox FZ152 is still activating");
            }
        } else {
            assertFalse(true, "TC.23 is Failed. Modal window hasn't appeared");
        }
    }
}
