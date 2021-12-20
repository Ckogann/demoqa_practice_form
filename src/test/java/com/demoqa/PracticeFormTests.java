package com.demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {
    @Test
    void practiceForm() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Тест");
        $("#lastName").setValue("Тестов");
        $("#userEmail").setValue("mail@mail.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__year-select").selectOptionByValue("1990");
        $(".react-datepicker__day.react-datepicker__day--006[aria-label='Choose Wednesday, June 6th, 1990']").click();
        $("#subjectsInput").setValue("Computer").pressEnter();
        $("#subjectsInput").setValue("English").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFile(new File("src/test/java/media/Hello.txt"));
        $("#currentAddress").setValue("Rostov-on-Don");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Тест"), text("Тестов"), text("mail@mail.com"),
                text("Male"), text("1234567890"), text("06 June,1990"), text("Computer Science, English"),
                text("Sports"), text("Hello.txt"), text("Rostov-on-Don"), text("NCR Delhi"));
    }
}