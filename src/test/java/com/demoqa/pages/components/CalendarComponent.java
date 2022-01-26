package com.demoqa.pages.components;

import com.demoqa.pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public RegistrationPage setDate() {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1990");
        $("[aria-label*='June 6th, 1990']").click();

        return new RegistrationPage();
    }
}