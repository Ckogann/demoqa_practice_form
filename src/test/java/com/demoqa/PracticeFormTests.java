package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void practiceForm() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Тест");
        $("#lastName").setValue("Тестов");
        $("#userEmail").setValue("mail@mail.com");
//        $("[for=gender-radio-1]").click(); // тоже верно!
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").selectOptionByValue("4"); // тоже верно!
        $(".react-datepicker__month-select").selectOption("June");
//        $(".react-datepicker__year-select").selectOptionByValue("1990"); // тоже верно!
        $(".react-datepicker__year-select").selectOption("1990");
//        $(".react-datepicker__day.react-datepicker__day--006:not(.react-datepicker__day--outside-month)").click();
        $("[aria-label*='June 6th, 1990']").click();
        $("#subjectsInput").setValue("Computer").pressEnter();
        $("#subjectsInput").setValue("English").pressEnter();
//        $("[for=hobbies-checkbox-1]").click(); // тоже верно!
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png"); // вариант с папкой внутри test
//        $("#uploadPicture").uploadFromClasspath("Hello.txt"); // вариант с папкой внутри main (тестировщики практически не используют папку main)
        $("#currentAddress").setValue("Rostov-on-Don");
//        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
//        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Тест"), text("Тестов"), text("mail@mail.com"),
                text("Male"), text("1234567890"), text("06 June,1990"), text("Computer Science, English"),
                text("Sports"), text("1.png"), text("Rostov-on-Don"), text("NCR Delhi"));
    }
}