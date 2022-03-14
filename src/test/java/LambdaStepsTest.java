import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {

    private static final String REPO = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 7;

    @BeforeAll
    static void resolution() {
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    void closed() {
        Selenide.closeWebDriver();
    }

    @Test
    public void testLambdaSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {
            open("https://github.com");
        });
        step("Looking for " + REPO, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPO);
            $(".header-search-input").submit();
        });
        step("Open repository " + REPO, () -> {
            $(By.linkText("eroshenkoam/allure-example")).click();
        });
        step("Go to Issue tab", () -> {
            $(By.partialLinkText("Issues")).click();
            addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
        });
        step("Check existing Issue " + ISSUE_NUMBER, () -> {
            $(withText("#7")).should(Condition.visible);
        });
    }
}
