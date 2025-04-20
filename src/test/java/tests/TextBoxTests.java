package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeall() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {

        open("/text-box");
        $("#userName").setValue("Raul");
        $("#userEmail").setValue("raul@test.com");
        $("#currentAddress").setValue("Word streert 1");
        $("#permanentAddress").setValue("Another street 1");
        $("#submit").click();

        $("#output #name").shouldHave(text("Raul"));
        $("#output #email").shouldHave(text("raul@test.com"));
        $("#output #currentAddress").shouldHave(text("Word streert 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 1"));
    }
}
