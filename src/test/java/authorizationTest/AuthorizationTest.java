package authorizationTest;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AuthorizationTest extends TestBase {

    @Test
    @Tag("remote")
    @DisplayName("Проверка заполнения формы")
    @Story("Заполнеяния формы с фейкером")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("AlisherBaikenov")
    public void AuthorizationTest(){

        step("Открытие сайта",()->{
            open("customer/login");

        });
        step("Авторизация",()->{
            $("#log-name").setValue("demo");
            $("#log-pass").setValue("Password7!");
            $("[data-qa=customer-login_auth-form_login-button]").click();
        });
        step("Проверяем открытия сайта",()->{
            $("[data-tour-hint=main-layout-sider]").shouldHave(text("Помощь"));
        });
        step("Создаем платеж",()->{
            $("[data-qa=navigation_payments_and_transfers]").click();
            $(".doc-ctrl-add").click();
        });
    }
}
