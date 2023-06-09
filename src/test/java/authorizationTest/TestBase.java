package authorizationTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import authorizationTest.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {
    @BeforeAll
    static void beforAll (){
        Configuration.baseUrl =  System.getProperty("base_url", "https://demo-business.berekebank.kz/");

        Configuration.browser =  System.getProperty("browser", "chrome");

        Configuration.browserVersion = System.getProperty("browser_version", "100.0");

        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");

        Configuration.remote = System.getProperty("remote_driver", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
    @BeforeEach
    void addListener(){
        SelenideLogger.addListener("AllureSelenide",new AllureSelenide());
    }
    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}

