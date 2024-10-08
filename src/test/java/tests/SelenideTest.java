package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    public void issueSearchSelenideTest() {
       SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-button").click();
        $("#query-builder-test").setValue("DariaS2302/Homework_08.10").pressEnter();
        $(linkText("DariaS2302/Homework_08.10")).click();
        $("#issues-tab").shouldHave(text("Issues"));
    }

}
