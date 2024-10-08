package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

@Feature("Issue в репозитории")
@Story("Проверка наличия Issue")

public class StepsTest {

    private static final String REPOSITORY = "DariaS2302/Homework_08.10";

    @Test
    @DisplayName("Проверка наличия Issue в репозитории с помощью lambda")
    @Owner("Daria Sarycheva")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Test page", url = "https://github.com/DariaS2302/Homework_08.10")

    public void lambdaStepTest() {
       SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
                    $(".header-search-button").click();
                    $("#query-builder-test").setValue(REPOSITORY).pressEnter();
                });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
                    $(linkText(REPOSITORY)).click();
                });
        step("Проверяем наличие Issue",  () -> {
            $("#issues-tab").shouldHave(text("Issues"));
                });
    }


    @Test
    @DisplayName("Проверка наличия Issue в репозитории с помощью шагов с аннотацией Step")
    @Owner("Daria Sarycheva")
    @Severity(SeverityLevel.TRIVIAL)
    @Link(value = "Test page", url = "https://github.com/DariaS2302/Homework_08.10")

    public void AnnotatedStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebTest steps = new WebTest();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.shouldSeeIssue();
    }

}
