import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AnnotationStepsTest {

    private static final String REPO = "eroshenkoam/allure-example";

    @BeforeAll
    static void resolution() {
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    void closed() {
        Selenide.closeWebDriver();
    }

    @Test
    void steps() {

        AnnotationSteps steps = new AnnotationSteps();

        steps.openMainPage();
        steps.searchForRepository(REPO);
        steps.openRepository(REPO);
        steps.openIssueTab();
        steps.checkIssueTab();

    }
}
