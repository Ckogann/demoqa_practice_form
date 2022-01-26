package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderRadio = $("#genterWrapper"),
            mobileNumberInput = $("#userNumber"),
            userSubjectsInput = $("#subjectsInput"),
            userHobbiesCheckbox = $("#hobbiesWrapper"),
            userPicture = $("#uploadPicture"),
            userCurrentAddress = $("#currentAddress"),
            clickOnState = $("#state"),
            clickOnCity = $("#city"),
            userStateCity = $("#stateCity-wrapper"),
            clickOnButton = $("#submit"),
            thanksForRegistration = $("#example-modal-sizes-title-lg"),
            resultTable = $(".table-responsive");

    public CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");

        return this;
    }

    public RegistrationPage typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage typeUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;
    }

    public RegistrationPage selectUserGender(String userGender) {
        userGenderRadio.$(byText(userGender)).click();

        return this;
    }

    public RegistrationPage typeMobileNumber(String mobileNumber) {
        mobileNumberInput.setValue(mobileNumber);

        return this;
    }

    public RegistrationPage typeUserSubjects(String userSubjects) {
        userSubjectsInput.setValue(userSubjects).pressEnter();

        return this;
    }

    public RegistrationPage selectUserHobbies(String userHobbies) {
        userHobbiesCheckbox.$(byText(userHobbies)).click();

        return this;
    }

    public RegistrationPage uploadUserPicture(String fileName) {
        userPicture.uploadFromClasspath(fileName);

        return this;
    }

    public RegistrationPage typeCurrentAddress(String userAddress) {
        userCurrentAddress.setValue(userAddress);

        return this;
    }

    public RegistrationPage scrollAndStatePush() {
        clickOnState.scrollTo().click();

        return this;
    }

    public RegistrationPage chooseStateAndCity(String stateOrCity) {
        userStateCity.$(byText(stateOrCity)).click();

        return this;
    }

    public RegistrationPage cityPush() {
        clickOnCity.click();

        return this;
    }

    public RegistrationPage submitRegistration() {
        clickOnButton.click();

        return this;
    }

    public RegistrationPage submittedUserForm(String thanksText) {
        thanksForRegistration.shouldHave(text(thanksText));

        return this;
    }

    public RegistrationPage checkRegistrationForm(String value) {
        resultTable.shouldHave(text(value));

        return this;
    }

//    public AnotherPage clickOnAnotherPage() {
//        $("").click();
//
//        return new AnotherPage();
//    }
}