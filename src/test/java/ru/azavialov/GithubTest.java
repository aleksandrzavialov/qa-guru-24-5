package ru.azavialov;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @Test
    void testSelenideSoftAssertionsHaveJUnit5Text() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $$("[data-filterable-for=wiki-pages-filter]").shouldHave(size(1));
        $(byText("SoftAssertions")).shouldBe(visible).click();
        $("#user-content-3-using-junit5-extend-test-class").ancestor("h4").
                shouldHave(text("3. Using JUnit5 extend test class:")).
                shouldBe(visible);
        $("#user-content-3-using-junit5-extend-test-class").ancestor("h4").sibling(0).
                $$(".highlight span").shouldHave(sizeGreaterThan(0));
    }
}
