import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotationSteps {

    private static final String REPO = "eroshenkoam/allure-example";
    private static final int num = 7;

    @Test
    void steps() {

        AnnotationStepsTest steps = new AnnotationStepsTest();

        steps.openMainPage();
        steps.searchForRepository(REPO);
        steps.openRepository(REPO);
        steps.openIssueTab();
        steps.checkIssueTab(num);

    }
}
