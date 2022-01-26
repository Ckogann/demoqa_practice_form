package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class PracticeFormTestsWithPageObjects extends TestBase {

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String mobileNumber = faker.number().digits(10);
    String userAddress = faker.address().streetAddress();

    String userGender = "Male";
    String userSubject1 = "Computer Science";
    String userSubject2 = "English";
    String userHobbies = "Sports";
    String userState = "NCR";
    String userCity = "Delhi";

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void practiceForm() {
        registrationPage.openPage()
                        .typeFirstName(firstName)
                        .typeLastName(lastName)
                        .typeUserEmail(userEmail)
                        .selectUserGender(userGender)
                        .typeMobileNumber(mobileNumber)
                        .calendarComponent.setDate()
                        .typeUserSubjects(userSubject1).typeUserSubjects(userSubject2)
                        .selectUserHobbies(userHobbies)
                        .uploadUserPicture("img/1.png") // вариант с папкой resources внутри папки test
                        .typeCurrentAddress(userAddress)
                        .scrollAndStatePush()
                        .chooseStateAndCity(userState)
                        .cityPush()
                        .chooseStateAndCity(userCity)
                        .submitRegistration()

                        .submittedUserForm("Thanks for submitting the form")
                        .checkRegistrationForm(firstName)
                        .checkRegistrationForm(lastName)
                        .checkRegistrationForm(userEmail)
                        .checkRegistrationForm(userGender)
                        .checkRegistrationForm(mobileNumber)
                        .checkRegistrationForm("06 June,1990")
                        .checkRegistrationForm(userSubject1 + ", " + userSubject2)
                        .checkRegistrationForm(userHobbies)
                        .checkRegistrationForm("1.png")
                        .checkRegistrationForm(userAddress)
                        .checkRegistrationForm(userState + " " + userCity);
    }
}